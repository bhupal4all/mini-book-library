package com.ranga.minilibrary.inventory;

import com.ranga.minilibrary.inventory.dto.BooksContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties({
        BooksContactInfoDto.class
})
@OpenAPIDefinition(
        info = @Info(
                title = "Books Microservice REST API Documentation",
                version = "1.0",
                description = "Books Microservice API to manage the books.",
                contact = @Contact(
                        name = "Ranga Bhupal",
                        email = "bhupal4all@gmail.com",
                        url = "https://www.linkedin.com/in/bhupal4all/"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Books Microservice External Documentation",
                url = "https://mini-booklibrary.com"
        )
)
public class BooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksApplication.class, args);
    }

}
