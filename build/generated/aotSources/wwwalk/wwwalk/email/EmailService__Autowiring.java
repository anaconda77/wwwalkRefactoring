package wwwalk.wwwalk.email;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link EmailService}.
 */
@Generated
public class EmailService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static EmailService apply(RegisteredBean registeredBean, EmailService instance) {
    AutowiredFieldValueResolver.forRequiredField("emailSender").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
