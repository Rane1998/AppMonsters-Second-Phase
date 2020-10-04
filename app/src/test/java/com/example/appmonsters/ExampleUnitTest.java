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
    private DistanceConverter distanceConverter;
@Before
    public void setUp(){
    distanceConverter= new DistanceConverter();

    }
    @Test
    public void meter_isCorrect(){
    float result = DistanceConverter.convertToMeters(3);
    assertEquals(3000,result,0.001);
    }

    @Test
    public void yards_isCorrect(){
        float result = DistanceConverter.convertToYards(1);
        assertEquals(1093.61,result,0.001);
    }
    @Test
    public void miles_isCorrect(){
        float result = DistanceConverter.convertToMiles(1);
        assertEquals(0.6213,result,0.001);
    }
    @Test
    public void feet_isCorrect(){
        float result = DistanceConverter.convertToFeet(1);
        assertEquals(3280.84,result,0.001);
    }
}