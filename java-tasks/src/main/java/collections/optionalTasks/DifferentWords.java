package collections.optionalTasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DifferentWords {
    private static final String PATH_TO_FILE = "src/main/resources/differentWords.txt";

    public static void main(String[] args) {

        Set<String> wordsSet = new HashSet<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_FILE));
            String resultLineFromFile = bufferedReader.readLine();
            while (resultLineFromFile != null) {
                String wordsLine = resultLineFromFile.trim();
                String[] wordsArray = wordsLine.split(" ");
                for (int i = 0; i <= wordsArray.length - 1; i++) {
                    wordsSet.add(wordsArray[i].toLowerCase());
                }
                resultLineFromFile = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(wordsSet);
    }
}
