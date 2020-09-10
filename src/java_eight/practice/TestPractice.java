package java_eight.practice;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class TestPractice {

    public static void main(String[] args) {
        Man man = new Man("Yura", "bh", "ge", 12, 2,
                new Address("Ukraine", "Lviv", "Suxiv"));

        Man man1 = new Man("Andriy", "Valevskiy", "Dnipro", 26, 3,
                new Address("Ukraine", "Dnipro", "Gorodocjka"));

        List<Man> men = new LinkedList<>();
        men.add(man);
        men.add(man1);


        System.out.println("Mans");
        men.stream().forEach((Man man3) -> System.out.println(man3));

        System.out.println("Address of Mans");

        men.stream().forEach(m -> System.out.println(m.getAddress()));


        System.out.println("SELECT firstName, lastName, countOfChildren FROM Man WHERE age >= 20 ORDER BY firstName");

        class Person {

            private String firstName;
            private String lastName;
            private int childs;

            public Person(String firstName, String lastName, int childs) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.childs = childs;
            }

            public Person(Man man) {
                firstName = man.getFirstName();
                lastName = man.getSurname();
                childs = man.getCountChild();
            }

            @Override
            public String toString() {
                return "Person{" +
                        "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", childs=" + childs +
                        '}';
            }
        }

        men.stream()
                .filter(m -> m.getAge() > 20)
                .sorted(Comparator.comparing(Man::getFirstName))
                .map(Person::new)
                .forEach(System.out::println);


        System.out.println();

        List<Man> ukaraine = men.stream()
                .filter((Man man10) -> man10.getAge() > 25 &&
                        man10.getCountChild() == 3 && man10.getAddress().getCountry().equals("Ukraine"))
                .collect(toList());

        System.out.println("dsds");
        System.out.println(ukaraine.toString());


        System.out.println("SELECT count(*) FROM Man GROUP BY countOfChildren");

        Map<Integer, List<Man>> countOfCildren = men.stream()
                .collect(groupingBy(Man::getCountChild));


        System.out.println(
                "SELECT count(*) FROM Man GROUP BY countOfChildren, age");

        men
                .stream()
                .collect(Collectors.groupingBy(m ->
                                new AbstractMap.SimpleEntry<>(m.getCountChild(), m.getAge()),
                        Collectors.counting()))


                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 4)
                .forEach(e -> System.out.println("Count childs " + e.getKey().getKey() + " age = " +
                        e.getKey().getValue() + " count = " + e.getValue()));


    }
}
