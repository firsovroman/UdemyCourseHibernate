package org.firsov.spring;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.firsov.spring")
@PropertySource("classpath:myApp.properties")
public class MyConfig {

}
