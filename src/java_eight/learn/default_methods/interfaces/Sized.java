package java_eight.learn.default_methods.interfaces;

public interface Sized {
    int size();

    default boolean isEmpty() {
        return size() == 0;
    }
}
