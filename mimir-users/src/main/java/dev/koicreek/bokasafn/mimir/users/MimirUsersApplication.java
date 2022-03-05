package dev.koicreek.bokasafn.mimir.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MimirUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MimirUsersApplication.class, args);
	}

}
