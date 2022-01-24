package com.d2d.retailbank.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

   @Bean
    public GroupedOpenApi publicApi(){
       return GroupedOpenApi.builder()
               .group("Retail-Bank-Account-Management")
               .packagesToScan("com.d2d.retailbank.controller")
               .pathsToMatch("/**")
               .build();
   }
}
