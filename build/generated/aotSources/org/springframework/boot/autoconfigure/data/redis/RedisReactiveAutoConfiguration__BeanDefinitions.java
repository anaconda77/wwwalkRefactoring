package org.springframework.boot.autoconfigure.data.redis;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RedisReactiveAutoConfiguration}.
 */
@Generated
public class RedisReactiveAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'redisReactiveAutoConfiguration'.
   */
  public static BeanDefinition getRedisReactiveAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedisReactiveAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(RedisReactiveAutoConfiguration::new);
    return beanDefinition;
  }
}
