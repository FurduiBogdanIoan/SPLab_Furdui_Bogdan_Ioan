package com.example.bilete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.bilete.config.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(FileStorageProperties.class)
public class ProiectWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProiectWebApplication.class, args);
	}

}


// inainte de a porni serverul da comanda asta in aplicatia MySQL Workbench 8.0 CE --- CREATE DATABASE bilete_db;
// pune username "root" si parola "parola_ta_mysql"
// daca vrei altfel schimba in application.properties partea asta "spring.datasource.username=root ; spring.datasource.password=parola_ta_mysql"

// in  WebConfig.java avem legatura cu frontendul