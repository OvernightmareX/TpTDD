package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RechercheVille {
    private List<String> villes = Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver",
            "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");

    public List<String> rechercher(String mot)  {
        if(mot.length() < 2 && !mot.equals("*"))
            throw new NotImplementedException();

        if(mot.equals("*"))
            return villes;
        
        List<String> villesRechercher = new ArrayList<>(); 
        for(String ville : villes){
            if(ville.toUpperCase().startsWith(mot.toUpperCase()) || ville.toUpperCase().contains(mot.toUpperCase()))
                villesRechercher.add(ville);
        }
        return villesRechercher; 
    }
}
