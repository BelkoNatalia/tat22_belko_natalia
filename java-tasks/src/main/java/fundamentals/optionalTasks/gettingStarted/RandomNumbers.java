package fundamentals.optionalTasks.gettingStarted;

public class RandomNumbers {
    public static void main(String[] args) {
        int inputNumber = Integer.parseInt(args[0]);

        for (int i = 0; i < inputNumber; i++) {
            System.out.println(generateRandomNumber());
        }
        for (int i = 0; i < inputNumber; i++) {
            System.out.print(generateRandomNumber() + " ");
        }
    }

    private static int generateRandomNumber(){
       int randomNumber = (int) (Math.random() * 10 + 1);
       return randomNumber;
    }
}
