package wwwalk.wwwalk.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import wwwalk.wwwalk.repository.RouteRepository;
import wwwalk.wwwalk.service.RouteService;

/**
 * Bean definitions for {@link RouteController}.
 */
@Generated
public class RouteController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'routeController'.
   */
  private static BeanInstanceSupplier<RouteController> getRouteControllerInstanceSupplier() {
    return BeanInstanceSupplier.<RouteController>forConstructor(RouteRepository.class, RouteService.class)
            .withGenerator((registeredBean, args) -> new RouteController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'routeController'.
   */
  public static BeanDefinition getRouteControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RouteController.class);
    InstanceSupplier<RouteController> instanceSupplier = getRouteControllerInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(RouteController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
