package com.glory.jsonwebtoken;

import com.glory.jsonwebtoken.entity.Role;
import com.glory.jsonwebtoken.entity.User;
import com.glory.jsonwebtoken.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class JsonWebTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonWebTokenApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner runner(UserServiceImpl userService){
		return args -> {

			Role roleUser = new Role("ROLE_USER");
			Role roleManager = new Role("ROLE_MANAGER");
			Role roleAdmin = new Role("ROLE_ADMIN");
			Role roleSuperAdmin = new Role("ROLE_SUPER_ADMIN");
			List<Role> roles = List.of(roleAdmin, roleSuperAdmin, roleManager, roleUser);
			for (Role role : roles){
				userService.saveRole(role);
			}

			User johnNdoe = new User("John Ndoe", "johnndoe@gmail.com", "2021john", Set.of(roleAdmin, roleSuperAdmin));
			User calebNtumba = new User("Caleb Ntumba", "calebntumba@gmail.com", "2021caleb", Set.of(roleManager, roleUser));
			User gloireBeya = new User("Gloire Beya", "gloirebeya@gmail.com", "2021gloire", Set.of(roleManager, roleAdmin));
			User teboBeya = new User("Tebo Beya", "tebobeya@gmail.com", "2021tebo", Set.of(roleManager, roleSuperAdmin, roleAdmin));
			List<User> users = List.of(johnNdoe, calebNtumba, gloireBeya, teboBeya);
			for (User user : users){
				userService.saveUser(user);
			}
		};
	}

}
