package collections.mainTasks.circlOfPeople;

import java.util.List;

public class Group {
    private List<Person> personsGroup;

    public Group(List<Person> personsGroup) {
        this.personsGroup = personsGroup;
    }

    public void deletePersons() {
        int currentSize = personsGroup.size();
        while (currentSize != 1) {
            for (int i = 0; i < currentSize; i++) {
                personsGroup.remove(i);
                currentSize--;
            }
        }
    }
}
