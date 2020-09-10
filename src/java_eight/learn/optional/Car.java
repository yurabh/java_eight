package java_eight.learn.optional;

import java.util.Optional;

public class Car {

    private Incuruanse insurance;

    public Optional<Incuruanse> getInsurance() {
        return Optional.ofNullable(insurance);
    }
}
