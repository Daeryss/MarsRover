import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("hello ");
        strings.add(null);
        strings.add("world");
        strings.forEach(System.out::println);
    }
}
