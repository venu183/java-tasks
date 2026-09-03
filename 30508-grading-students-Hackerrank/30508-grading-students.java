```java
import java.io.*;
import java.util.*;

public class Result {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>();

        for (int grade : grades) {
            if (grade >= 38) {
                int nextMultiple = ((grade / 5) + 1) * 5;

                if (nextMultiple - grade < 3) {
                    grade = nextMultiple;
                }
            }

            result.add(grade);
        }

        return result;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < gradesCount; i++) {
            grades.add(Integer.parseInt(bufferedReader.readLine().trim()));
        }

        List<Integer> result = Result.gradingStudents(grades);

        for (int grade : result) {
            System.out.println(grade);
        }

        bufferedReader.close();
    }
}
```


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna