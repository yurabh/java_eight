package java_eight.learn.lambda.first_example.functional_interface;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
