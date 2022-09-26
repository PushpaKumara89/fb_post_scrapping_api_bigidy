package com.wixis.bigidy;

import com.wixis.bigidy.authentication.domain.Role;
import com.wixis.bigidy.authentication.domain.User;
import com.wixis.bigidy.authentication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@SpringBootApplication
public class BigIdyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BigIdyApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public WebMvcConfigurer configurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

	@Bean
	CommandLineRunner run (UserService userService){
		return args -> {
			/*userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_AMIN"));

			userService.saveUser(new User(null, "John Travolta", "john@gmail.com", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Will Smith", "will@hotmail.com", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Jim Carry", "jim@outlook.com", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Arnold Schwarzenegger", "arnold@webmail.com", "1234", new ArrayList<>()));

			userService.addRoleToUser("john@gmail.com", "ROLE_USER");
			userService.addRoleToUser("john@gmail.com", "ROLE_MANAGER");
			userService.addRoleToUser("will@hotmail.com", "ROLE_MANAGER");
			userService.addRoleToUser("jim@outlook.com", "ROLE_ADMIN");
			userService.addRoleToUser("arnold@webmail.com", "ROLE_SUPER_AMIN");
			userService.addRoleToUser("arnold@webmail.com", "ROLE_ADMIN");
			userService.addRoleToUser("arnold@webmail.com", "ROLE_USER");*/
		};
	}
}
