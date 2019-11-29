package context;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.reflections.Reflections;

import annotation.Component;

public class ApplicationContext {
	Hashtable<String, Object> objTable = new Hashtable<String, Object>();

	public Object getBean(String key) {
		return objTable.get(key);
	}
	public void addBean(String name, Object obj) {
		objTable.put(name, obj);
	}

	public void injectDependency() throws Exception {
		for (String key : objTable.keySet()) {
			if(!key.startsWith("jndi.")) { //jndi의 경우 톰켓서버에서 제공한 객체이므로 의존 객체 주입이 안됨 
				callsettter(objTable.get(key)); // 나머지 객체는 셋터 메서드 호출 
			}
		} 

	}
	public void prepareObjectByAnnotation(String basePackage) throws Exception {
		Reflections reflector = new Reflections(basePackage);
		Set<Class<?>> list =reflector.getTypesAnnotatedWith(Component.class);
		String key = null;
		for (Class<?> clazz : list) {
			key = clazz.getAnnotation(Component.class).value();
			objTable.put(key, clazz.newInstance());
		}
	}

	public void prepareObjectsByProperties(String propertiesPath) throws Exception {
		Properties props = new Properties();
		props.load(new FileReader(propertiesPath));
		Context ctx = new InitialContext();
		String key = null;
		String value = null;
		for (Object item : props.keySet()) {
			key = (String) item;
			value = props.getProperty(key);
			if (key.startsWith("jndi.")) {
				objTable.put(key, ctx.lookup(value)); // 톰캣 서버에 등록된 객체를 찾음
			} else {
				objTable.put(key, Class.forName(value).newInstance()); // 인스턴스 생성
			}
		}

	}

	private void callsettter(Object object) throws Exception {
		Object dependency = null;
		for (Method m : object.getClass().getMethods()) {
			if (m.getName().startsWith("set")) {
				dependency = findObjectByTpe(m.getParameterTypes()[0]);
				if (dependency != null) {
					m.invoke(object, dependency);
				}
			}
		}

	}

	private Object findObjectByTpe(Class<?> type) {
		for (Object obj : objTable.values()) {
			if (type.isInstance(obj)) {
				return obj;
			}
		}
		return null;
	}

}
