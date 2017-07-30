package me.hdpe.modulesblog.web;

import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({
	DispatcherServletAutoConfiguration.class,
	EmbeddedServletContainerAutoConfiguration.class,
	HttpMessageConvertersAutoConfiguration.class,
	ServerPropertiesAutoConfiguration.class,
	WebMvcAutoConfiguration.class
})
public class WebConfig {
	
}
