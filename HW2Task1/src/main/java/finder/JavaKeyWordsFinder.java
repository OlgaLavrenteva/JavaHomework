package main.java.finder;

import java.io.*;

public class JavaKeyWordsFinder {
    static String JAVA_KEY_WORDS = "package for while class if";

    /**
     * The method takes inputFile, looks for Java Key Words listed in JAVA_KEY_WORDS constant and then puts matches and their count into outputFile.
     * @param inputFile - Java Key Words will be searched in the file
     * @param outputFile - found in inputFile Java Key Words and their count will be stored in outputFile
     */
    static void findJavaKeyWords(String inputFile, String outputFile){
        String foundMatches = "";
        try(BufferedInputStream bufInpFileStream = new BufferedInputStream(new FileInputStream(inputFile),1024)){
            StringBuilder input = new StringBuilder("");
            byte[] bytes = new byte[1024];
            while (bufInpFileStream.available() > 0) {
                int bytesRead = bufInpFileStream.read(bytes);
                input.append(new String(bytes,0,bytesRead));
            }
            KeyWordsFinder javaWordsFinder = new KeyWordsFinder(JAVA_KEY_WORDS);
            foundMatches = javaWordsFinder.findKeyWords(input.toString());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        try (BufferedOutputStream outputFileBytes = new BufferedOutputStream(new FileOutputStream(outputFile))){
            byte[] outputBytes = foundMatches.getBytes();
            outputFileBytes.write(outputBytes);
            outputFileBytes.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
