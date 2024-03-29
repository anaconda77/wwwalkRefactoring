package wwwalk.wwwalk.repository;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RouteRepository}.
 */
@Generated
public class RouteRepository__TestContext002_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RouteRepository apply(RegisteredBean registeredBean, RouteRepository instance) {
    AutowiredFieldValueResolver.forRequiredField("queryFactory").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("em").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("sessionManager").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
