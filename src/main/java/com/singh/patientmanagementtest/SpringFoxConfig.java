package com.singh.patientmanagementtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import java.util.Collections;
import java.util.List;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                        List.of(new ResponseMessageBuilder()
                                        .code(500)
                                        .message("code 500: the response is failed due to some exception")
                                        .responseModel(new ModelRef("Error"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(403)
                                        .message("code 403: the resource is Forbidden by Vatsal!")
                                        .build()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Patient management REST API as a solution by Vatsal Singh for the test provided by CGM",
                "This is the Patient Management API written by Vatsal to provide the solution for CGM Test. The main purpose of the API is to manage the visits of a patient",
                "API 1.0",
                "Terms of service",
                new Contact("Vatsal Singh", "", "singhvatsal.01@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
