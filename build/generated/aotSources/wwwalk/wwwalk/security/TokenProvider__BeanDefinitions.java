package wwwalk.wwwalk.security;

import java.lang.Long;
import java.lang.String;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TokenProvider}.
 */
@Generated
public class TokenProvider__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'tokenProvider'.
   */
  private static BeanInstanceSupplier<TokenProvider> getTokenProviderInstanceSupplier() {
    return BeanInstanceSupplier.<TokenProvider>forConstructor(String.class, Long.class)
            .withGenerator((registeredBean, args) -> new TokenProvider(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'tokenProvider'.
   */
  public static BeanDefinition getTokenProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TokenProvider.class);
    beanDefinition.setInstanceSupplier(getTokenProviderInstanceSupplier());
    return beanDefinition;
  }
}
