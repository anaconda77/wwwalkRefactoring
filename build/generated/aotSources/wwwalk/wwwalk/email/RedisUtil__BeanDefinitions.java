package wwwalk.wwwalk.email;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RedisUtil}.
 */
@Generated
public class RedisUtil__BeanDefinitions {
  /**
   * Get the bean definition for 'redisUtil'.
   */
  public static BeanDefinition getRedisUtilBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedisUtil.class);
    InstanceSupplier<RedisUtil> instanceSupplier = InstanceSupplier.using(RedisUtil::new);
    instanceSupplier = instanceSupplier.andThen(RedisUtil__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
