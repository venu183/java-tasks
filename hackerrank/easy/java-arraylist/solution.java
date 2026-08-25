import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of lines
        int n = sc.nextInt();

        // ArrayList containing ArrayLists
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        // Read all lines
        for (int i = 0; i < n; i++) {

            int d = sc.nextInt();

            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j < d; j++) {
                list.add(sc.nextInt());
            }

            arr.add(list);
        }

        // Number of queries
        int q = sc.nextInt();

        // Process queries
        for (int i = 0; i < q; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            // x and y are 1-based
            if (x >= 1 && x <= arr.size()
                    && y >= 1 && y <= arr.get(x - 1).size()) {

                System.out.println(arr.get(x - 1).get(y - 1));

            } else {
                System.out.println("ERROR!");
            }
        }

        sc.close();
    }
}
