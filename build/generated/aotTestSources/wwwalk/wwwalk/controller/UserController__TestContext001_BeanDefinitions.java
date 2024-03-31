package wwwalk.wwwalk.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import wwwalk.wwwalk.repository.MemberRepository;
import wwwalk.wwwalk.auth.TokenProvider;
import wwwalk.wwwalk.service.MemberService;

/**
 * Bean definitions for {@link MemberController}.
 */
@Generated
public class UserController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'userController'.
   */
  private static BeanInstanceSupplier<MemberController> getUserControllerInstanceSupplier() {
    return BeanInstanceSupplier.<MemberController>forConstructor(MemberService.class, MemberRepository.class, TokenProvider.class, AuthenticationManagerBuilder.class)
            .withGenerator((registeredBean, args) -> new MemberController(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'userController'.
   */
  public static BeanDefinition getUserControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MemberController.class);
    InstanceSupplier<MemberController> instanceSupplier = getUserControllerInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(UserController__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
