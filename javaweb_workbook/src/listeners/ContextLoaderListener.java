package listeners;

// SqlSessionFactory 객체 준비
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import context.ApplicationContext;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
  static ApplicationContext applicationContext;
  
  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }
   
  @Override
  public void contextInitialized(ServletContextEvent event) {
    try {
      applicationContext = new ApplicationContext();
      
      String resource = "dao/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream); 
      //build 메서드를 호출해야만 sqlsessionfactory를 생성할 수 있다.      
      applicationContext.addBean("sqlSessionFactory", sqlSessionFactory); // 객체 등록
      
      //프로퍼티 파일 경로 알아내기
      ServletContext sc = event.getServletContext();
      String propertiesPath = sc.getRealPath(
          sc.getInitParameter("contextConfigLocation"));
      //프로퍼티 파일과 애노테이션에 설정된 대로 객체 생성
      applicationContext.prepareObjectsByProperties(propertiesPath);
      
      applicationContext.prepareObjectByAnnotation("");
      // 의존 객체 주입
      applicationContext.injectDependency();
      
    } catch(Throwable e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {}
}
