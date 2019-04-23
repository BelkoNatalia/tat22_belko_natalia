package collections.mainTasks.circlOfPeople;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RunCirclePersons {
    private static final int NUMBER_OF_PERSON = 150000;

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        for (int i = 1; i <= NUMBER_OF_PERSON; i++) {
            personList.add(new Person(i));
        }

        Group group = new Group(personList);
        long startTimeWithArrayList = System.currentTimeMillis();
        group.deletePersons();
        long timeSpentWithArrayList = System.currentTimeMillis() - startTimeWithArrayList;
        System.out.println("программа выполнялась с ArrayList " + timeSpentWithArrayList  + " миллисекунд");

        List<Person> personListLinkedMethod = new LinkedList<>();

        for (int i = 1; i <= NUMBER_OF_PERSON; i++) {
            personListLinkedMethod.add(new Person(i));
        }

        Group groupLinkedMethod = new Group(personListLinkedMethod);
        long startTimeWithLinkedList = System.currentTimeMillis();
        groupLinkedMethod.deletePersons();
        long timeSpentWithLinkedList = System.currentTimeMillis() - startTimeWithLinkedList;
        System.out.println("программа выполнялась с LinkedList " + timeSpentWithLinkedList + " миллисекунд");

    }
}
