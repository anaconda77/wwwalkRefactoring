package org.springframework.data.web.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link QuerydslWebConfiguration}.
 */
@Generated
public class QuerydslWebConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static QuerydslWebConfiguration apply(RegisteredBean registeredBean,
      QuerydslWebConfiguration instance) {
    instance.conversionService = AutowiredFieldValueResolver.forRequiredField("conversionService").resolve(registeredBean);
    instance.resolver = AutowiredFieldValueResolver.forRequiredField("resolver").resolve(registeredBean);
    instance.beanFactory = AutowiredFieldValueResolver.forRequiredField("beanFactory").resolve(registeredBean);
    return instance;
  }
}
