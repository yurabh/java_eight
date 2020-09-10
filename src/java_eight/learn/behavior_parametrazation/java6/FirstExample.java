package java_eight.learn.behavior_parametrazation.java6;

import java_eight.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstExample {

    public static List<Apple> filteringGreenApple(List<Apple> inventory) {
        List<Apple> apples = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                apples.add(apple);
            }
        }
        return apples;
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("green"), new Apple("yellow"),
                new Apple("blue"), new Apple("red"), new Apple("black"));

        List<Apple> applesFiltered = filteringGreenApple(apples);
        for (Apple a : applesFiltered) {
            System.out.println(a.toString());
        }
    }
}
