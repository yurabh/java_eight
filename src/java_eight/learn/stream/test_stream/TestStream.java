package java_eight.learn.stream.test_stream;

import java_eight.learn.stream.beans.Dish;
import java_eight.learn.stream.beans.Trader;
import java_eight.learn.stream.beans.Transaction;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.*;

public class TestStream {

    public static void main(String[] args) {

        Dish dish = new Dish("Pasta", true, 1000, Dish.Type.FISH);
        Dish dishTwo = new Dish("Omlet", true, 12000, Dish.Type.MEAT);
        Dish dishSix = new Dish("Omlet", true, 3000, Dish.Type.OTHER);
        Dish dishTree = new Dish("Omlet", false, 800, Dish.Type.FISH);
        Dish dishFour = new Dish("hotDog", false, 1300, Dish.Type.MEAT);

        List<Dish> menu = new ArrayList<>();

        menu.add(dish);
        menu.add(dishSix);
        menu.add(dishTwo);
        menu.add(dishTree);
        menu.add(dishFour);

        List<Dish> lowerCaloricDishes = new ArrayList<>();

        for (Dish i : menu) {
            if (i.getCalories() < 1000) {
                lowerCaloricDishes.add(i);
            }
        }

        for (Dish i : lowerCaloricDishes) {
            System.out.println(i);
        }


        Collections.sort(lowerCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });


        List<String> lowCaloricDishesName = new ArrayList<>();

        for (Dish i : lowerCaloricDishes) {
            lowCaloricDishesName.add(i.getName());
        }


        for (String name : lowCaloricDishesName) {
            System.out.println(name);
        }


        List<String> lowCaloricDishNameTwo = menu.stream()
                .filter((d) -> d.getCalories() < 1000)
                .filter((d) -> d.getName().equals("Omlet"))
                .sorted(comparing(Dish::getCalories))
                .map((Dish name) -> name.getName())
                .collect(toList());


        lowCaloricDishNameTwo.stream()
                .forEach((String s) -> System.out.println(s));


