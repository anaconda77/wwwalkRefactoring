package wwwalk.wwwalk.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SessionManager}.
 */
@Generated
public class SessionManager__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'sessionManager'.
   */
  public static BeanDefinition getSessionManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SessionManager.class);
    beanDefinition.setInstanceSupplier(SessionManager::new);
    return beanDefinition;
  }
}
