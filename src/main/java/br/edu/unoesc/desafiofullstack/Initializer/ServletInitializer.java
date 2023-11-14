package br.edu.unoesc.desafiofullstack.Initializer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import br.edu.unoesc.desafiofullstack.DesafioFullstackApplication;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DesafioFullstackApplication.class);
	}

}
