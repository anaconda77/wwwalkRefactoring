package wwwalk.wwwalk.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import wwwalk.wwwalk.repository.RouteRepository;

/**
 * Bean definitions for {@link RouteService}.
 */
@Generated
public class RouteService__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'routeService'.
   */
  private static BeanInstanceSupplier<RouteService> getRouteServiceInstanceSupplier() {
    return BeanInstanceSupplier.<RouteService>forConstructor(RouteRepository.class, SessionManager.class)
            .withGenerator((registeredBean, args) -> new RouteService(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'routeService'.
   */
  public static BeanDefinition getRouteServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RouteService.class);
    InstanceSupplier<RouteService> instanceSupplier = getRouteServiceInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(RouteService__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
