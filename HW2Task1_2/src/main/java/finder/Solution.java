package main.java.finder;

public class Solution {
    public static void main(String[] args){
        String currentDir = System.getProperty("user.dir");
        String inputFile = currentDir + "\\HW2Task1_2\\src\\test\\java\\finder\\FileForAnalyzing1.java";
        String outputFileBytes = currentDir + "\\out\\test_bytes.txt";
        String outputFileSymbols = currentDir + "\\out\\test_symbols.txt";
        JavaKeyWordsFinderBytesIO.findJavaKeyWords(inputFile, outputFileBytes);
        JavaKeyWordsFinderSymbolsIO.findJavaKeyWords(inputFile, outputFileSymbols);
    }
}
