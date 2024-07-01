package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradingCalculatorTest {

    private GradingCalculator gradingCalculator;

    @Test
    public void TestGetGradeWhenScore_95_AndAttendance_90_ThenResult_A(){
        //Arrange
        gradingCalculator = new GradingCalculator(95, 90);
        char resultAwait = 'A';

        //Act
        char result = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(resultAwait,result);
    }

    @Test
    public void TestGetGradeWhenScore_85_AndAttendance_90_ThenResult_B(){
        //Arrange
        gradingCalculator = new GradingCalculator(85, 90);
        char resultAwait = 'B';

        //Act
        char result = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(resultAwait,result);
    }

    @Test
    public void TestGetGradeWhenScore_65_AndAttendance_90_ThenResult_C(){
        //Arrange
        gradingCalculator = new GradingCalculator(65, 90);
        char resultAwait = 'C';

        //Act
        char result = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(resultAwait,result);
    }

    @Test
    public void TestGetGradeWhenScore_95_AndAttendance_65_ThenResult_C(){
        //Arrange
        gradingCalculator = new GradingCalculator(95, 65);
        char resultAwait = 'B';

        //Act
        char result = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(resultAwait,result);
    }

    @Test
    public void TestGetGradeWhenScore_95_AndAttendance_55_ThenResult_F(){
        //Arrange
        gradingCalculator = new GradingCalculator(95, 55);
        char resultAwait = 'F';

        //Act
        char result = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(resultAwait,result);
    }

    @Test
    public void TestGetGradeWhenScore_65_AndAttendance_55_ThenResult_F(){
        //Arrange
        gradingCalculator = new GradingCalculator(65, 55);
        char resultAwait = 'F';

        //Act
        char result = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(resultAwait,result);
    }

    @Test
    public void TestGetGradeWhenScore_50_AndAttendance_90_ThenResult_F(){
        //Arrange
        gradingCalculator = new GradingCalculator(50, 90);
        char resultAwait = 'F';

        //Act
        char result = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(resultAwait,result);
    }
}
