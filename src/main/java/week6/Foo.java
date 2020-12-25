package week6;

public class Foo {
    public A foo() {
        return new A();
    }
}
class Bar extends Foo {
    @Override
    public B foo() {
        return new B();
    }
}

class A {}
class B extends A {}