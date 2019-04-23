package errorExceprion;

import errorExceprion.exceptions.ReadFileException;
import errorExceprion.exceptions.ValidationException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Run {
    private static final String PATH_TO_FILE = "src/main/resources/info.txt";
    public static void main(String[] args){
        try {
            Executor executor = new Executor();
            List<String> lineList = null;
            try {
                lineList = executor.getLineList(PATH_TO_FILE);
            } catch (FileNotFoundException e) {
                System.out.println("File not found." + e.getMessage());
                System.exit(15);
            } catch (IOException e) {
                System.out.println("File could not be read");
                System.exit(20);
            } catch (ReadFileException e) {
                System.out.println(e.getMessage());
                System.exit(20);
            }

            List<Double> numberList = null;
            try {
                numberList = executor.getNumberList(lineList);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect date in file." + e.getMessage());
                System.exit(25);
            }
            try {
                executor.checkValidValues(numberList);
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
                System.exit(30);
            }
            double sum = executor.calculateSum(numberList);
            double average = executor.calculateAverage(numberList);
            System.out.println("sum = " + sum);
            System.out.println("average = " + average);
        } catch (OutOfMemoryError e){
            System.out.println("Out of memory");
        }
    }
}
