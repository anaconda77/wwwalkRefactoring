package wwwalk.wwwalk.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.crypto.password.PasswordEncoder;
import wwwalk.wwwalk.repository.MemberRepository;

/**
 * Bean definitions for {@link MemberService}.
 */
@Generated
public class MemberService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'memberService'.
   */
  private static BeanInstanceSupplier<MemberService> getMemberServiceInstanceSupplier() {
    return BeanInstanceSupplier.<MemberService>forConstructor(MemberRepository.class, SessionManager.class, PasswordEncoder.class)
            .withGenerator((registeredBean, args) -> new MemberService(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'memberService'.
   */
  public static BeanDefinition getMemberServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MemberService.class);
    InstanceSupplier<MemberService> instanceSupplier = getMemberServiceInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(MemberService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
