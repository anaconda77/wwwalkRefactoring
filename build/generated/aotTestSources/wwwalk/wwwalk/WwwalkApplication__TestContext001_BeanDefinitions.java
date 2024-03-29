package wwwalk.wwwalk;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link WwwalkApplication}.
 */
@Generated
public class WwwalkApplication__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'wwwalkApplication'.
   */
  public static BeanDefinition getWwwalkApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WwwalkApplication.class);
    beanDefinition.setTargetType(WwwalkApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(WwwalkApplication.class);
    beanDefinition.setInstanceSupplier(WwwalkApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jpaQueryFactory'.
   */
  private static BeanInstanceSupplier<JPAQueryFactory> getJpaQueryFactoryInstanceSupplier() {
    return BeanInstanceSupplier.<JPAQueryFactory>forFactoryMethod(WwwalkApplication.class, "jpaQueryFactory", EntityManager.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WwwalkApplication.class).jpaQueryFactory(args.get(0)));
  }

  /**
   * Get the bean definition for 'jpaQueryFactory'.
   */
  public static BeanDefinition getJpaQueryFactoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JPAQueryFactory.class);
    beanDefinition.setInstanceSupplier(getJpaQueryFactoryInstanceSupplier());
    return beanDefinition;
  }
}
