package com.obee.code.challenges;

import org.springframework.stereotype.Service;

/**
 * Challenge: Convert Roman Numeral to Integer and vice versa
 */
@Service
public class RomanNumeralConverterService {

    private int getNumeralToIntValue(char numeral) {
        switch (numeral) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    private boolean validateRomanNumeral(String input) {
        if(input == null) return false;

        return input.toUpperCase().matches("^[IVXLCDM]+\\.?");
    }

    public int getIntegerValueOfRomanNumeral(String input) {
        if(!validateRomanNumeral(input)) return -1;

        char[] splitNumerals = input.toUpperCase().toCharArray();
        int total = 0;

        for (int i =0; i < splitNumerals.length; i++) {

            boolean hasNextNumeral = i + 1 < splitNumerals.length;
            int currentNumeral = getNumeralToIntValue(splitNumerals[i]);

            if(hasNextNumeral) {
                int nextNumeral = getNumeralToIntValue(splitNumerals[i+1]);
                if (currentNumeral < nextNumeral) {
                    total -= currentNumeral;
                } else {
                    total += currentNumeral;
                }
            } else {
                total += getNumeralToIntValue(splitNumerals[i]);
            }
        }
        return total;
    }
}