package java_eight.learn.lambda.first_example.test_lambda;

import java_eight.Apple;
import java_eight.learn.lambda.first_example.functional_interface.BufferedReaderProcessor;
import java_eight.learn.lambda.first_example.functional_interface.TriFunction;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;

public class TestLambda {

    Comparator<Apple> byWeight = new Comparator<Apple>() {
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    };


    public static void runnable(Runnable runnable) {
        runnable.run();
    }


    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }


    public static String processFileWithoutLambda() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
            return bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
            return bufferedReaderProcessor.process(bufferedReader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static <T> void foreach(List<T> list, Consumer<T> consumer) {
        for (T l : list) {
            consumer.accept(l);
        }
    }


    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> newList = new ArrayList<>();
        for (T lis : list) {
            newList.add(function.apply(lis));
        }
        return newList;
    }


    public static List<Apple> mapOther(List<Double> list, Function<Double, Apple> function) {
        List<Apple> newList = new ArrayList<>();
        for (Double a : list) {
            newList.add(function.apply(a));
        }
        return newList;
    }


    public static void main(String[] args) {

        Apple apple = new Apple(10.0);

        Apple apple2 = new Apple(10.0);


        Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        System.out.println(byWeight);


        Runnable runnableAnonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World -> Anonymous");
            }
        };

        runnableAnonymous.run();

        Runnable runnable = () -> System.out.println("Runnable lambda");

        runnable.run();


        runnable(() -> System.out.println("Runnable lambda"));


        Callable callableAnonymous = new Callable() {
            @Override
            public Object call() throws Exception {
                return "Callable Anonymous";
            }
        };

        try {
            System.out.println(callableAnonymous.call());
        } catch (Exception e) {
            e.printStackTrace();
        }


        Callable callable = () -> new Apple(12.0);

        try {
            Object call = callable.call();
            System.out.println(call);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Callable<Integer> c = () -> 42;

        try {
            Integer call = c.call();
            System.out.println(call);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Apple appleNewOne = new Apple(10.30);

        Predicate<Apple> predicate = (Apple apple1) -> appleNewOne.getWeight() > 140;

        System.out.println("boolean : " + predicate.test(appleNewOne));


        String result = processFileWithoutLambda();


        try {
            String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<String> list = Arrays.asList("kola", "ola", "kata", "", "zara");

        List<String> greenApples = filter(list, (String a) -> "green".equals("yura"));

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();

        List<String> nonEmpty = filter(list, nonEmptyStringPredicate);

        for (String listNew : nonEmpty) {
            System.out.println(listNew);
        }

        List<Integer> listInteger = Arrays.asList(1, 2, 3, 4);

        foreach(listInteger, (Integer a) -> System.out.println(a + a));

        IntPredicate intPredicate = (int i) -> i % 2 == 0;

        System.out.println(intPredicate.test(1000));

        Predicate<Integer> integerPredicate = (Integer i) -> i % 2 == 1;

        System.out.println(integerPredicate.test(1000));


        List<Object> map = map(Arrays.asList(1, 2, 3), (Integer i) -> i + i);

        System.out.println(map.toString());


        Function<String, Integer> stringToInteger = (String s3) -> Integer.parseInt(s3);


        List<String> str = Arrays.asList("a", "b", "A", "B");

        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

        str.sort(String::compareToIgnoreCase);


        Supplier<Apple> supplierNew = () -> new Apple();

        Apple appleLambda = supplierNew.get();

        Supplier<Apple> supplier = Apple::new;

        Apple appleReference = supplier.get();

        System.out.println(appleReference);


        Function<Double, Apple> apple5 = Apple::new;

        Apple apply = apple5.apply(30.1);

        Function<Double, Apple> apple6 = (weight) -> new Apple(weight);

        Apple apply1 = apple6.apply(100.0);


        BiPredicate<List<String>, String> contains = (array, element) -> str.contains(element);

        BiPredicate<List<String>, String> containsOne = List::contains;


        List<Double> weights = Arrays.asList(30.1, 22.0, 99.0);


        List<Apple> apples = mapOther(weights, Apple::new);


        TriFunction<Integer, Integer, Integer, Color> triFunction = Color::new;

        Comparator<Apple> color = Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor);
    }
}
