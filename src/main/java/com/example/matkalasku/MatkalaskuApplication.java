package com.example.matkalasku;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.matkalasku.domain.AppUser;
import com.example.matkalasku.domain.AppUserRepository;



import com.example.matkalasku.domain.Lasku;
import com.example.matkalasku.domain.LaskuRepository;

@SpringBootApplication
public class MatkalaskuApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MatkalaskuApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(MatkalaskuApplication.class, args);
	}

	@Bean
	public CommandLineRunner laskuDemo(LaskuRepository repository, AppUserRepository urepository) {
	    return (args) -> {
	        log.info("Testilaskut");
	        //repository.save(new Lasku(LocalDate.of(2023, 12, 12), "Tikkurila", "Myyrmaki", 13, 6.89));
	        //repository.save(new Lasku(LocalDate.of(2023, 12, 11), "Helsinki", "Vantaa", 17, 9.01));
	        
			// Create users: admin/admin user/user
	        /*AppUser user1 = new AppUser("user", "lauri.mayry@gmail.com", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "lauri.admin.mayry@gmail.com", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);*/
	        
	        log.info("Kaikki laskut");
	        for (Lasku lasku : repository.findAll()) {
	            log.info(lasku.toString());
	        }
	    };
	}
}
