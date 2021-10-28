package in.santhosh.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@Import({ DBconfiguration.class, ListenerConfig.class, SwaggerConfig.class })
@PropertySource({ "classpath:application.properties"})
public class ApplicationConfig {

}
