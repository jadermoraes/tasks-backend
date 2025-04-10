package jader.totvs.tasksapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tasks API")
                        .description("API para gerenciar tarefas (test recrutamento TOTVS)")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Jader Moraes")
                                .email("jader-ms@hotmail.com")));
    }
}
