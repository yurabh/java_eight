package java_eight.learn.lambda.second_example;

public class StringOpTest {

    public static String makeChange(StringOperation stringOperation, String text) {
        return stringOperation.change(text);
    }

    public static void main(String[] args) {

        String text = "Toward the end of the year 1920 the Government of the United States had\n" +
                "practically completed the programme, adopted during the last months of\n" +
                "President Winthrop's administration.";

        System.out.println(text);

        String res = makeChange(
                (line) -> {
                    return line.replaceAll("\\p{Punct}", "");
                }, text);
        System.out.println(res);
    }
}
