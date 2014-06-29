package gbs.listeners;

// 프로퍼티 파일 적용 : ApplicationContext 사용
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextLoaderListener implements ServletContextListener {
  static ClassPathXmlApplicationContext applicationContext;
  
  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }
  
  @Override
  public void contextInitialized(ServletContextEvent event) {
    try {
      applicationContext = new ClassPathXmlApplicationContext("beans.xml");      
    } catch(Throwable e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {}
}
