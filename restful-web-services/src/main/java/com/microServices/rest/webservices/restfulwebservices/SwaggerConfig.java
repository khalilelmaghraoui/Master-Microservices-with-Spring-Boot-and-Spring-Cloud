package com.microServices.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    public static final Contact DEFAULT_CONTACT = new Contact("Khalil d'ocs", "khalil.ma", "khalil@gmail.com");
    public static final String TAG_1 = "tag1";

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.microServices.rest.webservices.restfulwebservices"))
            .build()
            .tags(new Tag(TAG_1, "Tag 1 description."))
            // Other tags here...
            .apiInfo(apiInfo());


    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("My API").version("1.0.0").contact(DEFAULT_CONTACT).build();
    }
}
