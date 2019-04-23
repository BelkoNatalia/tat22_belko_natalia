package fundamentals.optionalTasks.dataTypes;

import java.util.Scanner;

public class LongAndShortNumbersAndTheirLength {
    public static void main(String[] args) {
        int[] arrayOfInputNumbers = getEnterNumbers();
        printMinLengthOfNumber(arrayOfInputNumbers);
        printMaxLengthOfNumber(arrayOfInputNumbers);
    }

    private static int[] getEnterNumbers() {
        int[] entersNumbers = new int[getAmountOfNumbers()];
        System.out.println("Enter numbers");
        for (int i = 0; i < entersNumbers.length; i++) {
            Scanner sc = new Scanner(System.in);
            entersNumbers[i] = sc.nextInt();
        }
        return entersNumbers;
    }

    private static int getAmountOfNumbers() {
        System.out.println("Enter amount of numbers");
        Scanner sc = new Scanner(System.in);
        int amountOfNumbers = sc.nextInt();
        return amountOfNumbers;
    }

    private static int getLengthOfNumber(int currentNumber) {
        int lengthOfNumber = 0;
        while (Math.abs(currentNumber) > 0) {
            lengthOfNumber++;
            currentNumber = currentNumber / 10;
        }
        return lengthOfNumber;
    }

    private static void printMinLengthOfNumber(int[] arrayOfInputNumbers) {
        int minLengthOfNumber = getLengthOfNumber(arrayOfInputNumbers[0]);
        int shortestNumber = arrayOfInputNumbers[0];
        for (int i = 0; i < arrayOfInputNumbers.length; i++) {
            int lengthOfCurrentNumber = getLengthOfNumber(arrayOfInputNumbers[i]);
            if (lengthOfCurrentNumber < minLengthOfNumber) {
                minLengthOfNumber = lengthOfCurrentNumber;
                shortestNumber = arrayOfInputNumbers[i];
            }

        }
        System.out.println("\n" + "The shortest number is - " + shortestNumber + " it's length =  " + minLengthOfNumber);
    }

    private static void printMaxLengthOfNumber(int[] arrayOfInputNumbers) {
        int maxLengthOfNumber = getLengthOfNumber(arrayOfInputNumbers[0]);
        int longestNumber = arrayOfInputNumbers[0];
        for (int i = 0; i < arrayOfInputNumbers.length; i++) {
            int lengthOfCurrentNumber = getLengthOfNumber(arrayOfInputNumbers[i]);
            if (lengthOfCurrentNumber > maxLengthOfNumber) {
                maxLengthOfNumber = lengthOfCurrentNumber;
                longestNumber = arrayOfInputNumbers[i];
            }

        }
        System.out.println("\n" + "The longest number is - " + longestNumber + " it's length = " + maxLengthOfNumber);
    }

}

