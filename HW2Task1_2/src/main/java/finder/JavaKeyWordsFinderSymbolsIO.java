package main.java.finder;

import java.io.*;

public class JavaKeyWordsFinderSymbolsIO {
    /**
     * The method takes inputFile, looks for Java Key Words listed in JAVA_KEY_WORDS constant and then puts matches and
     * their count into outputFile. The method throws exception in case of nonexistent input or output file.
     * @param inputFile - Java Key Words will be searched in the file
     * @param outputFile - found in inputFile Java Key Words and their count will be stored in outputFile
     * @throws Exception
     */
    public static void findJavaKeyWords(String inputFile, String outputFile) throws Exception{
        if (inputFile==null){
            throw new Exception("Input file is not passed.");
        }
        if (outputFile==null){
            throw new Exception("Output file is not passed.");
        }
        String foundMatches = "";
        try(BufferedReader bufReader = new BufferedReader(new FileReader(inputFile))){
            StringBuilder input = new StringBuilder("");
            String inputLine = "";
            while ((inputLine = bufReader.readLine()) != null){
                input.append(inputLine);
                input.append(" ");
            }

            try{
                KeyWordsFinder javaWordsFinder = new KeyWordsFinder(JavaKeyWordsFinderBytesIO.JAVA_KEY_WORDS);
                foundMatches = javaWordsFinder.findKeyWords(input.toString());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        } catch (IOException e){
            throw new IOException(inputFile + " doesn't exist.");
        }
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(outputFile))){
            bufWriter.write(foundMatches);
            bufWriter.flush();
        } catch (IOException e){
            throw new IOException(inputFile + " doesn't exist.");
        }
    }
}
