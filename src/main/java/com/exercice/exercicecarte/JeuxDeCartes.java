package com.exercice.exercicecarte;


import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@Getter
public class JeuxDeCartes {

    private final static List<String> COULEUR_DE_CARTE = new ArrayList<String>(){{ add("Coeurs"); add("Carreaux"); add("Piques"); add("Trefle");}};
    private final static  List<String>  NUMERO_DE_CARTE = new ArrayList<String>(){{add("A"); add("2"); add("3"); add("4"); add("5"); add("6"); add("7"); add("8"); add("9"); add("10"); add("J"); add("Q"); add("K");}};
    private Map<String, List<String>> jeu;
    private Random random = new Random();



    public JeuxDeCartes(){
        this.jeu = new HashMap<>();
        COULEUR_DE_CARTE.forEach( couleur -> jeu.put(couleur,new ArrayList<>(NUMERO_DE_CARTE )));
    }

    public List<Carte> piocherMain(int nombreDeCartes){
        List<Carte> main = new ArrayList<>();
        while(nombreDeCartes > 0 ){

            main.add(this.piocher());
            nombreDeCartes--;

        }
        return main;
    }

    public Carte piocher(){

        if(jeu.size() == 0){
            return null;
        }
        else {
            List<String> couleurs = jeu.keySet().stream().collect(Collectors.toList());
            String couleur = couleurs.get(getRandomItem(couleurs));
            String numero = "";
            if (jeu.get(couleur).size() == 1) {
                numero = jeu.get(couleur).get(0);
                jeu.remove(couleur);
            }else{
                int indice = getRandomItem(jeu.get(couleur));
                numero = jeu.get(couleur).get(indice);
                jeu.get(couleur).remove(indice);
            }
            return new Carte(couleur, numero);
        }

    }

    private  Integer getRandomItem(List<String> list) {
        return random.nextInt(list.size());
    }


}
