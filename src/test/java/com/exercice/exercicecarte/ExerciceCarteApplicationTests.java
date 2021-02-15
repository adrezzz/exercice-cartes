package com.exercice.exercicecarte;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class ExerciceCarteApplicationTests {





	@Before
	public void setUp(){

	}


	@Test
	void test_piocher() {

		JeuxDeCartes j1 = new JeuxDeCartes();
		JeuxDeCartes j2 = new JeuxDeCartes();

		Carte c1 = j1.piocher();
		log.info(c1.toString());

		assert(!j1.getJeu().get(c1.getCouleur()).contains(c1.getNumero()));
		assert(j2.getJeu().get(c1.getCouleur()).contains(c1.getNumero()));
	}


	@Test
	void test_picher_main(){
		JeuxDeCartes j1 = new JeuxDeCartes();
		 List<Carte> main1 = j1.piocherMain(5);
		log.info(main1.toString());
		assert(main1.size() == 5);
	}

	@Test
	void test_comparer_carte(){
		Carte c1 = new Carte("Carreau", "A");
		Carte c2 = new Carte("Carreau", "10");
		assert(c1.compareTo(c2) == 1);
		c2.setNumero("A");
		assert(c1.compareTo(c2) == 0);
		c1.setNumero("3");
		assert(c1.compareTo(c2) == -1);
	}

}
