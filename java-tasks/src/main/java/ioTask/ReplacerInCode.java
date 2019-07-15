package ioTask;

import java.io.*;

public class ReplacerInCode {
    private static final String REGEX_REPLACE = "public";
    private static final String REPLACEMENT_TEXT = "private";
    private static final String PATH_TO_NEW_DIR = "./src/main/resources/replaceDir";
    private static final String PATH_INITIAL_FILE = "./src/main/java/threadTask/Port.java";
    private static final String PATH_FINAL_FILE = "./src/main/resources/replaceDir/Port.java";

    public static void main(String[] args) {
        File dir = new File(PATH_TO_NEW_DIR);
        boolean isDirCreated = dir.mkdir();
        if(isDirCreated) {
            try (BufferedReader programReader = new BufferedReader(new FileReader(PATH_INITIAL_FILE));
                    BufferedWriter programWriter = new BufferedWriter(new FileWriter(PATH_FINAL_FILE))) {

                String infoLine = programReader.readLine();
                String lineAfterReplacement;
                while (infoLine != null) {
                    lineAfterReplacement = infoLine.replace(REGEX_REPLACE, REPLACEMENT_TEXT);
                    programWriter.write(lineAfterReplacement + "\n");
                    infoLine = programReader.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
