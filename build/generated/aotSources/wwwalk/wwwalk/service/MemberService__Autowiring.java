package wwwalk.wwwalk.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link MemberService}.
 */
@Generated
public class MemberService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static MemberService apply(RegisteredBean registeredBean, MemberService instance) {
    AutowiredFieldValueResolver.forRequiredField("memberRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("redisUtil").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("passwordEncoder").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("emailService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("emailContentBuilder").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
