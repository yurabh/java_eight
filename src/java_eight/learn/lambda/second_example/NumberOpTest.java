package java_eight.learn.lambda.second_example;

public class NumberOpTest {

    public static void isOdd(int number) {
        if (number < 0 && number % 2 != 0) {
            System.out.println("number: " + number + " is positive and odd");
        }
    }

    public static void isEven(int number) {
        if (number > 0 && number % 2 == 0) {
            System.out.println("number: " + number + " is negative even");
        }
    }

    public static void numberCheck(NumberTest numberTest, int number) {
        numberTest.checkValue(number);
    }

    public static void main(String[] args) {

        NumberOpTest.isOdd(-5);

        NumberOpTest.isEven(6);

        NumberTest odd = (number) -> {
            if (number < 0 && number % 2 != 0) {
                System.out.println("number: " + number + " is positive and odd");
            }
        };

        NumberTest even = (number) -> {
            if (number > 0 && number % 2 == 0) {
                System.out.println("number: " + number + " is negative even");
            }
        };

        odd.checkValue(-5);

        even.checkValue(6);

        numberCheck((number) -> {
            if (number < 0 && number % 2 != 0)
                System.out.println("number: " + number + " is negative and odd");
        }, -5);

        numberCheck((number) -> {
            if (number > 0 && number % 2 == 0)
                System.out.println("number: " + number + " is positive and even");
        }, 10);
    }
}
