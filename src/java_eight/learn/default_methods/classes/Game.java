package java_eight.learn.default_methods.classes;

import java_eight.learn.default_methods.interfaces.Resizable;

import java.util.Arrays;
import java.util.List;

public class Game {

    public static void main(String[] args) {
        List<Resizable> resizableShapes = Arrays.asList(new Ellipse());

        Utils.paint(resizableShapes);
    }
}
