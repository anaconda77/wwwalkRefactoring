package wwwalk.wwwalk.email;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.thymeleaf.TemplateEngine;

/**
 * Bean definitions for {@link EmailContentBuilder}.
 */
@Generated
public class EmailContentBuilder__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'emailContentBuilder'.
   */
  private static BeanInstanceSupplier<EmailContentBuilder> getEmailContentBuilderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<EmailContentBuilder>forConstructor(TemplateEngine.class)
            .withGenerator((registeredBean, args) -> new EmailContentBuilder(args.get(0)));
  }

  /**
   * Get the bean definition for 'emailContentBuilder'.
   */
  public static BeanDefinition getEmailContentBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EmailContentBuilder.class);
    beanDefinition.setInstanceSupplier(getEmailContentBuilderInstanceSupplier());
    return beanDefinition;
  }
}
