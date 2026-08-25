import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();

            students.add(new Student(id, name, cgpa));
        }

        Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {

                // 1. CGPA: descending
                if (s1.getCgpa() < s2.getCgpa()) {
                    return 1;
                } else if (s1.getCgpa() > s2.getCgpa()) {
                    return -1;
                }

                // 2. Name: alphabetical order
                int nameCompare =
                    s1.getFname().compareTo(s2.getFname());

                if (nameCompare != 0) {
                    return nameCompare;
                }

                // 3. ID: ascending
                return Integer.compare(s1.getId(), s2.getId());
            }
        });

        for (Student s : students) {
            System.out.println(s.getFname());
        }

        sc.close();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna