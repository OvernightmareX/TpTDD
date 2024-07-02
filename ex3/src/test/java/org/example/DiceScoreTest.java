package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DiceScoreTest {

    private Ide ide = Mockito.mock(Ide.class);

    @Test
    public void TestDiceScoreWhenFirstAndSecondIs_5_ThenResult_20 (){
        //Arrange
        DiceScore diceScore = new DiceScore(ide);
        Mockito.when(ide.getRoll()).thenReturn(5);

        //Act
        int result = diceScore.getScore();

        //Assert
        Assertions.assertEquals(20 ,result);
    }

    @Test
    public void TestDiceScoreWhenFirstAndSecondIs_6_ThenResult_30 (){
        //Arrange
        DiceScore diceScore = new DiceScore(ide);
        Mockito.when(ide.getRoll()).thenReturn(6);

        //Act
        int result = diceScore.getScore();

        //Assert
        Assertions.assertEquals(30 ,result);
    }

    @Test
    public void TestDiceScoreWhenFirstIs_2_AndSecondIs_5_ThenResult_5 (){
        //Arrange
        DiceScore diceScore = new DiceScore(ide);
        Mockito.when(ide.getRoll()).thenReturn(2).thenReturn(5);

        //Act
        int result = diceScore.getScore();

        //Assert
        Assertions.assertEquals(5 ,result);
    }
}
