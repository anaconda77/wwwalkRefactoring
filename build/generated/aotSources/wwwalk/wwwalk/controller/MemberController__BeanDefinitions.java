package wwwalk.wwwalk.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import wwwalk.wwwalk.auth.TokenProvider;
import wwwalk.wwwalk.repository.MemberRepository;
import wwwalk.wwwalk.service.MemberService;

/**
 * Bean definitions for {@link MemberController}.
 */
@Generated
public class MemberController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'memberController'.
   */
  private static BeanInstanceSupplier<MemberController> getMemberControllerInstanceSupplier() {
    return BeanInstanceSupplier.<MemberController>forConstructor(MemberService.class, MemberRepository.class, TokenProvider.class, AuthenticationManagerBuilder.class)
            .withGenerator((registeredBean, args) -> new MemberController(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'memberController'.
   */
  public static BeanDefinition getMemberControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MemberController.class);
    InstanceSupplier<MemberController> instanceSupplier = getMemberControllerInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(MemberController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
