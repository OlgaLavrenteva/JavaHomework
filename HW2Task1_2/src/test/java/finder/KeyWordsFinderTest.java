package test.java.finder;

import main.java.finder.KeyWordsFinder;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KeyWordsFinderTest {
    @Test
    public void validKeyWordsFinderCreation() throws Exception{
        String notNullString = "for if";
        KeyWordsFinder keyWordsFinder = new KeyWordsFinder(notNullString);
        assertTrue(keyWordsFinder.getKeyWords().equals(notNullString));
    }

    @Test
    public void setValidKeyWords() throws Exception{
        KeyWordsFinder keyWordsFinder = new KeyWordsFinder("setValidKeyWords");
        String notNullString = "for if";
        keyWordsFinder.setKeyWords(notNullString);
        assertTrue(keyWordsFinder.getKeyWords().equals(notNullString));
    }

    @Test
    public void inputFullyMatchesPattern() throws Exception{
        String pattern = "for if";
        String input = "for if";
        String expectedResult = "2\nfor: 1\nif: 1";
        String result = null;
        KeyWordsFinder keyWordsFinder = new KeyWordsFinder(pattern);
        result = keyWordsFinder.findKeyWords(input);
        assertTrue(result.equals(expectedResult));
    }

    @Test
    public void inputPartiallyMatchesPattern() throws Exception{
        String pattern = "for ifcase continue";
        String input = "continue if case";
        String expectedResult = "1\ncontinue: 1";
        String result = null;
        KeyWordsFinder keyWordsFinder = new KeyWordsFinder(pattern);
        result = keyWordsFinder.findKeyWords(input);
        assertTrue(result.equals(expectedResult));
    }

    @Test
    public void inputDoesNotMatchesPattern() throws Exception{
        String pattern = "for if";
        String input = "case abstract";
        String expectedResult = "0";
        String result = null;
        KeyWordsFinder keyWordsFinder = new KeyWordsFinder(pattern);
        result = keyWordsFinder.findKeyWords(input);
        assertTrue(result.equals(expectedResult));
    }

    @Test
    public void inputIsEmpty() throws Exception{
        String pattern = "for if";
        String input = "";
        String expectedResult = "0";
        String result = null;
        KeyWordsFinder keyWordsFinder = new KeyWordsFinder(pattern);
        result = keyWordsFinder.findKeyWords(input);
        assertTrue(result.equals(expectedResult));
    }

    @Test
    public void failedAttemptToCreateKeyWordFinderWithNullKeyWords(){
        String nullString = null;
        try {
            KeyWordsFinder keyWordsFinder = new KeyWordsFinder(nullString);
        } catch(Exception e){
            assertTrue(e.getMessage().equals("String with key words should be not null."));
        }
    }

    @Test
    public void failedAttemptToSetNullKeyWords(){
        try{
            KeyWordsFinder keyWordsFinder = new KeyWordsFinder("setValidKeyWords");
            String nullString = null;
            keyWordsFinder.setKeyWords(nullString);
        } catch(Exception e){
            assertTrue(e.getMessage().equals("String with key words should be not null."));
        }
    }

    @Test
    public void inputIsNull(){
        String pattern = "for if";
        String input = null;
        String expectedResult = "0";
        String result = null;
        try {
            KeyWordsFinder keyWordsFinder = new KeyWordsFinder(pattern);
            result = keyWordsFinder.findKeyWords(input);
        } catch(Exception e){
            assertTrue(e.getMessage().equals("String for search should be not null."));
        }
    }
}
