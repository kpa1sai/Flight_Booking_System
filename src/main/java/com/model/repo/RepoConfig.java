package com.model.repo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class RepoConfig {
	@Bean
	CommandLineRunner commandLineRunner(UserRepo userRepo) {
		return args->{
			//Users u1 = new Users("kpa1sai", "Papsas", "sasdsd");
		};
	}

}
