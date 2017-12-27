package com.store.storeweb.start;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
@EnableMongoRepositories(basePackages="com.store.*")
@ComponentScan(basePackages="com.store")
public class SpringWebApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringWebApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
	
	
	@Bean(name="messageSource")
	   public MessageSource messageSource() {
	      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	      source.setBasename("messages");
	      return source;
	   }
	
	 public Validator getValidator() {
	      LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
	      validator.setValidationMessageSource(messageSource());
	      return validator;
	   }
	 
	 
	 

}
