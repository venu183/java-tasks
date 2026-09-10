import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] count = new int[26];

        // Frequency of characters in p
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int required = p.length();

        while (right < s.length()) {
            char c = s.charAt(right);

            if (count[c - 'a'] > 0) {
                required--;
            }

            count[c - 'a']--;
            right++;

            // Window size must equal p.length()
            if (right - left > p.length()) {
                char removed = s.charAt(left);

                count[removed - 'a']++;

                if (count[removed - 'a'] > 0) {
                    required++;
                }

                left++;
            }

            // Anagram found
            if (required == 0) {
                result.add(left);
            }
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna