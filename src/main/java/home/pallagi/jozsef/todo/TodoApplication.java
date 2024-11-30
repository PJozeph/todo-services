package home.pallagi.jozsef.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@EnableJpaRepositories("home.pallagi.jozsef.todo.repository")
@EntityScan("home.pallagi.jozsef.todo.entity")
@OpenAPIDefinition(info = @Info(title = "Todo Service API", version = "1.0", description = "API for managing todos"), servers = {
        @Server(url = "https://todo-service-681005455667.us-central1.run.app", description = "Cloud Run Server")
})
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}
