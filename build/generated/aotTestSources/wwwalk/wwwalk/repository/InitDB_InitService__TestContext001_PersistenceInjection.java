package wwwalk.wwwalk.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.lang.reflect.Field;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.orm.jpa.SharedEntityManagerCreator;
import org.springframework.util.ReflectionUtils;

/**
 * Persistence injection for {@link InitDB.InitService}.
 */
@Generated
public class InitDB_InitService__TestContext001_PersistenceInjection {
  /**
   * Get the 'default' {@link EntityManager}.
   */
  public static EntityManager getEntityManager(RegisteredBean registeredBean) {
    EntityManagerFactory entityManagerFactory = EntityManagerFactoryUtils.findEntityManagerFactory((ListableBeanFactory) registeredBean.getBeanFactory(), "");
    return SharedEntityManagerCreator.createSharedEntityManager(entityManagerFactory, null, true);
  }

  /**
   * Apply the persistence injection.
   */
  public static InitDB.InitService apply(RegisteredBean registeredBean,
      InitDB.InitService instance) {
    Field field = ReflectionUtils.findField(InitDB.InitService.class, "em");
    ReflectionUtils.makeAccessible(field);
    ReflectionUtils.setField(field, instance, getEntityManager(registeredBean));
    return instance;
  }
}
