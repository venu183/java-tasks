import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Integer[] indices = new Integer[names.length];

        // Store indices
        for (int i = 0; i < names.length; i++) {
            indices[i] = i;
        }

        // Sort indices based on heights in descending order
        Arrays.sort(indices, (a, b) -> Integer.compare(heights[b], heights[a]));

        // Create result
        String[] result = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            result[i] = names[indices[i]];
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna