package java_eight.learn.lambda.testFunctionalInterfaceWithLambdaWithStream;

import java_eight.Apple;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class TestFunctionalInterface {

    public static void main(String[] args) {

        Apple apple = new Apple();

        Apple apple1 = null;

        int[] array = new int[1];

        int result = 9;

        Calculatable calculatable = (v1, v2) -> {
            array[0] = 7;
            apple.setColor("blue");
//            apple1 = apple;
//            array[1] = 4;
            int sum = v1 + result + v2;
            return v1 + v2 + sum;
        };

        int sum = calculatable.sum(5, 8);
        System.out.println(sum);

        Function<String, Integer> function = Integer::parseInt;

        Integer count = function.apply("124343");

        System.out.println(count);

        Function<String, Integer> function1 = (String s) -> Integer.parseInt(s);

        Integer countTwo = function1.apply("10000301");

        System.out.println(countTwo);


        Consumer<String> stringConsumer = (str) -> System.out.println(str);

        cons(List.of("Hello", "Footboll"), stringConsumer);


        List<String> list = List.of("Hello", "World", "Run", "Gun");

        Consumer<String> consumer = (s) -> System.out.println(s);

        list.stream().forEach(consumer);

        list.stream().filter(s -> s.contains(String.valueOf('o'))).forEach(consumer);
    }


    public static void cons(List<String> list, Consumer<String> tConsumer) {
        for (String s : list) {
            tConsumer.accept(s);
        }
    }
}
