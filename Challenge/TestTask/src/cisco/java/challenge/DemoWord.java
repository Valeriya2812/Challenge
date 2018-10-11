package cisco.java.challenge;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoWord {
    private static String ENCODING = "UTF-8";

    public static String readMyFile(String fileName) {
        StringBuilder result = new StringBuilder();
        String s;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), ENCODING))) {
            while ((s = br.readLine()) != null) {
                result.append(s).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.print("Данного файла не существует!");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = readMyFile("words.txt");
        Word words = new Word();
        Pattern pattern = Pattern.compile("(?U)(\\b\\w+\\b)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            words.addWord(matcher.group());
        }
        words.printWords();
    }
}
