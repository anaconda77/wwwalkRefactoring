package org.springframework.boot.autoconfigure.security.servlet;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SpringBootWebSecurityConfiguration}.
 */
@Generated
public class SpringBootWebSecurityConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'springBootWebSecurityConfiguration'.
   */
  public static BeanDefinition getSpringBootWebSecurityConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringBootWebSecurityConfiguration.class);
    beanDefinition.setInstanceSupplier(SpringBootWebSecurityConfiguration::new);
    return beanDefinition;
  }
}
