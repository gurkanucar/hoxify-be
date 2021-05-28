package com.gucarsoft.ws;

import com.gucarsoft.ws.service.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(/*exclude = SecurityAutoConfiguration.class*/)
public class HoxifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoxifyApplication.class, args);
    }

    @Bean
    CommandLineRunner createInitialUser(UserService userService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // açılışta çalıştırılır configrasyon olarak

                System.out.println("Uygulama Başlatıldı!");

				/*
				User user=new User();
				user.setUsername("admin");
				user.setPassword("admin123");
				user.setName("usr");
				userService.create(user);
                */

            }
        };
    }

}
