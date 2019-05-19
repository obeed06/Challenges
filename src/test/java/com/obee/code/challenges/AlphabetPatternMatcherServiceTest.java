package com.obee.code.challenges;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlphabetPatternMatcherServiceTest {

    @Autowired
    AlphabetPatternMatcherService patternMatcherService;

    @Test
    public void testVariousInputStrings() {
        assertEquals( "",       patternMatcherService.getPattern(""));
        assertEquals( "",       patternMatcherService.getPattern("lkmosimdfvoid"));
        assertEquals( "abcde",  patternMatcherService.getPattern("abcde"));
        assertEquals( "abcde",  patternMatcherService.getPattern("abcdevwxyz"));
        assertEquals( "vwxyz",  patternMatcherService.getPattern("abcdvwxyz"));
        assertEquals( "vwxyz",  patternMatcherService.getPattern("abcdblahvwxyz"));
        assertEquals( "vwxyz",  patternMatcherService.getPattern("abcdblahblahvwxyzblah"));
    }
}