package week5;

public class Person {
    public String name = "Jone Doe";
    public int age = 1;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person() {

    }

    public static void main(String... args){
        Person person1 = new Person();
        Person person2 = new Person("Seul", 26);
        String name1 = person1.name;
        String name2= person2.name;
        int age1 = person1.age;
        int age2 = person2.age;

        System.out.println(name1 + " : " + age1);
        System.out.println(name2 + " : " + age2);
    }
}
