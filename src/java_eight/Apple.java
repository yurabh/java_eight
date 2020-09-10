package java_eight;

public class Apple {

    public String color;

    public Double weight;

    public Apple() {
    }

    public Apple(String color) {
        this.color = color;
    }

    public Apple(Double weight) {
        this.weight = weight;
    }

    public Apple(String color, Double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                '}';
    }
}
