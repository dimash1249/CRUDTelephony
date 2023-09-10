package com.CRUDTelephony.CRUDTelephony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages = "com.CRUDTelephony.CRUDTelephony.Models")
//@EnableJpaRepositories(basePackages = "com.CRUDTelephony.CRUDTelephony.Repositories")
public class CrudTelephonyApplication {

	//@Bean
	//public ModelMapper modelMapper(){
	//	return new ModelMapper();
	//}
	public static void main(String[] args) {
		SpringApplication.run(CrudTelephonyApplication.class, args);
	}

}
