package java_eight.learn.default_methods.interfaces;

public interface B extends A {
    default void hello() {
        System.out.println("Hello from B");
    }
}
