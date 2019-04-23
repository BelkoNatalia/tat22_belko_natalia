package collections.optionalTasks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DirectReverseOrder {
    private static final String PATH_TO_FILE_START = "src/main/resources/directReverseOrder.txt";
    private static final String PATH_TO_FILE_FINISH = "src/main/resources/directReverseOrderNext.txt";

    public static void main(String[] args) {

        List<String> linesList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_FILE_START));
            String resultLineFromFile = bufferedReader.readLine();
            while (resultLineFromFile != null) {
                linesList.add(resultLineFromFile);
                resultLineFromFile = bufferedReader.readLine();
            }
            bufferedReader.close();
            System.out.println(linesList);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_TO_FILE_FINISH));
            int size = linesList.size() - 1;
            for (int i = size; i >= 0; i--) {
                String count = linesList.get(i);
                System.out.print(count + " ");
                bufferedWriter.write(count + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
