package home.pallagi.jozsef.todo;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "https://todo-service-681005455667.us-central1.run.app", // Your app domain
                        "http://localhost:8080", // Local Swagger UI for testing
                        "https://editor.swagger.io" // Optional: for using Swagger Editor
                )
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

}
