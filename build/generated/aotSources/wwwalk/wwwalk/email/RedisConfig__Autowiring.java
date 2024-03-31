package wwwalk.wwwalk.email;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RedisConfig}.
 */
@Generated
public class RedisConfig__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RedisConfig apply(RegisteredBean registeredBean, RedisConfig instance) {
    AutowiredFieldValueResolver.forRequiredField("host").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("port").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
