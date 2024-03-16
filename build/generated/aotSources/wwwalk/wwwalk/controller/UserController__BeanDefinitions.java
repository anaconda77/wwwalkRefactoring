package wwwalk.wwwalk.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import wwwalk.wwwalk.repository.UserRepository;
import wwwalk.wwwalk.service.UserService;

/**
 * Bean definitions for {@link UserController}.
 */
@Generated
public class UserController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'userController'.
   */
  private static BeanInstanceSupplier<UserController> getUserControllerInstanceSupplier() {
    return BeanInstanceSupplier.<UserController>forConstructor(UserService.class, UserRepository.class)
            .withGenerator((registeredBean, args) -> new UserController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'userController'.
   */
  public static BeanDefinition getUserControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserController.class);
    InstanceSupplier<UserController> instanceSupplier = getUserControllerInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(UserController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
