# LAPIN - Rating 1159

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Lapindromes

 *Lapindrome*  is defined as a string which when split in the middle, gives two halves having the same characters and same frequency of each character. If there are odd number of characters in the string, we ignore the middle character and check for lapindrome. For example  ***gaga**  *is a lapindrome, since the two halves  ***ga***  and  ***ga**  *have the same characters with same frequency. Also,  ***abccab***,  ***rotor**  *and  ***xyzxy***  are a few examples of lapindromes. Note that  ***abbaab** * is NOT a lapindrome. The two halves contain the same characters but their frequencies do not match.
Your task is simple. Given a string, you need to tell if it is a lapindrome.

### Input:
First line of input contains a single integer  **T**, the number of test cases.
Each test is a single line containing a string  **S**  composed of only lowercase English alphabet.

### Output:
For each test case, output on a separate line: "YES" if the string is a lapindrome and "NO" if it is not.

### Constraints:
- 1 ≤ T ≤ 100
- 2 ≤ |S| ≤ 1000, where |S| denotes the length of S
### Sample 1:
Input
Output

```
6
gaga
abcde
rotor
xyzxy
abbaab
ababc
```

```
YES
NO
YES
YES
NO
NO
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-03T05:42:29.074Z  

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            int n = s.length();
            int mid = n / 2;

            int[] freq1 = new int[26];
            int[] freq2 = new int[26];

            // First half
            for (int i = 0; i < mid; i++) {
                freq1[s.charAt(i) - 'a']++;
            }

            // Second half
            // For odd length, skip the middle character
            int start = (n % 2 == 0) ? mid : mid + 1;

            for (int i = start; i < n; i++) {
                freq2[s.charAt(i) - 'a']++;
            }

            if (Arrays.equals(freq1, freq2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/LAPIN)