package wwwalk.wwwalk.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import wwwalk.wwwalk.repository.UserRepository;

/**
 * Bean definitions for {@link UserService}.
 */
@Generated
public class UserService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'userService'.
   */
  private static BeanInstanceSupplier<UserService> getUserServiceInstanceSupplier() {
    return BeanInstanceSupplier.<UserService>forConstructor(UserRepository.class, SessionManager.class)
            .withGenerator((registeredBean, args) -> new UserService(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'userService'.
   */
  public static BeanDefinition getUserServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserService.class);
    InstanceSupplier<UserService> instanceSupplier = getUserServiceInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(UserService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
