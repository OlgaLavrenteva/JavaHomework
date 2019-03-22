/*package test.java.finder;

import main.java.finder.JavaKeyWordsFinderBytesIO;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class JavaKeyWordsFinderBytesIOTest {
    String currentDir = System.getProperty("user.dir");
    String outputFile = currentDir + "\\out\\jkw_result.txt";

    @Test
    public void inputFileFullyMatchesJavaKeyWords(){
        String inputFile = currentDir + "\\HW2Task1_2\\src\\test\\java\\finder\\FileForAnalyzingAllJKW.java";

        try {
            JavaKeyWordsFinderBytesIO.findJavaKeyWords(inputFile, outputFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try(BufferedReader bufReader = new BufferedReader(new FileReader(outputFile))) {
            StringBuilder input = new StringBuilder("");
            String inputLine = "";
            while ((inputLine = bufReader.readLine()) != null) {
                input.append(inputLine);
                input.append(" ");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        String expectedOutputFileContent;
    }
}
*/