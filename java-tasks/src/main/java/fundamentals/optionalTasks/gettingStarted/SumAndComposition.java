package fundamentals.optionalTasks.gettingStarted;

public class SumAndComposition {
    public static void main(String[] args) {
        System.out.println("Sum of command line arguments = " + calculateSum(args));
        System.out.println("Composition of command line arguments = " + calculateComposition(args));
    }

    private static int calculateSum(String[] args) {
        int sumOfElementArray = 0;
        for (int i = 0; i < args.length; i++) {
            int intNumberOfArray = Integer.parseInt(args[i]);
            sumOfElementArray = sumOfElementArray + intNumberOfArray;
        }
        return sumOfElementArray;
    }

    private static int calculateComposition(String[] args) {
        int compositionOfElementArray = 1;
        for (int i = 0; i < args.length; i++) {
            int intNumberOfArray = Integer.parseInt(args[i]);
            compositionOfElementArray = compositionOfElementArray * intNumberOfArray;
        }
        return compositionOfElementArray;
    }

}
