package java_eight.learn.behavior_parametrazation.java8.functional_interfaces;

@FunctionalInterface
public interface Comparator<T> {
    T compare(T o, T o1);
}
