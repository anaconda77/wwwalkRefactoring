package org.springframework.data.web.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.data.querydsl.binding.QuerydslBindingsFactory;
import org.springframework.data.web.querydsl.QuerydslPredicateArgumentResolver;

/**
 * Bean definitions for {@link QuerydslWebConfiguration}.
 */
@Generated
public class QuerydslWebConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'querydslWebConfiguration'.
   */
  public static BeanDefinition getQuerydslWebConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(QuerydslWebConfiguration.class);
    InstanceSupplier<QuerydslWebConfiguration> instanceSupplier = InstanceSupplier.using(QuerydslWebConfiguration::new);
    instanceSupplier = instanceSupplier.andThen(QuerydslWebConfiguration__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'querydslPredicateArgumentResolver'.
   */
  private static BeanInstanceSupplier<QuerydslPredicateArgumentResolver> getQuerydslPredicateArgumentResolverInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<QuerydslPredicateArgumentResolver>forFactoryMethod(QuerydslWebConfiguration.class, "querydslPredicateArgumentResolver")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(QuerydslWebConfiguration.class).querydslPredicateArgumentResolver());
  }

  /**
   * Get the bean definition for 'querydslPredicateArgumentResolver'.
   */
  public static BeanDefinition getQuerydslPredicateArgumentResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(QuerydslPredicateArgumentResolver.class);
    beanDefinition.setLazyInit(true);
    beanDefinition.setInstanceSupplier(getQuerydslPredicateArgumentResolverInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'querydslBindingsFactory'.
   */
  private static BeanInstanceSupplier<QuerydslBindingsFactory> getQuerydslBindingsFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<QuerydslBindingsFactory>forFactoryMethod(QuerydslWebConfiguration.class, "querydslBindingsFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(QuerydslWebConfiguration.class).querydslBindingsFactory());
  }

  /**
   * Get the bean definition for 'querydslBindingsFactory'.
   */
  public static BeanDefinition getQuerydslBindingsFactoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(QuerydslBindingsFactory.class);
    beanDefinition.setLazyInit(true);
    beanDefinition.setInstanceSupplier(getQuerydslBindingsFactoryInstanceSupplier());
    return beanDefinition;
  }
}
