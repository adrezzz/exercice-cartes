package com.exercice.exercicecarte;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class ExerciceCarteApplication implements CommandLineRunner {



	public static void main(String[] args) {
		log.info("STARTING THE APPLICATION");
		SpringApplication.run(ExerciceCarteApplication.class, args);
		log.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) {
		log.info("Demarrage de l'exercice avec une main de {0} cartes", args[0]);

		JeuxDeCartes jeux = new JeuxDeCartes();
		List<Carte> mainPiochee  = jeux.piocherMain(Integer.parseInt(args[0]));
		log.info("La main piochée non triée : " );
		log.info(mainPiochee.toString());
		log.info("La main piochée  triée : " );
		List<Carte> mainTriee = mainPiochee.stream().sorted().collect(Collectors.toList());
		log.info(mainTriee.toString());
	}
}
