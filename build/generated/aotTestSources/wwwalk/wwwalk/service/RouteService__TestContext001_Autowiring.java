package wwwalk.wwwalk.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RouteService}.
 */
@Generated
public class RouteService__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RouteService apply(RegisteredBean registeredBean, RouteService instance) {
    AutowiredFieldValueResolver.forRequiredField("routeRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("sessionManager").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
