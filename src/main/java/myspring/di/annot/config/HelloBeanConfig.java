package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration

@ComponentScan(basePackages = {"myspring.di.annot"}) // == <context:component-scan base-package="mylab.user.di.annot" />
@PropertySource(value = "classpath:values.properties") //== <context:property-placeholder location="classpath:values.properties" />
public class HelloBeanConfig {

}
