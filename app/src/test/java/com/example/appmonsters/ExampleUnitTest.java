package com.example.appmonsters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private CurrencyConverter CurrencyConverter;

    @Before
    public void setUp(){
        CurrencyConverter = new CurrencyConverter();
    }

    @Test
    public void USD_isCorrect(){
        double result = CurrencyConverter.LkrtoUsd((float) 0.54);
        assertEquals(100, result, 0.001);
    }

    @Test
    public void Euro_isCorrect(){
        double result = CurrencyConverter.LkrtoEur((float) 0.51);
        assertEquals(110, result, 0.001);
    }

    @Test
    public void INR_isCorrect(){
        double result = CurrencyConverter.LkrtoInr((float) 79.47);
        assertEquals(200, result, 0.001);
    }

    @Test
    public void JPY_isCorrect(){
        double result = CurrencyConverter.LkrtoJpy((float) 570.81);
        assertEquals(1000, result, 0.001);
    }
}