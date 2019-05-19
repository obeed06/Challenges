package com.obee.code.challenges;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 *
 * Challenge: given an input String like "abcdoqdvwxyz" return the longest sequential
 * String in the input String where the sequence is greater that two, else return an
 * empty String. When there are two Strings of the same length, return the first
 *
 **/
@Service
public class AlphabetPatternMatcherService {

    public String getPattern(String input) {
        ArrayList<String> matches = getMatches(input);

        if (matches.isEmpty()) {
            return "";
        }

        return getLongestString(matches);
    }

    private String getLongestString(ArrayList<String> matches) {
        int largestStringCount = matches.get(0).length();
        int largestStringIndex = 0;

        for(int i = 0; i < matches.size(); i++)
        {
            if(matches.get(i).length() > largestStringCount)
            {
                largestStringCount = matches.get(i).length();
                largestStringIndex = i;
            }
        }
        return matches.get(largestStringIndex);
    }

    private ArrayList<String> getMatches(String input) {
        ArrayList<String> matches = new ArrayList<>();
        int n = input.length();

        for (int i = 0; i < n - 1; i++) {
            int charStart = i;
            int charEnd = i;
            if (input.charAt(i) + 1 == input.charAt(i + 1)) {
                while (i < n - 1 && input.charAt(i) + 1 == input.charAt(i + 1)) {
                    i++;
                    charEnd = i;
                }
            }
            if (charEnd + 1 - charStart > 2) {
                matches.add(input.substring(charStart, charEnd+1));
            }
        }
        return matches;
    }
}