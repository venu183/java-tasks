import java.util.*;

class Student {}
class Rockstar {}
class Hacker {}

public class Solution {

    public static int count(ArrayList<Object> list, Class<?> type) {
        int count = 0;

        for (Object obj : list) {
            if (obj instanceof Student && type == Student.class)
                count++;
            else if (obj instanceof Rockstar && type == Rockstar.class)
                count++;
            else if (obj instanceof Hacker && type == Hacker.class)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Object> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();

            if (name.equals("Student"))
                list.add(new Student());
            else if (name.equals("Rockstar"))
                list.add(new Rockstar());
            else if (name.equals("Hacker"))
                list.add(new Hacker());
        }

        System.out.println(
            count(list, Student.class) + " " +
            count(list, Rockstar.class) + " " +
            count(list, Hacker.class)
        );

        sc.close();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna