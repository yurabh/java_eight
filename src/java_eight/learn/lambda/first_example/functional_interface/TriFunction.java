package java_eight.learn.lambda.first_example.functional_interface;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
