package br.com.academia.SistemaParaGerenciamentoDeAcademia.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sistema para gerenciamento de academia")
                        .version("1.0")
                        .description("API para o gerenciamento de uma Academia. " +
                                "Este sistema permite que Clientes, Instrutores e Administrador interajam em um ambiente de controle do sistema, " +
                                "com funcionalidades para cadastro, login e listagem de treinos, agendamentos e estatísticas da academia."));
    }
}