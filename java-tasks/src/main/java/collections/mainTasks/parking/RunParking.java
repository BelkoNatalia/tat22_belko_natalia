package collections.mainTasks.parking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RunParking {
    private static final String PATH_TO_FILE = "src/main/resources/parking.txt";

    public static void main(String[] args) {
        List<Integer> parking = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_FILE));
            String result = bufferedReader.readLine();
            while (result != null) {
                int intResult = Integer.parseInt(result);
                parking.add(intResult);
                result = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parking currentParking = new Parking(parking);
        currentParking.arrive(3);

        System.out.println(currentParking);
        currentParking.driveOff(2);

        System.out.println(currentParking);
    }
}
