package com.voting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableSwagger2
@SpringBootApplication
public class VotingManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotingManagementApplication.class, args);
	}

//	@Bean 				// http://localhost:8080/swagger-ui.html
//	public Docket apiDoc() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.voting"))
//				.paths(PathSelectors.any()).build();
//	}

}
