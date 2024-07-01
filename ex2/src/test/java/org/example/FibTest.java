package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FibTest {

    private Fib fib;

    @Test
    public void TestGetFibSeriesWhenRange_1_ThenResultList_NotEmpty(){

        fib = new Fib(1);
        List<Integer> fibs = fib.getFibSeries();

        Assertions.assertFalse(fibs.isEmpty());
        Assertions.assertEquals(0, fibs.get(0));
    }

    @Test
    public void TestGetFibSeriesWhenRange_1_ThenResultList_Contain_0(){

        fib = new Fib(1);
        List<Integer> fibs = fib.getFibSeries();

        Assertions.assertEquals(0, fibs.get(0));
    }

    @Test
    public void TestGetFibSeriesWhenRange_6_ThenResultList_Contain_3(){
        fib = new Fib(6);
        List<Integer> fibs = fib.getFibSeries();

        Assertions.assertTrue(fibs.contains(3));
    }

    @Test
    public void TestGetFibSeriesWhenRange_6_ThenResultList_Contain_6_element(){
        fib = new Fib(6);
        List<Integer> fibs = fib.getFibSeries();

        Assertions.assertEquals(6, fibs.size());
    }

    @Test
    public void TestGetFibSeriesWhenRange_6_ThenResultList_NotContain_4(){
        fib = new Fib(6);
        List<Integer> fibs = fib.getFibSeries();

        Assertions.assertFalse(fibs.contains(4));
    }

    @Test
    public void TestGetFibSeriesWhenRange_6_ThenResultList_ContainExpectedValues(){
        fib = new Fib(6);
        List<Integer> allExpectedValues =  Arrays.asList(0, 1, 1, 2, 3, 5);
        List<Integer> fibs = fib.getFibSeries();

        Assertions.assertEquals(allExpectedValues, fibs);

    }

    @Test
    public void TestGetFibSeriesWhenRange_6_ThenResultList_IsAscSorted(){
        fib = new Fib(6);
        List<Integer> fibs = fib.getFibSeries();
        List<Integer> sortedResult = new ArrayList<>(fibs);
        Collections.sort(sortedResult);

        Assertions.assertEquals(sortedResult, fibs);
    }
}
