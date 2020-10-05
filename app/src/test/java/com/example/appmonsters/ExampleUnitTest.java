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
    private TempConverter TempConverter;

    @Before
    public void setUp(){
        TempConverter = new TempConverter();
    }

    @Test
    public void celcius_isCorrect(){
        float result = TempConverter.converttoCelcius(100);
        assertEquals(37.77778, result, 0.001);
    }

    @Test
    public void farenheit_isCorrect(){
        float result = TempConverter.converttoFarenheit(100);
        assertEquals(212.0, result, 0.001);
    }
}