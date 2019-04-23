package collections.mainTasks.circlOfPeople;

public class Person {
    private int numberPerson;

    public Person(int numberPerson) {
        this.numberPerson = numberPerson;
    }

    public int getNumberPerson() {
        return numberPerson;
    }

    public void setNumberPerson(int numberPerson) {
        this.numberPerson = numberPerson;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Person" + numberPerson +
                '}';
    }
}
