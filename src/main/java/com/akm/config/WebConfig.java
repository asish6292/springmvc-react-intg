package com.akm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("com.akm")
@PropertySource("classpath:application.properties")
public class WebConfig implements WebMvcConfigurer {

	@Value("${project.version}")
	private String projectVersion;

	@Value("${project.artifactId}")
	private String projectArtifactId;

	// CORS configuration for API requests
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**").allowedOrigins("http://localhost:3000") // React dev server
				.allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Serve all static content in the static folder for any path
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}
	
	@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // Avoid treating index.html as a Thymeleaf or JSP view
        registry.enableContentNegotiation();
    }

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		// Forward non-API paths to index.html
//		registry.addViewController("/{spring:[^.]*}").setViewName("forward:/index.html");
//		registry.addViewController("/**/{spring:[^.]*}").setViewName("forward:/index.html");
//		registry.addViewController("/{spring:^(?!api$).*$}/**/{spring:[^.]*}").setViewName("forward:/index.html");
//	}
}
