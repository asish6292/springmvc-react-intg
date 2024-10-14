package com.akm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
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

	// Serve static resources (React build files)
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
        String targetFolder = "target/" + projectArtifactId + "-" + projectVersion + "/static/";
        System.out.println("***********target foldername: "+targetFolder);

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/", "file:" + targetFolder);

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/static/", "file:" + targetFolder + "static/");
    }

	// Forward non-API requests to React's index.html
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.html");
	}
}
