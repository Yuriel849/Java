public class Person {
    private final String name;
    private final char sex;
    private int age;
    private final String nationality;

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

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
