package test.java.finder;

import main.java.finder.KeyWordsFinder;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KeyWordsFinderTest {
    @Test
    public void validKeyWordsFinderCreation() throws Exception{
        String notNullString = "for if";
        KeyWordsFinder keyWordsFinder = new KeyWordsFinder(notNullString);
        assertEquals(notNullString,keyWordsFinder.getKeyWords());
    }

    @Test
    public void setValidKeyWords() throws Exception{
        KeyWordsFinder keyWordsFinder = new KeyWordsFinder("setValidKeyWords");
        String notNullString = "for if";
        keyWordsFinder.setKeyWords(notNullString);
        assertEquals(notNullString,keyWordsFinder.getKeyWords());
    }

    @Test
    public void inputFullyMatchesPattern() throws Exception{
        String pattern = "for if";
        String input = "for if";
        String expectedResult = "2\nfor: 1\nif: 1";
        String result = null;
        KeyWordsFinder keyWordsFinder = new KeyWordsFinder(pattern);
        result = keyWordsFinder.findKeyWords(input);
        assertEquals(expectedResult,result);
    }

    @Test
    public void inputPartiallyMatchesPattern() throws Exception{
        String pattern = "for ifcase continue";
        String input = "continue if case";
        String expectedResult = "1\ncontinue: 1";
        String result = null;
        KeyWordsFinder keyWordsFinder = new KeyWordsFinder(pattern);
        result = keyWordsFinder.findKeyWords(input);
        assertEquals(expectedResult,result);
    }

    @Test
    public void inputDoesNotMatchesPattern() throws Exception{
        String pattern = "for if";
        String input = "case abstract";
        String expectedResult = "0";
        String result = null;
        KeyWordsFinder keyWordsFinder = new KeyWordsFinder(pattern);
        result = keyWordsFinder.findKeyWords(input);
        assertEquals(expectedResult,result);
    }

    @Test
    public void inputIsEmpty() throws Exception{
        String pattern = "for if";
        String input = "";
        String expectedResult = "0";
        String result = null;
        KeyWordsFinder keyWordsFinder = new KeyWordsFinder(pattern);
        result = keyWordsFinder.findKeyWords(input);
        assertEquals(expectedResult,result);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = Exception.class)
    public void failedAttemptToCreateKeyWordFinderWithNullKeyWords() throws Exception{
        String nullString = null;
        KeyWordsFinder keyWordsFinder = new KeyWordsFinder(nullString);
        thrown.expectMessage("String with key words should be not null.");
    }

    @Test(expected = Exception.class)
    public void failedAttemptToSetNullKeyWords() throws Exception{
        KeyWordsFinder keyWordsFinder = new KeyWordsFinder("setValidKeyWords");
        String nullString = null;
        keyWordsFinder.setKeyWords(nullString);
        thrown.expectMessage("String with key words should be not null.");
    }

    @Test(expected = Exception.class)
    public void inputIsNull() throws Exception{
        String pattern = "for if";
        String input = null;
        String expectedResult = "0";
        String result = null;
        KeyWordsFinder keyWordsFinder = new KeyWordsFinder(pattern);
        result = keyWordsFinder.findKeyWords(input);
        thrown.expectMessage("String with key words should be not null.");
    }
}
