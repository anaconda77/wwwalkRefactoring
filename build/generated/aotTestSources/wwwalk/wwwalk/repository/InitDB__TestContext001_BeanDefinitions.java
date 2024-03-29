package wwwalk.wwwalk.repository;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link InitDB}.
 */
@Generated
public class InitDB__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'initDB'.
   */
  private static BeanInstanceSupplier<InitDB> getInitDBInstanceSupplier() {
    return BeanInstanceSupplier.<InitDB>forConstructor(InitDB.InitService.class)
            .withGenerator((registeredBean, args) -> new InitDB(args.get(0)));
  }

  /**
   * Get the bean definition for 'initDB'.
   */
  public static BeanDefinition getInitDBBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(InitDB.class);
    beanDefinition.setInitMethodNames("init");
    beanDefinition.setInstanceSupplier(getInitDBInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link InitDB.InitService}.
   */
  @Generated
  public static class InitService {
    /**
     * Get the bean definition for 'initService'.
     */
    public static BeanDefinition getInitServiceBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(InitDB.InitService.class);
      InstanceSupplier<InitDB.InitService> instanceSupplier = InstanceSupplier.using(InitDB.InitService::new);
      instanceSupplier = instanceSupplier.andThen(InitDB_InitService__TestContext001_PersistenceInjection::apply);
      beanDefinition.setInstanceSupplier(instanceSupplier);
      return beanDefinition;
    }
  }
}
