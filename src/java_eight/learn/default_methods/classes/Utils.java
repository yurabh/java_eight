package java_eight.learn.default_methods.classes;

import java_eight.learn.default_methods.interfaces.Resizable;

import java.util.List;

public class Utils {

    public static void paint(List<Resizable> l) {
        l.forEach(r -> {
            r.setAbsoluteSize(1, 2);
        });
    }
}
