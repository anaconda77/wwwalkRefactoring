package wwwalk.wwwalk.email;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * Bean definitions for {@link RedisConfig}.
 */
@Generated
public class RedisConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'redisConfig'.
   */
  public static BeanDefinition getRedisConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedisConfig.class);
    beanDefinition.setTargetType(RedisConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(RedisConfig.class);
    InstanceSupplier<RedisConfig> instanceSupplier = InstanceSupplier.using(RedisConfig$$SpringCGLIB$$0::new);
    instanceSupplier = instanceSupplier.andThen(RedisConfig__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'redisConnectionFactory'.
   */
  private static BeanInstanceSupplier<RedisConnectionFactory> getRedisConnectionFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RedisConnectionFactory>forFactoryMethod(RedisConfig.class, "redisConnectionFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(RedisConfig.class).redisConnectionFactory());
  }

  /**
   * Get the bean definition for 'redisConnectionFactory'.
   */
  public static BeanDefinition getRedisConnectionFactoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedisConnectionFactory.class);
    beanDefinition.setInstanceSupplier(getRedisConnectionFactoryInstanceSupplier());
    return beanDefinition;
  }
}
