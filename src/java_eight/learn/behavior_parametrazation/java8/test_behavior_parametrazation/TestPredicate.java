package java_eight.learn.behavior_parametrazation.java8.test_behavior_parametrazation;

import java_eight.Apple;
import java_eight.learn.behavior_parametrazation.java8.functional_interfaces.ApplePredicate;
import java_eight.learn.behavior_parametrazation.java8.realizations.AppleRedAndHeavyPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPredicate {

    public static List<Apple> filtersApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> apples = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                apples.add(apple);
            }
        }
        return apples;
    }

    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(new Apple("red", 1222.0),
                new Apple("green", 123.0), new Apple("red1", 12.0),
                new Apple("red2", 15.0),
                new Apple("green", 19.0));

        List<Apple> redAndHeavyApples = filtersApples(apples, new AppleRedAndHeavyPredicate());

        System.out.println(redAndHeavyApples.toString());


        List<Apple> filteredApples = filtersApples(apples, new AppleRedAndHeavyPredicate() {
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });

        System.out.println(filteredApples.toString());

        List<Apple> result = filtersApples(apples, (Apple apple) -> "red".equals(apple.getColor()));

        System.out.println(result.toString());
    }
}
