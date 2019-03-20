package main.java.finder;

public class Solution {
    public static void main(String[] args){
        String currentDir = System.getProperty("user.dir");
        String inputFile = currentDir + "\\HW2Task1\\src\\test\\java\\finder\\FileForAnalyzing1";
        String outputFile = currentDir + "\\out\\test.txt";
        JavaKeyWordsFinder.findJavaKeyWords(inputFile, outputFile);
    }
}
