package main.java.finder;

import java.io.*;

public class JavaKeyWordsFinderBytesIO {
    public static final String JAVA_KEY_WORDS = "abstract continue for new switch assert default goto package synchronized " +
            "boolean do if private this break double implements protected throw byte else import public throws case " +
            "enum instanceof return transient catch extends int short try char final interface static void class finally " +
            "long strictfp volatile const float native super while";

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
        try(BufferedInputStream bufInpFileStream = new BufferedInputStream(new FileInputStream(inputFile),1024)){
            StringBuilder input = new StringBuilder("");
            byte[] bytes = new byte[1024];
            while (bufInpFileStream.available() > 0){
                int bytesRead = bufInpFileStream.read(bytes);
                input.append(new String(bytes,0,bytesRead));
            }

            try{
                KeyWordsFinder javaWordsFinder = new KeyWordsFinder(JAVA_KEY_WORDS);
                foundMatches = javaWordsFinder.findKeyWords(input.toString());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        } catch (IOException e){
            throw new IOException(inputFile + " doesn't exist.");
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
