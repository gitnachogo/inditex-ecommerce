package local.inditex.ecommerce.infrastructure.shared;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"local.inditex.ecommerce"})
@EnableJpaRepositories(basePackages = "local.inditex.ecommerce.infrastructure")
@EntityScan("local.inditex.ecommerce.infrastructure")
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

}
