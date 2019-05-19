package com.obee.code.challenges;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RomanNumeralConverterServiceTest {

    @Autowired
    private RomanNumeralConverterService converterService;

    @Test
    public void testVariousRomanNumeralToIntValues() {
        assertEquals(-1,    converterService.getIntegerValueOfRomanNumeral("abc"));
        assertEquals(-1,    converterService.getIntegerValueOfRomanNumeral("1234"));
        assertEquals(5,     converterService.getIntegerValueOfRomanNumeral("V"));
        assertEquals(4,     converterService.getIntegerValueOfRomanNumeral("IV"));
        assertEquals(6,     converterService.getIntegerValueOfRomanNumeral("VI"));
        assertEquals(1904,  converterService.getIntegerValueOfRomanNumeral("MCMIV"));
        assertEquals(1007,  converterService.getIntegerValueOfRomanNumeral("ddvii"));
    }
}