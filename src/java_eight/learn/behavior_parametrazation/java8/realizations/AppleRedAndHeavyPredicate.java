package java_eight.learn.behavior_parametrazation.java8.realizations;

import java_eight.Apple;
import java_eight.learn.behavior_parametrazation.java8.functional_interfaces.ApplePredicate;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.weight > 150 && apple.getColor().equals("red");
    }
}
