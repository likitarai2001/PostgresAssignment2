package com.example.onlineShopping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.TimeZone;

@SpringBootApplication
@Slf4j
public class OnlineShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingApplication.class, args);
		String operatingSystem = System.getProperty("os.name");
		String logDirectory = operatingSystem.contains("Windows") ? System.getProperty("user.dir") + "\\src\\main\\logs\\" : System.getProperty("user.dir") + "/src/main/logs/";
		log.info("Application started on : " + operatingSystem + " " + System.getProperty("os.arch") + " with Java " + System.getProperty("java.version") + " with default time-zone " + TimeZone.getDefault().toZoneId());
		log.info("Log directory: " + logDirectory);
	}

}
