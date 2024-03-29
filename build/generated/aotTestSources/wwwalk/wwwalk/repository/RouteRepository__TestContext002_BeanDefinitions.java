package wwwalk.wwwalk.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import wwwalk.wwwalk.service.SessionManager;

/**
 * Bean definitions for {@link RouteRepository}.
 */
@Generated
public class RouteRepository__TestContext002_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'routeRepository'.
   */
  private static BeanInstanceSupplier<RouteRepository> getRouteRepositoryInstanceSupplier() {
    return BeanInstanceSupplier.<RouteRepository>forConstructor(JPAQueryFactory.class, EntityManager.class, SessionManager.class)
            .withGenerator((registeredBean, args) -> new RouteRepository(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'routeRepository'.
   */
  public static BeanDefinition getRouteRepositoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RouteRepository.class);
    InstanceSupplier<RouteRepository> instanceSupplier = getRouteRepositoryInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(RouteRepository__TestContext002_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
