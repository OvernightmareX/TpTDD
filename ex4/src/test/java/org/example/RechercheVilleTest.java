package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RechercheVilleTest {
    private RechercheVille rechercheVille;

    private List<String> villes = Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver",
            "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");

    @BeforeEach
    public void setup(){
        rechercheVille = new RechercheVille();
    }

    @Test
    public void TestRechercheVille_WhenRechercher_LessThan_2_ThenThrowNotFoundException(){
        Assertions.assertThrows(NotImplementedException.class, () -> rechercheVille.rechercher("P" ));
    }

    @Test
    public void TestRechercheVille_WhenRechercher_StartWithTwoOrMoreCharacters_ThenResultAllCityStartingWith(){
        String startCharacters = "Va";
        List<String> results = rechercheVille.rechercher(startCharacters);
        List<String> resultExpected = Arrays.asList("Valence", "Vancouver");

        Assertions.assertEquals(resultExpected, results);
    }

    @Test
    public void TestRechercheVille_WhenRechercher_VA_ThenResult_2(){
        String startCharacters = "VA";
        List<String> results = rechercheVille.rechercher(startCharacters);
        List<String> resultExpected = Arrays.asList("Valence", "Vancouver");

        Assertions.assertEquals(resultExpected, results);
    }

    @Test
    public void TestRechercheVille_WhenRechercherPartialWord_ape_ThenResult_Budapest(){
        String startCharacters = "ape";
        List<String> results = rechercheVille.rechercher(startCharacters);

        Assertions.assertEquals("Budapest", results.get(0));
    }

    @Test
    public void TestRechercheVille_WhenRechercher_asterisk_ThenResult_16(){
        String startCharacters = "*";
        List<String> results = rechercheVille.rechercher(startCharacters);

        Assertions.assertEquals(16, results.size());
    }
}
