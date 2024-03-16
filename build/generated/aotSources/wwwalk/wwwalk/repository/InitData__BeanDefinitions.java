package wwwalk.wwwalk.repository;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link InitData}.
 */
@Generated
public class InitData__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'initData'.
   */
  private static BeanInstanceSupplier<InitData> getInitDataInstanceSupplier() {
    return BeanInstanceSupplier.<InitData>forConstructor(InitData.InitService.class)
            .withGenerator((registeredBean, args) -> new InitData(args.get(0)));
  }

  /**
   * Get the bean definition for 'initData'.
   */
  public static BeanDefinition getInitDataBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(InitData.class);
    beanDefinition.setInitMethodNames("init");
    beanDefinition.setInstanceSupplier(getInitDataInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link InitData.InitService}.
   */
  @Generated
  public static class InitService {
    /**
     * Get the bean definition for 'initService'.
     */
    public static BeanDefinition getInitServiceBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(InitData.InitService.class);
      InstanceSupplier<InitData.InitService> instanceSupplier = InstanceSupplier.using(InitData.InitService::new);
      instanceSupplier = instanceSupplier.andThen(InitData_InitService__PersistenceInjection::apply);
      beanDefinition.setInstanceSupplier(instanceSupplier);
      return beanDefinition;
    }
  }
}
