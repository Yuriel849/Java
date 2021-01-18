import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private final static List<Person> list = new ArrayList<Person>();

    public PersonList() {
        list.add(new Person("Anna Zauber", 'F', 20, "U.S.A."));
        list.add(new Person("Benjamin Yassem", 'M', 31, "Palau"));
        list.add(new Person("Christopher Xing", 'M', 22, "U.K."));
        list.add(new Person("Daniela Holt", 'F', 44, "Germany"));
        list.add(new Person("Elisabeth A. K. McDonnell", 'F', 15, "Ireland"));
    }

    @Override
    public String toString() {
        list.forEach(System.out::println);
        return "";
    }

    public static void main(String[] args) {
        PersonList list = new PersonList();
        list.toString();
    }
}
