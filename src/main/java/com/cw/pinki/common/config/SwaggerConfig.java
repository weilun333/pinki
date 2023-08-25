package com.cw.pinki.common.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi1() {
        return GroupedOpenApi.builder()
                .group("pinki_brand")
                .pathsToMatch("/brand/**")
                .build();
    }

    @Bean
    public GroupedOpenApi publicApi2() {
        return GroupedOpenApi.builder()
                .group("pinki_activity")
                .pathsToMatch("/activity/**")
                .build();
    }


    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("pinki文檔")
                        .description("購物網站")
                        .version("v1.0.0")
//                        .contact(new Contact().name("cindy & wei").email("cc@gmail.com").url("google.com"))
                        .license(new License().name("").url("")))
                        .externalDocs(new ExternalDocumentation().description("").url(""));
    }
}
