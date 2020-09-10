package java_eight.learn.optional;

import java.util.Optional;

public class Person {
    private Car car;

    public Optional<Car> getCarAsOptional() {
        return Optional.ofNullable(car);
    }
}
