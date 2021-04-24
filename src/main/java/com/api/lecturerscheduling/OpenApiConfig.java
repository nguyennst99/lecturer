package com.api.lecturerscheduling;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.assertj.core.util.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // Thiết lập các server dùng để test api
                .servers(Lists.newArrayList(
                        new Server().url("http://localhost:8084"),
                        new Server().url("http://3.17.203.143:8080/fptscheduling")
                ))
                // info
                .info(new Info().title("Lecturers Scheduling API")
                        .description("Lecturers Scheduling OpenAPI 3.0")
                        .contact(new Contact()
                                .email("haunguyenfptk13@gmail.com")
                                .name("haun")
                                .url(""))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                        .version("1.0.0"));
    }
}
