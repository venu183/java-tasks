# Two Strings

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two strings, determine if they share a common substring.  A substring may be as small as one character.  

**Example**   
$s1 = \text{'and'}$  
$s2 = \text{'art'}$  

These share the common substring $a$.  

$s1 = \text{'be'}$  
$s2 = \text{'cat'}$  

These do not share a substring.  

**Function Description**

Complete the function *twoStrings* in the editor below.    

twoStrings has the following parameter(s):  

- *string s1:*  a string
- *string s2:*  another string    

**Returns**  

- *string:* either `YES` or `NO`

**Input Format**

The first line contains a single integer $p$, the number of test cases.		

The following $p$ pairs of lines are as follows:

- The first line contains string $s1$.
- The second line contains string $s2$.

**Constraints**

- $s1$ and $s2$ consist of characters in the range ascii[a-z].
- $1 \le p \le 10$
- $1 \le |s1|, |s2| \le 10^5$

**Output Format**

For each pair of strings, return `YES` or `NO`.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-10T06:12:22.239Z  

```cpp
        }

        // Check characters of s2
        for (char c : s2.toCharArray()) {
            if (present[c - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(br.readLine().trim());

        while (q-- > 0) {
            String s1 = br.readLine().trim();
            String s2 = br.readLine().trim();

            System.out.println(twoStrings(s1, s2));
        }
    }
}
```

---

[View on HackerRank](https://www.hackerrank.com/challenges/two-strings/problem)