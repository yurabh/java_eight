package java_eight.learn.behavior_parametrazation.java8.functional_interfaces;

import java_eight.Apple;

@FunctionalInterface
public interface ApplePredicate {
    boolean test(Apple apple);
}
