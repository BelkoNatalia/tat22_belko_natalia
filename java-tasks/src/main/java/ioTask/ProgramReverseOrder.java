package ioTask;

import java.io.*;

public class ProgramReverseOrder {
    private static final String PATH_TO_NEW_DIR = "./src/main/resources/reverseDir";
    private static final String PATH_INITIAL_FILE = "./src/main/java/threadTask/Port.java";
    private static final String PATH_FINAL_FILE = "./src/main/resources/reverseDir/reverse.txt";

    public static void main(String[] args) {
        File dir = new File(PATH_TO_NEW_DIR);
        boolean isDirCreated = dir.mkdir();
        boolean isFolderExist = dir.exists();
        if (isDirCreated || isFolderExist) {
            try (BufferedReader reader = new BufferedReader(new FileReader(PATH_INITIAL_FILE));
                 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_FINAL_FILE))) {

                String rez = reader.readLine();
                String newRez;
                while (rez != null) {
                    char[] rezArr = rez.toCharArray();
                    for (int i = rezArr.length - 1; i > 0; i--) {
                        for (int j = 0; j < i; j++) {
                            char temp = rezArr[j];
                            rezArr[j] = rezArr[j + 1];
                            rezArr[j + 1] = temp;
                        }
                    }

                    bufferedWriter.write(new String(rezArr) + "\n");
                    rez = reader.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
