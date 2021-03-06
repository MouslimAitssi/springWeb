package com.spring.jeux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class JeuxApplication {

    /*Swagger:
       http://localhost:9090/v2/api-docs
       Documentation : http://localhost:9090/swagger-ui.html
     */
	public static void main(String[] args) {
		SpringApplication.run(JeuxApplication.class, args);
	}

}
