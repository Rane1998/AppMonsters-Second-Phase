package com.example.utravel;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitConverterTest {

    @Test
    public void convertKiloToPounds() {
        float result = UnitConverter.convertKiloToPounds(1);
        assertEquals(2.20462,result,0.001);

    }
}