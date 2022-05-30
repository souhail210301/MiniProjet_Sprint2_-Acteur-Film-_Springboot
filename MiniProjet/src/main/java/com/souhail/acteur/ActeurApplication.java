package com.souhail.acteur;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.souhail.acteur.entities.Acteur;
import com.souhail.acteur.service.ActeurService;

@SpringBootApplication
public class ActeurApplication implements CommandLineRunner {
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
	SpringApplication.run(ActeurApplication.class, args);
	}
@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Acteur.class);

}}