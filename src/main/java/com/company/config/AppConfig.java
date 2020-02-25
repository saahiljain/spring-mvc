package com.company.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan({"com.company.web.controller", "com.company.dao", "com.company.interfaces"}) // All the files in the package will be scanned
public class AppConfig implements WebApplicationInitializer, WebMvcConfigurer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = 
				new AnnotationConfigWebApplicationContext();
		
		context.register(AppConfig.class);
		Dynamic servlet = servletContext.addServlet("ds", new DispatcherServlet(context));
		
		servlet.addMapping("/");
		
		// This will be the first servlet to be downloaded
		servlet.setLoadOnStartup(1);
	}
	
	// To enable the access out of /, where every request is given to Spring - DispactherServlet
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	public void addViewControllers(ViewControllerRegistry registry) {
	}
	
	@Bean
	InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = 
				new InternalResourceViewResolver();
		
		internalResourceViewResolver.setPrefix("/WEB-INF/pages/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		return internalResourceViewResolver;
	}
	
}
