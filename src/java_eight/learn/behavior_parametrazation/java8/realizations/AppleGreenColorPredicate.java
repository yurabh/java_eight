package java_eight.learn.behavior_parametrazation.java8.realizations;

import java_eight.Apple;
import java_eight.learn.behavior_parametrazation.java8.functional_interfaces.ApplePredicate;

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
