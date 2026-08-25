import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int unique = 0;
        int maxUnique = 0;

        // First window
        for (int i = 0; i < M; i++) {
            int value = arr[i];

            if (!map.containsKey(value)) {
                map.put(value, 1);
                unique++;
            } else {
                map.put(value, map.get(value) + 1);
            }
        }

        maxUnique = unique;

        // Slide the window
        for (int i = M; i < N; i++) {

            // Remove the element going out
            int outgoing = arr[i - M];

            int count = map.get(outgoing);

            if (count == 1) {
                map.remove(outgoing);
                unique--;
            } else {
                map.put(outgoing, count - 1);
            }

            // Add the new element
            int incoming = arr[i];

            if (!map.containsKey(incoming)) {
                map.put(incoming, 1);
                unique++;
            } else {
                map.put(incoming, map.get(incoming) + 1);
            }

            maxUnique = Math.max(maxUnique, unique);
        }

        System.out.println(maxUnique);
    }
}
