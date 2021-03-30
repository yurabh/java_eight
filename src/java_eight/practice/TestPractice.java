package java_eight.practice;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

class Person {
    private String firstName;
    private String lastName;
    private int children;

    public Person(Man man) {
        firstName = man.getFirstName();
        lastName = man.getSurname();
        children = man.getCountChild();
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", children=" + children +
                '}';
    }
}

public class TestPractice {

    public static void main(String[] args) {
        Man man = new Man("Yura", "bh", "Uk", 33, 2,
                new Address("Ukraine", "Lviv", "Suchiv"));

        Man manOne = new Man("Andriy", "Valevskiy", "Dnipro", 26, 3,
                new Address("Canada", "Dnipro", "Gorodocjka"));

        List<Man> men = new LinkedList<>();
        men.add(man);
        men.add(manOne);

        men.forEach(System.out::println);
        men.forEach(m -> System.out.println(m.getAddress()));

        men.stream()
                .sorted(Comparator.comparing(Man::getFirstName))
                .filter(m -> m.getAge() > 20)
                .map(Person::new)
                .forEach(System.out::println);


        final List<Man> canada = men.stream()
                .sorted(Comparator.comparing(Man::getFirstName))
                .filter(m -> m.getAddress().getCountry().equals("Canada") &&
                        m.getAddress().getStreet().equals("3")
                        || m.getAge() > 25).collect(Collectors.toList());
        System.out.println(canada);


        System.out.println("SELECT count(*) FROM Man GROUP BY countOfChildren");
        Map<Integer, List<Man>> countOfChildren =
                men.stream()
                        .collect(groupingBy(Man::getCountChild));
        System.out.println(countOfChildren);


        System.out.println("SELECT count(*) FROM Man GROUP BY countOfChildren, age");
        final Map<AbstractMap.SimpleEntry<Integer, Integer>, Long> collect = men
                .stream()
                .collect(Collectors.groupingBy(m ->
                        new AbstractMap.SimpleEntry<>(m.getCountChild(),
                                m.getAge()), Collectors.counting()));

        System.out.println(collect);


        final Map<AbstractMap.SimpleEntry<String, String>, Long> collectOne = men.
                stream()
                .collect(Collectors.groupingBy(m ->
                        new AbstractMap.SimpleEntry<>(m.getAddress().getCity(),
                                m.getAddress().getStreet()), Collectors.counting()));

        System.out.println(collectOne);

        collectOne
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 4)
                .forEach(System.out::println);


        System.out.println("UPDATE Man SET firstName = 'John', lastName = 'Kenedi'," +
                " countOfChildren = 3 WHERE country == 'US' (or another country)");

        men.forEach(m -> {
            m.setFirstName("John");
            m.getAddress().setCountry("US");
            m.setName("Kenedi");
            m.setCountChild(3);
        });

        men.forEach(System.out::println);
    }
}
