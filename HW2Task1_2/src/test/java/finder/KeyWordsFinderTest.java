package test.java.finder;

import main.java.finder.KeyWordsFinder;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KeyWordsFinderTest {
    @Test
    public void validKeyWordsFinderCreation(){
        String nonEmptyString = "for if";
        try{
            KeyWordsFinder keyWordsFinder = new KeyWordsFinder(nonEmptyString);
            assertTrue(keyWordsFinder.getKeyWords().equals(nonEmptyString));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void setValidKeyWords(){
        try{
            KeyWordsFinder keyWordsFinder = new KeyWordsFinder("setValidKeyWords");
            String nonEmptyString = "for if";
            keyWordsFinder.setKeyWords(nonEmptyString);
            assertTrue(keyWordsFinder.getKeyWords().equals(nonEmptyString));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
