package main.java.finder;

public class Solution {
    public static void main(String[] args){
        String currentDir = System.getProperty("user.dir");
        String inputFile = currentDir + "\\HW2Task1_2\\src\\test\\java\\finder\\FileForAnalyzingUseCase.java";
        String outputFileBytes = currentDir + "\\out\\test_bytes.txt";
        String outputFileSymbols = currentDir + "\\out\\test_symbols.txt";
        //JavaKeyWordsFinderBytesIO.findJavaKeyWords(inputFile, outputFileBytes);
        //JavaKeyWordsFinderSymbolsIO.findJavaKeyWords(inputFile, outputFileSymbols);

        //inputFile = currentDir + "\\HW2Task1_2\\src\\test\\java\\finder\\EmptyFileForAnalyzing.java";
        //JavaKeyWordsFinderBytesIO.findJavaKeyWords(inputFile, outputFileBytes);
        //JavaKeyWordsFinderSymbolsIO.findJavaKeyWords(inputFile, outputFileSymbols);

        inputFile = currentDir + "\\HW2Task1_2\\src\\test\\java\\finder\\FileForAnalyzingAllJKW.java";
        JavaKeyWordsFinderBytesIO.findJavaKeyWords(inputFile, outputFileBytes);
        JavaKeyWordsFinderSymbolsIO.findJavaKeyWords(inputFile, outputFileSymbols);
    }
}
