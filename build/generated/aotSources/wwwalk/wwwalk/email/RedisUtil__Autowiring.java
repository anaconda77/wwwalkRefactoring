package wwwalk.wwwalk.email;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RedisUtil}.
 */
@Generated
public class RedisUtil__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RedisUtil apply(RegisteredBean registeredBean, RedisUtil instance) {
    AutowiredFieldValueResolver.forRequiredField("stringRedisTemplate").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
