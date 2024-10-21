package my.homework;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ivan", "Carevich", 35);
        System.out.println(person);

        Repository.save(person);
        System.out.println("\nDeserialize:");
        System.out.println((Person)Repository.read("my.homework.Person"));

        Repository.<Person>saveToJson(person);
        System.out.println("\nDeserialize from json:");
        System.out.println((Person)Repository.readFromJson("my.homework.Person", "my.homework.Person"));

    }
}