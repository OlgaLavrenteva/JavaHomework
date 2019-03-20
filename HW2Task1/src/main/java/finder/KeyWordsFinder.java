package main.java.finder;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class KeyWordsFinder {
    private String keyWords;

    /**
     * KeyWordsFinder constructor takes String with listed Key Words for searching.
     * @param keyWords
     */
    public KeyWordsFinder(String keyWords) {
        this.keyWords = keyWords;
    }

    /**
     * The method takes string as a parameter, looks for keyWords in the string and returns string with matches and their count.
     * @param input
     * @return
     */
    public String findKeyWords(String input) {
        String[] arrKeyWords = keyWords.split(" ");
        HashMap<String, Integer> matches = new HashMap<String, Integer>();

        for(int i=0; i<arrKeyWords.length; i++) {
            String substr = "(^|[^a-zA-Z])" + arrKeyWords[i] + "([^a-zA-Z]|^)";
            Pattern p = Pattern.compile(substr);
            Matcher m = p.matcher(input);
            int localCounter = 0;
            while(m.find()) {
                localCounter++;
            }
            if (localCounter > 0){
                matches.put(arrKeyWords[i],localCounter);
            }
        }

        int counter = 0;
        StringBuilder resultWords = new StringBuilder("");

        for (String word: matches.keySet()){
            resultWords.append("\n");
            resultWords.append(word);
            resultWords.append(": ");
            resultWords.append(matches.get(word));
            counter = counter + matches.get(word);
        }

        String result = String.valueOf(counter) + resultWords;

        return result;
    }
}
