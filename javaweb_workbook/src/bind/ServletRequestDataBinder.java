package bind;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletRequest;

public class ServletRequestDataBinder {
	// 프런트 컨트롤러에서 호출하는 메서드 / 요청 매개변수 값과 데이터 이름, 타입을 받아서 데이터 객체를 만드는 역할 수행
	public static Object bind(ServletRequest request, Class<?> dataType, String dataName) throws Exception {
		//기본 타입인지 검사
		if (isPrimitiveType(dataType)) {
			// 기본 타입 생성 
			return createValueObject(dataType, request.getParameter(dataName));
		}

		Set<String> paramNames = request.getParameterMap().keySet();
		Object dataObject = dataType.newInstance();
		Method m = null;

		for (String paramName : paramNames) {
			m = findSetter(dataType, paramName); // 데이터 타입 클래스에서 매개변수와 일치하는 프로퍼티 찾기 
			if (m != null) {
				m.invoke(dataObject, createValueObject(m.getParameterTypes()[0], request.getParameter(paramName)));
			} // 셋터 메서드 찾으면 이전 생성 dataObejct 호출
		}
		return dataObject;
	}

	private static boolean isPrimitiveType(Class<?> type) {
		if (type.getName().equals("int") || type == Integer.class || type.getName().equals("long") || type == Long.class
				|| type.getName().equals("float") || type == Float.class || type.getName().equals("double")
				|| type == Double.class || type.getName().equals("boolean") || type == Boolean.class
				|| type == Date.class || type == String.class) {
			return true;
		}
		return false;
	}

	private static Object createValueObject(Class<?> type, String value) {
		if (type.getName().equals("int") || type == Integer.class) {
			return new Integer(value);
		} else if (type.getName().equals("float") || type == Float.class) {
			return new Float(value);
		} else if (type.getName().equals("double") || type == Double.class) {
			return new Double(value);
		} else if (type.getName().equals("long") || type == Long.class) {
			return new Long(value);
		} else if (type.getName().equals("boolean") || type == Boolean.class) {
			return new Boolean(value);
		} else if (type == Date.class) {
			return java.sql.Date.valueOf(value);
		} else {
			return value;
		}
	}
	// 클래스를 조사하여 주어진이름과 일치하는 섯터 메서드 찾기 
	private static Method findSetter(Class<?> type, String name) {
		Method[] methods = type.getMethods(); // 메서드 목록 얻기

		String propName = null;
		for (Method m : methods) {
			if (!m.getName().startsWith("set"))
				continue;

			propName = m.getName().substring(3);
			if (propName.toLowerCase().equals(name.toLowerCase())) {
				return m;
			}
		}
		return null;
	}
}
