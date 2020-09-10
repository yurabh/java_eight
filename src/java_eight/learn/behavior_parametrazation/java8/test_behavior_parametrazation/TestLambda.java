package java_eight.learn.behavior_parametrazation.java8.test_behavior_parametrazation;

import java_eight.Apple;
import java_eight.learn.lambda.functional_interface.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestLambda {

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {

        List<T> result = new ArrayList<>();
        for (T a : list) {
            if (predicate.test(a)) {
                result.add(a);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(new Apple("red"), new Apple("green"), new Apple("red1"),
                new Apple("red2"), new Apple("green"));

        List<Apple> redApples = filter(apples, (Apple apple) -> "red".equals(apple.getColor()));

        System.out.println(redApples.toString());


        List<Integer> integers = Arrays.asList(new Integer(1), new Integer(2), new Integer(3),
                new Integer(4), new Integer(5), new Integer(6));

        List<Integer> evenNumbers = filter(integers, (Integer i) -> i % 2 == 0);

        System.out.println(evenNumbers.toString());
    }
}
