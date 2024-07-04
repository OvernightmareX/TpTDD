package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;

import java.util.List;

public class FrameTest {

    private IGenerateur iGenerateur = Mockito.mock(IGenerateur.class);
    private Frame frame;

    @Test
    public void Roll_SimpleFrame_FirstRoll_CheckScore(){
        int resultExpected = 2;
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(2);

        frame = new Frame(iGenerateur, false);
        frame.makeRoll();

        Assertions.assertEquals(resultExpected, frame.getScore());
    }

    @Test
    public void Roll_SimpleFrame_SecondRoll_CheckScore(){
        int resultExpected = 4;
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(2);
        Mockito.when(iGenerateur.randomPin(8)).thenReturn(2);

        frame = new Frame(iGenerateur, false);
        frame.makeRoll();
        frame.makeRoll();

        Assertions.assertEquals(resultExpected,frame.getScore());
    }

    @Test
    public void Roll_SimpleFrame_SecondRoll_FirstRollStrike_ReturnFalse(){
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(10);

        frame = new Frame(iGenerateur, false);
        frame.makeRoll();

        Assertions.assertFalse(frame.canMakeRoll());
    }

    @Test
    public void Roll_SimpleFrame_MoreRolls_ReturnFalse(){
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(2);
        Mockito.when(iGenerateur.randomPin(8)).thenReturn(2);

        frame = new Frame(iGenerateur, false);
        frame.makeRoll();
        frame.makeRoll();

        Assertions.assertFalse(frame.canMakeRoll());
    }

    @Test
    public void Roll_LastFrame_SecondRoll_FirstRollStrike_ReturnTrue(){
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(10);

        frame = new Frame(iGenerateur, true);
        frame.makeRoll();

        Assertions.assertTrue(frame.canMakeRoll());
    }

    @Test
    public void Roll_LastFrame_SecondRoll_FirstRollStrike_CheckScore(){
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(10);

        frame = new Frame(iGenerateur, true);
        frame.makeRoll();

        Assertions.assertEquals(10, frame.getScore());
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_FirstRollStrike_ReturnTrue(){
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(10).thenReturn(5);
        frame = new Frame(iGenerateur, true);
        frame.makeRoll();
        frame.makeRoll();

        Assertions.assertTrue(frame.canMakeRoll());
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_FirstRollStrike_CheckScore(){
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(10).thenReturn(5);
        frame = new Frame(iGenerateur, true);
        frame.makeRoll();
        frame.makeRoll();

        Assertions.assertEquals(15, frame.getScore());
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_Spare_ReturnTrue(){
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(5);
        Mockito.when(iGenerateur.randomPin(5)).thenReturn(5);
        frame = new Frame(iGenerateur, true);
        frame.makeRoll();
        frame.makeRoll();

        Assertions.assertTrue(frame.canMakeRoll());
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_Spare_CheckScore(){
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(5);
        Mockito.when(iGenerateur.randomPin(5)).thenReturn(5);
        frame = new Frame(iGenerateur, true);
        frame.makeRoll();
        frame.makeRoll();
        frame.makeRoll();

        Assertions.assertEquals(15, frame.getScore());
    }

    @Test
    public void Roll_LastFrame_FourthRoll_ReturnFalse(){
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(5);
        Mockito.when(iGenerateur.randomPin(5)).thenReturn(5);
        frame = new Frame(iGenerateur, true);
        frame.makeRoll();
        frame.makeRoll();
        frame.makeRoll();
        frame.makeRoll(); //Tente un roll mais ne fera rien (interdit de lancer 4 fois)

        Assertions.assertFalse(frame.canMakeRoll());
    }
}