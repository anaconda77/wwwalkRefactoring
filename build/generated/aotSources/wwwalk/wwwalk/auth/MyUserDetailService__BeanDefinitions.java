package wwwalk.wwwalk.auth;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import wwwalk.wwwalk.repository.MemberRepository;

/**
 * Bean definitions for {@link MyUserDetailService}.
 */
@Generated
public class MyUserDetailService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'myUserDetailService'.
   */
  private static BeanInstanceSupplier<MyUserDetailService> getMyUserDetailServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MyUserDetailService>forConstructor(MemberRepository.class)
            .withGenerator((registeredBean, args) -> new MyUserDetailService(args.get(0)));
  }

  /**
   * Get the bean definition for 'myUserDetailService'.
   */
  public static BeanDefinition getMyUserDetailServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MyUserDetailService.class);
    InstanceSupplier<MyUserDetailService> instanceSupplier = getMyUserDetailServiceInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(MyUserDetailService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
