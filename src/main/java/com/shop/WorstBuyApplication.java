package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class WorstBuyApplication  extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(WorstBuyApplication.class, args);
	}

	
	  @Override protected SpringApplicationBuilder configure(SpringApplicationBuilder application) { /*// Customize the
	  
	  application or call application.sources(...) to add sources // Since our
	  example is itself a @Configuration class (via @SpringBootApplication) // we
	  actually don't need to override this method. 
	   }
*/	 	
		  return application;
	  }

}
