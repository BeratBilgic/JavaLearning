package com.example.javajwtdemo;

import com.example.javajwtdemo.model.Role;
import com.example.javajwtdemo.model.User;
import com.example.javajwtdemo.service.AuthService;
import com.example.javajwtdemo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JavaJwtDemoApplication implements CommandLineRunner {

	private final UserService userService;
	private final AuthService authService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public JavaJwtDemoApplication(UserService userService, AuthService authService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userService = userService;
		this.authService = authService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaJwtDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.saveRepository(new User(null,"admin@email",
				bCryptPasswordEncoder.encode("1234"), Role.ADMIN));
		userService.saveRepository(new User(null,"user@email",
				bCryptPasswordEncoder.encode("1234"), Role.USER));
	}
}
