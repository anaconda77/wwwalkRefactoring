package wwwalk.wwwalk.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link MemberController}.
 */
@Generated
public class UserController__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static MemberController apply(RegisteredBean registeredBean, MemberController instance) {
    AutowiredFieldValueResolver.forRequiredField("userService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("userRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("tokenProvider").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("authenticationManagerBuilder").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
