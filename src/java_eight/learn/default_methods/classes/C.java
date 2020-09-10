package java_eight.learn.default_methods.classes;

import java_eight.learn.default_methods.interfaces.A;
import java_eight.learn.default_methods.interfaces.B;

public class C extends D implements B, A {

    public static void main(String[] args) {
        new C().hello();
    }
}
