package com.codemagen.product.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

        @Bean
        public Docket productApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .groupName("Product Service")
                    .apiInfo(apiInfo())
                    .select()
                    .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                    .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.cloud")))
                    .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.data.rest.webmvc")))
                    .build();
        }

        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("Product Service API")
                    .description("Codemagen Product Service REST APIs for managing product operations.")
                    .license("Apache License Version 2.0")
                    .version("1.0.0")
                    .build();
        }
    }