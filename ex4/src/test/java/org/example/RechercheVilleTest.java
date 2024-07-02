package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RechercheVilleTest {
    private RechercheVille rechercheVille;

    @BeforeEach
    public void setup(){
        rechercheVille = new RechercheVille();
    }

    @Test
    public void TestRechercheVille_WhenRechercher_LessThan_2_ThenThrowNotFoundException(){
        Assertions.assertThrows(NotImplementedException.class, () -> rechercheVille.rechercher("P" ));
    }

    private List<String> villes = Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver",
            "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");

    @Test
    public void TestRechercheVille_WhenRechercher_StartWithTwoOrMoreCharacters_ThenResultAllCityStartingWith(){
        String startCharacters = "Va";
        List<String> results = rechercheVille.rechercher(startCharacters);

        Assertions.assertEquals(2, results.size());
        Assertions.assertEquals("Valence", results.get(0));
        Assertions.assertEquals("Vancouver", results.get(1));
    }

    @Test
    public void TestRechercheVille_WhenRechercher_VA_ThenResult_2(){
        String startCharacters = "VA";
        List<String> results = rechercheVille.rechercher(startCharacters);

        Assertions.assertEquals(2, results.size());
        Assertions.assertEquals("Valence", results.get(0));
        Assertions.assertEquals("Vancouver", results.get(1));
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



//1. Si le texte de la recherche contient moins de 2 caractères, ***Une exception est levée de type NotFoundException***.
//2. Si le texte de recherche est égal ou supérieur à 2 caractères, il doit renvoyer tous les noms de ville commençant par le texte de recherche exact.
//Par exemple, pour le texte de recherche "Va", la fonction doit renvoyer Valence et Vancouver
//3. La fonctionnalité de recherche doit être insensible à la casse
//4. La fonctionnalité de recherche devrait également fonctionner lorsque le texte de recherche n'est qu'une partie d'un nom de ville
//Par exemple "ape" devrait renvoyer la ville "Budapest"
//5. Si le texte de recherche est un « * » (astérisque), il doit renvoyer tous les noms de ville.

}
