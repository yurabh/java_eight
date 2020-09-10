package java_eight.learn.optional;

import java.util.Optional;

public class TestOptional {

    public static void main(String[] args) {

        Optional<Car> optionalCar = Optional.empty();

        Car car = new Car();

        Optional<Car> optionalCarTwo = Optional.of(car);

        Optional<Car> optionalCarThree = Optional.ofNullable(car);

        Incuruanse incuruanse = new Incuruanse();

        Optional<Incuruanse> optInsurance = Optional.ofNullable(incuruanse);

        Optional<String> name = optInsurance.map(Incuruanse::getName);

        Person person = new Person();

        Optional<Person> optPerson = Optional.of(person);
        Optional<String> name1 =
                optPerson.flatMap(Person::getCarAsOptional)
                        .flatMap(Car::getInsurance)
                        .map(Incuruanse::getName);
    }
}
