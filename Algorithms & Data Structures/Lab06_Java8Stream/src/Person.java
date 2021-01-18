public class Person {
    private final String name;
    private final char sex;
    private int age;
    private final String nationality;

    public Person(String name, char sex, int age, String nationality) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Name : " + name + ", Sex : " + sex + ", Age : " + age + ", Nationality : " + nationality;
    }
}
