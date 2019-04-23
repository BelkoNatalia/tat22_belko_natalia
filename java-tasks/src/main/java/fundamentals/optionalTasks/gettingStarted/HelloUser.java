package fundamentals.optionalTasks.gettingStarted;

public class HelloUser {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print("Hello, " + args[i] + "!");
        }
    }
}