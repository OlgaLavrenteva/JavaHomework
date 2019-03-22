package main.java.finder;

import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class KeyWordsFinder{
    private String keyWords;

    /**
     * KeyWordsFinder constructor takes String with listed Key Words for searching.
     * @param keyWords
     */
    public KeyWordsFinder(String keyWords) throws Exception{
        this.setKeyWords(keyWords);
    }

    /**
     * Setter method for keyWords field. The method can throw exception in case of null string.
     * @param keyWords
     * @throws Exception
     */

    public void setKeyWords(String keyWords)throws Exception{
        if (keyWords==null){
            throw new Exception("String for search should be not null.");
        } else{
            this.keyWords = keyWords.trim();
        }
    }

    /**
     * Getter method for keyWords field.
     * @return
     */
    public String getKeyWords(){
        return keyWords;
    }

    /**
     * The method takes string as a parameter, looks for keyWords in the string and returns string with matches and their count.
     * @param input
     * @return
     */
    public String findKeyWords(String input){
        String[] arrKeyWords = keyWords.split(" ");
        HashMap<String, Integer> matches = new HashMap<String, Integer>();

        for(int i=0; i<arrKeyWords.length; i++){
            String substr = "(^|[^a-zA-Z])" + arrKeyWords[i] + "([^a-zA-Z]|^)";
            Pattern p = Pattern.compile(substr);
            Matcher m = p.matcher(input);
            int localCounter = 0;
            while(m.find()){
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
