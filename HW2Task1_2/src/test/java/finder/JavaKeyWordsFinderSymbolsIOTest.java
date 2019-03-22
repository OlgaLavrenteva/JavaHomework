package test.java.finder;

import main.java.finder.JavaKeyWordsFinderSymbolsIO;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.assertTrue;

public class JavaKeyWordsFinderSymbolsIOTest {
    String currentDir = System.getProperty("user.dir");
    String outputFile = currentDir + "\\out\\jkw_result.txt";

    @Test
    public void inputFileFullyMatchesJavaKeyWords(){
        String inputFile = currentDir + "\\HW2Task1_2\\src\\test\\java\\finder\\FileForAnalyzingAllJKW.java";

        try {
            JavaKeyWordsFinderSymbolsIO.findJavaKeyWords(inputFile, outputFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        StringBuilder input = new StringBuilder("");
        try(BufferedReader bufReader = new BufferedReader(new FileReader(outputFile))) {
            String inputLine = "";
            while ((inputLine = bufReader.readLine()) != null) {
                input.append(inputLine);
                input.append(" ");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        String expectedOutputFileContent = "50 synchronized: 1 do: 1 float: 1 while: 1 protected: 1 continue: 1 else: 1 " +
                "catch: 1 if: 1 case: 1 new: 1 package: 1 static: 1 void: 1 double: 1 byte: 1 finally: 1 this: 1 " +
                "strictfp: 1 throws: 1 enum: 1 extends: 1 transient: 1 final: 1 try: 1 implements: 1 private: 1 " +
                "import: 1 const: 1 for: 1 interface: 1 long: 1 switch: 1 default: 1 goto: 1 public: 1 native: 1 " +
                "assert: 1 class: 1 break: 1 volatile: 1 abstract: 1 int: 1 instanceof: 1 super: 1 boolean: 1 throw: 1 " +
                "char: 1 short: 1 return: 1";

        assertTrue(expectedOutputFileContent.equals(input.toString().trim()));
    }

    @Test
    public void inputFilePartiallyMatchesJavaKeyWordsUseCase(){
        String inputFile = currentDir + "\\HW2Task1_2\\src\\test\\java\\finder\\FileForAnalyzingUseCase.java";

        try {
            JavaKeyWordsFinderSymbolsIO.findJavaKeyWords(inputFile, outputFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        StringBuilder input = new StringBuilder("");
        try(BufferedReader bufReader = new BufferedReader(new FileReader(outputFile))) {
            String inputLine = "";
            while ((inputLine = bufReader.readLine()) != null) {
                input.append(inputLine);
                input.append(" ");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        String expectedOutputFileContent = "101 new: 11 private: 9 package: 1 static: 2 void: 7 import: 1 for: 4 " +
                "this: 5 int: 14 public: 11 else: 4 final: 2 if: 16 class: 5 return: 9";

        assertTrue(expectedOutputFileContent.equals(input.toString().trim()));
    }

    @Test
    public void inputFileIsEmpty(){
        String inputFile = currentDir + "\\HW2Task1_2\\src\\test\\java\\finder\\EmptyFileForAnalyzing.java";

        try {
            JavaKeyWordsFinderSymbolsIO.findJavaKeyWords(inputFile, outputFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        StringBuilder input = new StringBuilder("");
        try(BufferedReader bufReader = new BufferedReader(new FileReader(outputFile))) {
            String inputLine = "";
            while ((inputLine = bufReader.readLine()) != null) {
                input.append(inputLine);
                input.append(" ");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        String expectedOutputFileContent = "0";

        assertTrue(expectedOutputFileContent.equals(input.toString().trim()));
    }

    @Test
    public void inputFileDoesNotExist(){
        String inputFile = "NotExistingFile";
        try {
            JavaKeyWordsFinderSymbolsIO.findJavaKeyWords(inputFile, outputFile);
        } catch (Exception e) {
            assertTrue(e.getMessage().equals("NotExistingFile doesn't exist."));
        }
    }

    @Test
    public void outputFileDoesNotExist(){
        String inputFile = currentDir + "\\HW2Task1_2\\src\\test\\java\\finder\\EmptyFileForAnalyzing.java";
        outputFile = "NotExistingFile";
        try {
            JavaKeyWordsFinderSymbolsIO.findJavaKeyWords(inputFile, outputFile);
        } catch (Exception e) {
            assertTrue(e.getMessage().equals("NotExistingFile doesn't exist."));
        }
    }

    @Test
    public void inputFileIsNull(){
        String inputFile = null;
        try {
            JavaKeyWordsFinderSymbolsIO.findJavaKeyWords(inputFile, outputFile);
        } catch (Exception e) {
            assertTrue(e.getMessage().equals("Input file is not passed."));
        }
    }

    @Test
    public void outputFileIsNull(){
        String inputFile = currentDir + "\\HW2Task1_2\\src\\test\\java\\finder\\EmptyFileForAnalyzing.java";
        outputFile = null;
        try {
            JavaKeyWordsFinderSymbolsIO.findJavaKeyWords(inputFile, outputFile);
        } catch (Exception e) {
            assertTrue(e.getMessage().equals("Output file is not passed."));
        }
    }
}

