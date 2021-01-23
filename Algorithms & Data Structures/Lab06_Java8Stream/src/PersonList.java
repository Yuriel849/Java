import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonList {
    private List<Person> list = new ArrayList<Person>();

    /**
     * Constructs a list of Person objects, with dummy data about fictional people.
     */
    public PersonList() {
        list.add(new Person("Anna Zauber", 'F', 20, "U.S.A."));
        list.add(new Person("Benjamin Yassem", 'M', 31, "Palau"));
        list.add(new Person("Christopher Xing", 'M', 22, "U.K."));
        list.add(new Person("Daniela Holt", 'F', 44, "Germany"));
        list.add(new Person("Elisabeth A. K. McDonnell", 'F', 15, "Ireland"));
    }

    /**
     * Constructs a list of Person objects from the list provided as an argument.
     * The new list is identical to the list given as an argument.
     * @param list The source list.
     */
    public PersonList(List<Person> list) {
        this.list = new ArrayList<>(list);
    }

    /**
     * This method was overridden to print the contents of the list to the terminal.
     * @return An empty string, to be ignored.
     */
    @Override
    public String toString() {
        list.forEach(System.out::println);
        return "";
    }

    /**
     * Returns the average of the ages of every Person in the list.
     * The average age is rounded to the nearest integer.
     * @return The average age.
     */
    public int getAverageOfAges() {
        return getAverageOfAges(null);
    }

    /**
     * Returns the average of the ages of every Person in the list, after filtering the list according to the given condition.
     * @param condition The Predicate condition to filter the list with.
     * @return The average age.
     */
    public int getAverageOfAges(Predicate<Person> condition) {
        List<Person> list2 = list;
        if(condition != null)
             list2 = getPersonsByCondition(condition);

        return list2.stream()
//                .peek(System.out::println)
                .map(Person::getAge)
//                .peek(System.out::println)
                .reduce(0, Integer::sum)
                / list2.size();
    }

    /**
     * Filters the list of Persons according to the given condition.
     * @param condition The Predicate condition to filter the list with.
     * @return A new list containing the filtered results.
     */
    public List<Person> getPersonsByCondition(Predicate<Person> condition) {
        return list.stream()
//                .peek(System.out::println)
                .filter(condition)
//                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        PersonList list = new PersonList();
//        list.toString();

//        System.out.println("Average of everyone's ages is " + list.getAverageOfAges());
//
        Predicate<Person> femaleOver18 = p -> p.getSex() == 'F' && p.getAge() > 18;
//        PersonList filteredList = new PersonList(list.getPersonsByCondition(femaleOver18));
//        System.out.println("Displaying everyone: ");
//        list.toString();
//        System.out.println("Displaying only women older than 18: ");
//        filteredList.toString();
        System.out.println("Displaying average age of women older than 18: " + list.getAverageOfAges(femaleOver18));
    }
}
