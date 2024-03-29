package org.springframework.test.context.aot;

import java.lang.Class;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.springframework.aot.generate.Generated;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import wwwalk.wwwalk.WwwalkApplicationTests__TestContext001_ApplicationContextInitializer;
import wwwalk.wwwalk.controller.JwtLoginTest__TestContext002_ApplicationContextInitializer;

/**
 * Generated mappings for {@link AotTestContextInitializers}.
 */
@Generated
public class AotTestContextInitializers__Generated {
  public static Map<String, Supplier<ApplicationContextInitializer<? extends ConfigurableApplicationContext>>> getContextInitializers(
      ) {
    Map<String, Supplier<ApplicationContextInitializer<? extends ConfigurableApplicationContext>>> map = new HashMap<>();
    map.put("wwwalk.wwwalk.WwwalkApplicationTests", () -> new WwwalkApplicationTests__TestContext001_ApplicationContextInitializer());
    map.put("wwwalk.wwwalk.controller.JwtLoginTest", () -> new JwtLoginTest__TestContext002_ApplicationContextInitializer());
    return map;
  }

  public static Map<String, Class<? extends ApplicationContextInitializer<?>>> getContextInitializerClasses(
      ) {
    Map<String, Class<? extends ApplicationContextInitializer<?>>> map = new HashMap<>();
    map.put("wwwalk.wwwalk.WwwalkApplicationTests", WwwalkApplicationTests__TestContext001_ApplicationContextInitializer.class);
    map.put("wwwalk.wwwalk.controller.JwtLoginTest", JwtLoginTest__TestContext002_ApplicationContextInitializer.class);
    return map;
  }
}
