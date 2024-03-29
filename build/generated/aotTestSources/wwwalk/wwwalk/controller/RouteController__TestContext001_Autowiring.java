package wwwalk.wwwalk.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RouteController}.
 */
@Generated
public class RouteController__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RouteController apply(RegisteredBean registeredBean, RouteController instance) {
    AutowiredFieldValueResolver.forRequiredField("routeRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("routeService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
