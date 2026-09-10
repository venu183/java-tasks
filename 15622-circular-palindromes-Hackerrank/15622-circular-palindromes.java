```java
import java.io.*;
import java.util.*;

public class Solution {

    // Manacher's algorithm on the transformed string.
    static int[] palindrome(char[] s) {
        int n = s.length;
        int[] r = new int[2 * n];

        int k = 0;

        for (int i = 0, j = 0; i < 2 * n; i += k, j = Math.max(j - k, 0)) {

            while (i - j >= 0 &&
                   i + j + 1 < 2 * n &&
                   s[(i - j) / 2] == s[(i + j + 1) / 2]) {
                j++;
            }

            r[i] = j;

            for (k = 1;
                 i - k >= 0 &&
                 r[i] - k >= 0 &&
                 r[i - k] != r[i] - k;
                 k++) {

                r[i + k] = Math.min(r[i - k], r[i] - k);
            }
        }

        return r;
    }

    // Maximum heap with index mapping.
    static class MaxHeap {

        int[] heap;
        int[] map;
        int[] position;
        int size;

        MaxHeap(int n) {
            heap = new int[n + 5];
            map = new int[n + 5];
            position = new int[n + 5];

            Arrays.fill(map, -1);
            Arrays.fill(position, -1);
        }

        void add(int index, int value) {
            if (position[index] != -1) {
                return;
            }

            size++;
            heap[size] = value;
            map[size] = index;
            position[index] = size;

            up(size);
        }

        void remove(int index) {
            int p = position[index];

            if (p == -1) {
                return;
            }

            int last = size--;

            if (p != last) {
                heap[p] = heap[last];
                map[p] = map[last];
                position[map[p]] = p;

                up(p);
                down(p);
            }

            position[index] = -1;
        }

        int max() {
            if (size == 0) {
                return Integer.MIN_VALUE;
            }

            return heap[1];
        }

        int size() {
            return size;
        }

        void up(int p) {
            while (p > 1) {
                int parent = p >> 1;

                if (heap[parent] >= heap[p]) {
                    break;
                }

                swap(parent, p);
                p = parent;
            }
        }

        void down(int p) {
            while ((p << 1) <= size) {

                int child = p << 1;

                if (child + 1 <= size &&
                    heap[child + 1] > heap[child]) {
                    child++;
                }

                if (heap[p] >= heap[child]) {
                    break;
                }

                swap(p, child);
                p = child;
            }
        }

        void swap(int a, int b) {
            int temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;

            int t = map[a];
            map[a] = map[b];
            map[b] = t;

            position[map[a]] = a;
            position[map[b]] = b;
        }
    }

    static int n;

    static void solve(String str) {

        n = str.length();

        char[] s = new char[2 * n];

        for (int i = 0; i < n; i++) {
            s[i] = str.charAt(i);
            s[i + n] = str.charAt(i);
        }

        /*
         * There are 2*n positions in the transformed representation.
         */
        int[] pal = palindrome(s);

        /*
         * Events used to activate/deactivate palindromes.
         */
        long[] events = new long[16 * n];

        int eventCount = 0;

        for (int i = 0; i < 4 * n; i += 2) {

            pal[i] = Math.min(
                    pal[i],
                    n - ((n & 1) ^ 1)
            );

            events[eventCount++] =
                    ((long) (i / 2) << 32) | (i & 0xffffffffL);

            events[eventCount++] =
                    ((long) (i / 2 + pal[i] / 2) << 32)
                    | (i & 0xffffffffL);

            events[eventCount++] =
                    ((long) (i / 2 + n - pal[i] / 2 - 1) << 32)
                    | (i & 0xffffffffL);

            events[eventCount++] =
                    ((long) (i / 2 + n) << 32)
                    | (i & 0xffffffffL);
        }

        for (int i = 1; i < 4 * n; i += 2) {

            pal[i] = Math.min(
                    pal[i],
                    n - (n & 1)
            );

            events[eventCount++] =
                    ((long) (i / 2) << 32)
                    | (i & 0xffffffffL);

            events[eventCount++] =
                    ((long) (i / 2 + pal[i] / 2) << 32)
                    | (i & 0xffffffffL);

            events[eventCount++] =
                    ((long) (i / 2 + n - pal[i] / 2) << 32)
                    | (i & 0xffffffffL);

            events[eventCount++] =
                    ((long) (i / 2 + n) << 32)
                    | (i & 0xffffffffL);
        }

        Arrays.sort(events, 0, eventCount);

        MaxHeap increasing = new MaxHeap(4 * n + 5);
        MaxHeap decreasing = new MaxHeap(4 * n + 5);
        MaxHeap flat = new MaxHeap(4 * n + 5);

        int[] state = new int[4 * n];

        int q = 0;

        StringBuilder output = new StringBuilder();

        /*
         * Process every possible rotation.
         */
        for (int i = 0; i < 2 * n - 1; i++) {

            while (q < eventCount &&
                   (events[q] >>> 32) <= i) {

                int index = (int) events[q];

                if (state[index] == 0) {

                    increasing.add(
                            index,
                            (pal[index] & 1) - 2 * i
                    );

                } else if (state[index] == 1) {

                    increasing.remove(index);

                    flat.add(
                            index,
                            pal[index]
                    );

                } else if (state[index] == 2) {

                    flat.remove(index);

                    decreasing.add(
                            index,
                            pal[index] + 2 * i
                    );

                } else if (state[index] == 3) {

                    decreasing.remove(index);
                }

                state[index]++;
                q++;
            }

            if (i >= n - 1) {

                int answer = 0;

                if (increasing.size() > 0) {
                    answer = Math.max(
                            answer,
                            increasing.max() + 2 * i
                    );
                }

                if (decreasing.size() > 0) {
                    answer = Math.max(
                            answer,
                            decreasing.max() - 2 * i
                    );
                }

                if (flat.size() > 0) {
                    answer = Math.max(
                            answer,
                            flat.max()
                    );
                }

                output.append(answer).append('\n');
            }
        }

        System.out.print(output);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in)
                );

        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        solve(s);
    }
}
```


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna