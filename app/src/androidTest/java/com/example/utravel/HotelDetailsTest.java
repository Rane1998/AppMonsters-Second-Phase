package com.example.utravel;

import org.junit.Test;

import static org.junit.Assert.*;

public class HotelDetailsTest {

    @Test
    public void calculateAmount() {
            float result  = HotelDetails.calculateAmount(2);
            assertEquals(5000.0,result,0.002);
    }
}