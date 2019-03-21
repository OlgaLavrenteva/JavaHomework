package main.java.finder;

import java.io.*;

public class JavaKeyWordsFinderSymbolsIO {
    static final String JAVA_KEY_WORDS = "package for while class if";

    /**
     * The method takes inputFile, looks for Java Key Words listed in JAVA_KEY_WORDS constant and then puts matches and their count into outputFile.
     * @param inputFile - Java Key Words will be searched in the file
     * @param outputFile - found in inputFile Java Key Words and their count will be stored in outputFile
     */
    static void findJavaKeyWords(String inputFile, String outputFile){
        String foundMatches = "";
        try(BufferedReader bufReader = new BufferedReader(new FileReader(inputFile))){
            StringBuilder input = new StringBuilder("");
            String inputLine = "";
            while ((inputLine = bufReader.readLine()) != null){
                input.append(inputLine);
            }

            try{
                KeyWordsFinder javaWordsFinder = new KeyWordsFinder(JAVA_KEY_WORDS);
                foundMatches = javaWordsFinder.findKeyWords(input.toString());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(outputFile))){
            bufWriter.write(foundMatches);
            bufWriter.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
