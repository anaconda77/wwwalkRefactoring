package wwwalk.wwwalk.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link MemberController}.
 */
@Generated
public class MemberController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static MemberController apply(RegisteredBean registeredBean, MemberController instance) {
    AutowiredFieldValueResolver.forRequiredField("memberService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("memberRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("tokenProvider").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("authenticationManagerBuilder").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
