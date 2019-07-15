package ioTask;

import java.io.*;

public class SortRandomNumbers {
    private static final String PATH_TO_NEW_DIR = "./src/main/resources/sortDir";
    private static final String NAME_INITIAL_FILE = "start.txt";
    private static final String PATH_INITIAL_FILE = "./src/main/resources/sortDir/start.txt";
    private static final String PATH_FINAL_FILE = "./src/main/resources/sortDir/finish.txt";
    private static int amountNumbers = 15;

    public static void main(String[] args) {
        File dir = new File(PATH_TO_NEW_DIR);
        boolean isDirCreated = dir.mkdir();
        File initialNumbersFile = new File(PATH_TO_NEW_DIR + File.separator + NAME_INITIAL_FILE);
        if(isDirCreated) {
            try {
                initialNumbersFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter writerNumbers = new BufferedWriter(new FileWriter(PATH_INITIAL_FILE))){
            for(int i = 0; i < amountNumbers; i++) {
                int number = (int) (Math.random() * 10 + 1);
                writerNumbers.write(String.valueOf(number) + " ");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedReader numbersReader = new BufferedReader(new FileReader(PATH_INITIAL_FILE));
                BufferedWriter sortedNumbersWriter = new BufferedWriter(new FileWriter(PATH_FINAL_FILE))) {
            String infoLine = numbersReader.readLine();
            String[] numbersStringArr = infoLine.split(" ");
            int[] numbersIntArray = new int[numbersStringArr.length];
            for (int i = 0; i < numbersStringArr.length; i++) {
                numbersIntArray[i] = Integer.parseInt(numbersStringArr[i]);
            }
            for (int i = numbersIntArray.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (numbersIntArray[j] > numbersIntArray[j + 1]) {
                        int temp = numbersIntArray[j];
                        numbersIntArray[j] = numbersIntArray[j + 1];
                        numbersIntArray[j + 1] = temp;
                    }
                }
            }
            for (int i = 0; i < numbersIntArray.length; i++) {
                sortedNumbersWriter.write(String.valueOf(numbersIntArray[i]) + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
