package br.com.magna.corporacaoapi.infra.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfigurations {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("bearer-key",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
				.info(new Info().title("Magna Corps").description(
						"API Rest da aplicação Magna Corps, contendo as funcionalidades de CRUD de corporações, "
						+ "com funcionalidade de ativar/desativar CNPJ e fazer consultas")
						.contact(new Contact().name("Magna Corps - Juliano").email("jnunes@magnasistemas.com").url("https://github.com/julianoBeerg"))
						.license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html"))
						.version("1.0.1"));
	}

}
