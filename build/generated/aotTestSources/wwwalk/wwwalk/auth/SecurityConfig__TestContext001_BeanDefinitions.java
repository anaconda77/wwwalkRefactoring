package wwwalk.wwwalk.auth;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import wwwalk.wwwalk.exception.JwtAccessDeniedHandler;
import wwwalk.wwwalk.exception.JwtAuthentiactionEntryPoint;
import wwwalk.wwwalk.security.SecurityConfig$$SpringCGLIB$$0;

/**
 * Bean definitions for {@link SecurityConfig}.
 */
@Generated
public class SecurityConfig__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'securityConfig'.
   */
  private static BeanInstanceSupplier<SecurityConfig> getSecurityConfigInstanceSupplier() {
    return BeanInstanceSupplier.<SecurityConfig>forConstructor(TokenProvider.class, JwtAuthentiactionEntryPoint.class, JwtAccessDeniedHandler.class)
            .withGenerator((registeredBean, args) -> new SecurityConfig$$SpringCGLIB$$0(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'securityConfig'.
   */
  public static BeanDefinition getSecurityConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityConfig.class);
    beanDefinition.setTargetType(SecurityConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(SecurityConfig.class);
    beanDefinition.setInstanceSupplier(getSecurityConfigInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'passwordEncoder'.
   */
  private static BeanInstanceSupplier<PasswordEncoder> getPasswordEncoderInstanceSupplier() {
    return BeanInstanceSupplier.<PasswordEncoder>forFactoryMethod(SecurityConfig.class, "passwordEncoder")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SecurityConfig.class).passwordEncoder());
  }

  /**
   * Get the bean definition for 'passwordEncoder'.
   */
  public static BeanDefinition getPasswordEncoderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PasswordEncoder.class);
    beanDefinition.setInstanceSupplier(getPasswordEncoderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webSecurityCustomizer'.
   */
  private static BeanInstanceSupplier<WebSecurityCustomizer> getWebSecurityCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebSecurityCustomizer>forFactoryMethod(SecurityConfig.class, "webSecurityCustomizer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SecurityConfig.class).webSecurityCustomizer());
  }

  /**
   * Get the bean definition for 'webSecurityCustomizer'.
   */
  public static BeanDefinition getWebSecurityCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSecurityCustomizer.class);
    beanDefinition.setInstanceSupplier(getWebSecurityCustomizerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'securityFilterChain'.
   */
  private static BeanInstanceSupplier<SecurityFilterChain> getSecurityFilterChainInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SecurityFilterChain>forFactoryMethod(SecurityConfig.class, "securityFilterChain", HttpSecurity.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SecurityConfig.class).securityFilterChain(args.get(0)));
  }

  /**
   * Get the bean definition for 'securityFilterChain'.
   */
  public static BeanDefinition getSecurityFilterChainBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityFilterChain.class);
    beanDefinition.setInstanceSupplier(getSecurityFilterChainInstanceSupplier());
    return beanDefinition;
  }
}
