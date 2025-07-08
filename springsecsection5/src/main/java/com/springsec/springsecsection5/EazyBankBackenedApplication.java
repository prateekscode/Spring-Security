package com.springsec.springsecsection5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableWebSecurity [It is completely optional inside springBoot app because
// it checks it from dependencies but if we are working in a normal
//spring app we have to specify]
/*@EnableJpaRepositories("com.springsec.springsecsection4.repository")
@EntityScan("com.springsec.springsecsection4.model")*/
public class EazyBankBackenedApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBankBackenedApplication.class, args);
	}

}