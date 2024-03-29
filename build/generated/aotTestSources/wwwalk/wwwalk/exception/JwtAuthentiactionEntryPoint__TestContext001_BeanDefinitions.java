package wwwalk.wwwalk.exception;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JwtAuthentiactionEntryPoint}.
 */
@Generated
public class JwtAuthentiactionEntryPoint__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'jwtAuthentiactionEntryPoint'.
   */
  public static BeanDefinition getJwtAuthentiactionEntryPointBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JwtAuthentiactionEntryPoint.class);
    beanDefinition.setInstanceSupplier(JwtAuthentiactionEntryPoint::new);
    return beanDefinition;
  }
}