        List<Dish> menuDish = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));


        List<String> treeHighCaloricDish = menuDish.stream()
                .filter((Dish d) -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());

        System.out.println(treeHighCaloricDish);

        List<String> title = Arrays.asList("java8", "in", "action");

        Stream<String> stream = title.stream();

        stream.forEach((d -> System.out.println(d)));


        List<String> menuDishes = menuDish
                .stream()
                .filter(d -> {
                    System.out.println(" maping : " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println(" maping : " + d.getName());
                    return d.getName();
                })
                .collect(toList());

        System.out.println(menuDishes);


        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4223);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach((Integer i) -> System.out.println(i));


        List<Dish> dishes = menuDish
                .stream()
                .filter(d -> d.getCalories() < 390)
                .limit(3)
                .collect(toList());

        System.out.println(dishes);


        List<Dish> dishesNew = menuDish
                .stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());

        System.out.println(dishesNew);


        List<String> dishNames = menuDish
                .stream()
                .map(Dish::getName)
                .collect(toList());


        System.out.println(dishNames);


        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");


        List<Integer> wordLengths = words
                .stream()
                .map((String l) -> l.length())
                .collect(toList());

        System.out.println(wordLengths);


        List<Integer> dishNameLengths = menu
                .stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());

        System.out.println(dishNameLengths);


        List<String[]> strings = words
                .stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());


        menuDish.
                stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));


        boolean isNonHealthy = menuDish
                .stream()
                .allMatch(d -> d.getCalories() < 10);

        System.out.println(isNonHealthy);


        boolean isHealthy = menu
                .stream()
                .noneMatch(d -> d.getCalories() <= 1000);

        System.out.println(isHealthy);


        Optional<Dish> anyDishes = menuDish
                .stream()
                .filter(Dish::isVegetarian)
                .findAny();

        anyDishes.ifPresent(d -> System.out.println(d));


        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> firstSquareDivisibleByThree = someNumbers
                .stream()
                .map(x -> x * x)
                .filter(x -> x % 3 == 0)
                .findFirst();

        System.out.println(firstSquareDivisibleByThree);


        int reduce = numbers.stream().reduce(0, (a, b) -> a + b);

        System.out.println(reduce);

        int multiply = numbers.stream().reduce(1, (a, b) -> a * b);

        System.out.println(multiply);

        int sumTwo = numbers.stream().reduce(0, Integer::sum);

        System.out.println(sumTwo);


        Optional<Integer> sumOptional = numbers.stream().reduce((a, b) -> (a + b));

        System.out.println(sumOptional);


        Optional<Integer> maxOptional = numbers.stream().reduce(Integer::max);

        System.out.println(maxOptional);

        int count = menu
                .stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);

        System.out.println(count);


        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 1300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        List<Transaction> transactionsNew = transactions
                .stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        System.out.println(transactionsNew);


        List<String> cities = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());

        System.out.println(cities);


        Set<String> citiesTwo = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());

        System.out.println(citiesTwo);


        List<Trader> traders = transactions
                .stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getName().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());

        System.out.println(traders);


        String traderString = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);


        System.out.println(traderString);


        String traderStr = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());


        boolean milanBased = transactions
                .stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);


        transactions
                .stream()
                .filter(tr -> "Cambridge".equals(tr.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);


        Optional<Integer> hightsLevelOfTransactions = transactions
                .stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        System.out.println(hightsLevelOfTransactions);


        Optional<Transaction> minValueTransaction = transactions
                .stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);


        Optional<Transaction> smallestTransaction = transactions
                .stream()
                .min(comparing(Transaction::getValue));

        System.out.println(smallestTransaction);

        int calories = menuDish
                .stream()
                .mapToInt(Dish::getCalories).sum();

        System.out.println(calories);


        IntStream intStream = menu
                .stream()
                .mapToInt(Dish::getCalories);

        Stream<Integer> streamboxed = intStream.boxed();

        OptionalInt maxCalories = menuDish
                .stream()
                .mapToInt(Dish::getCalories).max();

        System.out.println(maxCalories);

        int max = maxCalories.orElse(20);


        IntStream eventsNumber = IntStream
                .rangeClosed(1, 100)
                .filter(i -> i % 2 == 0);

        long countNumber = eventsNumber.count();

        System.out.println(countNumber);


        Stream<String> streamOf = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        streamOf.map(String::toUpperCase)
                .forEach(System.out::println);


        Stream<String> emptyStream = Stream.empty();

        System.out.println(emptyStream);


        int numbersTwo[] = {1, 2, 3, 4, 5, 6};

        int number = Arrays.stream(numbersTwo).sum();

        System.out.println(number);


        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);


        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));


        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);


        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(5).forEach(System.out::println);


        IntStream generate1 = IntStream.generate(new IntSupplier() {
            public int getAsInt() {
                return 2;
            }
        });

        System.out.println(generate1);

        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };

        IntStream.generate(fib)
                .limit(10)
                .forEach(System.out::println);


        Collector collector = null;

        Collectors collections = null;


        List<Transaction> transactions1 = transactions
                .stream()
                .collect(Collectors.toList());

        System.out.println(transactions1);

        long howManyDishes = menu
                .stream()
                .collect(Collectors.counting());

        System.out.println(howManyDishes);

        long howManyDishesTwo = menu
                .stream()
                .count();

        System.out.println(howManyDishesTwo);

        Comparator<Dish> dishCaloriesComparator = comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish = menu
                .stream()
                .collect(maxBy(dishCaloriesComparator));

        double totalCalories = menu
                .stream()
                .collect(summingInt(Dish::getCalories));

        double avgCalories = menu
                .stream()
                .collect(averagingInt(Dish::getCalories));

        IntSummaryStatistics menuStatistics = menu
                .stream()
                .collect(summarizingInt(Dish::getCalories));


        String shortMenu = menu
                .stream()
                .map(Dish::getName)
                .collect(joining());

        System.out.println(shortMenu);

        String shortMenuSecond = menu
                .stream()
                .map(Dish::getName)
                .collect(joining(", "));

        System.out.println(shortMenuSecond);


        int totalCalories2 = menu.stream()
                .collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(totalCalories2);


        Optional<Dish> mostCalorieDishes = menu.stream()
                .collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println(mostCalorieDishes);


        int totalReference = menu.stream()
                .collect(reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(totalReference);


        int totalCalories3 = menu.stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum).get();

        System.out.println(totalCalories3);


        Stream<Integer> streamNew = Arrays.asList(1, 2, 3, 4, 5, 6).stream();

        List<Integer> numbersNew = streamNew.reduce(
                new ArrayList<Integer>(),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
                    return l;
                },

                (List<Integer> l1, List<Integer> l2) -> {
                    l1.addAll(l2);
                    return l1;
                });

        System.out.println(numbersNew);


        int totalCalories4 = menu
                .stream()
                .mapToInt(Dish::getCalories).sum();

        System.out.println(totalCalories4);


        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));

        System.out.println(dishesByType);


        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dis -> {
                    if (dis.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dis.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));


        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesGroup = menu.stream().collect(
                groupingBy(Dish::getType, groupingBy(
                        dish1 -> {
                            if (dish1.getCalories() < 400) return CaloricLevel.NORMAL;
                            else if (dish1.getCalories() <= 700) return CaloricLevel.DIET;
                            else return CaloricLevel.FAT;
                        }

                )));


        Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));

        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));


        Map<Dish.Type, Dish> mostCaloryType = menu.stream().collect(groupingBy(Dish::getType,
                collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));


        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream().collect(groupingBy(Dish::getType,
                summingInt(Dish::getCalories)));

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream().collect(
                groupingBy(Dish::getType, mapping(
                        dish1 -> {
                            if (dish1.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish1.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        },
                        toSet())));


        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByTypeTwo = menu.stream().collect(
                groupingBy(Dish::getType, mapping(
                        dish2 -> {
                            if (dish2.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish2.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        },
                        toCollection(HashSet::new))));


        Map<Boolean, List<Dish>> menuSecond = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        List<Dish> vegetarianDishes = menuSecond.get(true);

        List<Dish> vegetarianDishes1 = menu.stream().filter(Dish::isVegetarian).collect(toList());

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegitarianDish = menu.stream().collect(partitioningBy(
                Dish::isVegetarian, groupingBy(Dish::getType)));

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream().collect(
                partitioningBy(Dish::isVegetarian,
                        collectingAndThen(
                                maxBy(comparingInt(Dish::getCalories)),
                                Optional::get)));
    }


    public boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
    }

    public enum CaloricLevel {
        DIET, NORMAL, FAT
    }
}
