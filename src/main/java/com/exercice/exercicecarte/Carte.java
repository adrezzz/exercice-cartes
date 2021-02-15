package com.exercice.exercicecarte;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Carte implements Comparable {

    private String couleur;
    private String numero;


    public String toChar (int couleur)
    {
        switch(couleur)
        {
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            case 14: return "A";
            default: return ((Integer)couleur).toString();
        }
    }

    public Integer toInt ()
    {
        //convert your face string to int
        switch(this.numero)
        {
            case "A": return 1;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            default: return Integer.parseInt(numero);
        }
    }

    @Override
    public int compareTo(Object o) {
        Carte oCarte = (Carte) o;
        if(this.getCouleur().equals(((Carte) o).getCouleur())){
            return oCarte.toInt().compareTo(this.toInt());
        }else{
            return oCarte.getCouleur().compareTo(this.getCouleur());
        }
    }
}
