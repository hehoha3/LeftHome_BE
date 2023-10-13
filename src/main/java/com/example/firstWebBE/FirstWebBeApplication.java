package com.example.firstWebBE;

import com.example.firstWebBE.controller.CartController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class FirstWebBeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run;
		run = SpringApplication.run(FirstWebBeApplication.class, args);
	}

}
