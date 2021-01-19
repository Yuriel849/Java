import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonList {
    private List<Person> list = new ArrayList<Person>();

    public PersonList() {
        list.add(new Person("Anna Zauber", 'F', 20, "U.S.A."));
        list.add(new Person("Benjamin Yassem", 'M', 31, "Palau"));
        list.add(new Person("Christopher Xing", 'M', 22, "U.K."));
        list.add(new Person("Daniela Holt", 'F', 44, "Germany"));
        list.add(new Person("Elisabeth A. K. McDonnell", 'F', 15, "Ireland"));
    }

    public PersonList(List<Person> list) {
        this.list = new ArrayList<>(list);
    }

    @Override
    public String toString() {
        list.forEach(System.out::println);
        return "";
    }

    public int getAverageOfAges() {
        return list.stream()
                .peek(System.out::println)
                .map(Person::getAge)
                .peek(System.out::println)
                .reduce(0, Integer::sum)
                / list.size();
    }

    public List<Person> getPersonsByCondition(Predicate<Person> condition) {
        return list.stream()
                .peek(System.out::println)
                .filter(condition)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        PersonList list = new PersonList();
        list.toString();

        System.out.println("Average of everyone's ages is " + list.getAverageOfAges());

        Predicate<Person> femaleOver18 = p -> p.getSex() == 'F' && p.getAge() > 18;
        PersonList filteredList = new PersonList(list.getPersonsByCondition(femaleOver18));
        System.out.println("Displaying everyone: ");
        list.toString();
        System.out.println("Displaying only women older than 18: ");
        filteredList.toString();
    }
}
