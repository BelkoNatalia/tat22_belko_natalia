package errorExceprion;

import errorExceprion.exceptions.ReadFileException;
import errorExceprion.exceptions.ValidationException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Executor {
    public List<String> getLineList(String path) throws IOException, FileNotFoundException, ReadFileException {
        List<String> lineList = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String numberInfo = bufferedReader.readLine();
        if (numberInfo == null) {
            throw new ReadFileException("File is empty");
        }
        while (numberInfo != null) {
            lineList.add(numberInfo);
            numberInfo = bufferedReader.readLine();
        }
        return lineList;
    }

    public List<Double> getNumberList(List<String> lineList) {
        List<Double> numberList = new ArrayList<Double>();
        for (String numberInfo : lineList) {
            double numberAfterParse = Double.parseDouble(numberInfo);
            numberList.add(numberAfterParse);
        }
        return numberList;
    }

    public void checkValidValues(List<Double> numberList) throws ValidationException {
        for (int i = 0; i < numberList.size(); i++) {
            double currentNumber = numberList.get(i);
            if (currentNumber == Double.NEGATIVE_INFINITY) {
                throw new ValidationException("List has number = 'negative infinity'");
            } else if (currentNumber == Double.POSITIVE_INFINITY) {
                throw new ValidationException("List has number = 'positive infinity'");
            }
        }
    }

    public double calculateSum(List<Double> numberList) {
        double sum = 0;
        for (Double number : numberList) {
            sum = sum + number;
        }
        return sum;
    }

    public double calculateAverage(List<Double> numberList) {
        return calculateSum(numberList) / numberList.size();
    }
}
