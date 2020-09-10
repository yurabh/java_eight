package java_eight.learn.lambda.functional_interface;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
