import java.util.*;

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    @Override
    public int compareTo(Student other) {

        // 1. Higher CGPA first
        if (this.cgpa != other.cgpa) {
            return Double.compare(other.cgpa, this.cgpa);
        }

        // 2. Same CGPA -> name ascending
        int nameCompare = this.name.compareTo(other.name);

        if (nameCompare != 0) {
            return nameCompare;
        }

        // 3. Same name -> ID ascending
        return Integer.compare(this.id, other.id);
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> pq = new PriorityQueue<>();

        for (String event : events) {

            String[] parts = event.split(" ");

            if (parts[0].equals("ENTER")) {

                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);

                pq.add(new Student(id, name, cgpa));

            } else if (parts[0].equals("SERVED")) {

                if (!pq.isEmpty()) {
                    pq.poll();
                }
            }
        }

        List<Student> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna