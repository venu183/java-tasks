# String Similarity

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

For two strings A and B, we define the similarity of the strings to be the length of the longest prefix common to both strings. For example, the similarity of strings "abc" and "abd" is 2, while the similarity of strings "aaa" and "aaab" is 3.

Calculate the sum of similarities of a string S with each of it's suffixes.


**Input Format**

The first line contains the number of test cases *t*.  
Each of the next *t* lines contains a string to process, $s$.


**Constraints**

- $1 \le t \le 10$    
- $1 \le |s| \le 100000$  
- $s$ is composed of characters in the range ascii[a-z]  


**Output Format**

Output *t* lines, each containing the answer for the corresponding test case.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-10T06:00:24.103Z  

```java

            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }

            sum += z[i];
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            System.out.println(stringSimilarity(s));
        }
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/string-similarity/problem)