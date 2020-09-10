package java_eight.learn.default_methods.interfaces;

public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}
