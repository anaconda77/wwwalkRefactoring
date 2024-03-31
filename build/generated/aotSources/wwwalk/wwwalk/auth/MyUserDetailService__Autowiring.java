package wwwalk.wwwalk.auth;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link MyUserDetailService}.
 */
@Generated
public class MyUserDetailService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static MyUserDetailService apply(RegisteredBean registeredBean,
      MyUserDetailService instance) {
    AutowiredFieldValueResolver.forRequiredField("memberRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
