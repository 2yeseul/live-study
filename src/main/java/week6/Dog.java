package week6;

public class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("bark");
    }
    public static void main(String... args) {
        Object obj = new Dog();
        if(obj instanceof Dog) {
            Dog dog = (Dog)obj;
            dog.sound();
        }
    }
}
