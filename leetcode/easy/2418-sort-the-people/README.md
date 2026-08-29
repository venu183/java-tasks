# Sort the People

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an array of strings `names`, and an array `heights` that consists of  **distinct**  positive integers. Both arrays are of length `n`.

For each index `i`, `names[i]` and `heights[i]` denote the name and height of the `ith` person.

Return `names` *sorted in  **descending**  order by the people's heights*.

 

 **Example 1:** 

```
Input: names = ["Mary","John","Emma"], heights = [180,165,170]
Output: ["Mary","Emma","John"]
Explanation: Mary is the tallest, followed by Emma and John.

```

 **Example 2:** 

```
Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
Output: ["Bob","Alice","Bob"]
Explanation: The first Bob is the tallest, followed by Alice and the second Bob.

```

 

 **Constraints:** 

- n == names.length == heights.length
- 1 <= n <= 103
- 1 <= names[i].length <= 20
- 1 <= heights[i] <= 105
- names[i] consists of lower and upper case English letters.
- All the values of heights are distinct.

## Solution

**Language:** Java  
**Runtime:** 10 ms (beats 60.19%)  
**Memory:** 46.8 MB (beats 97.08%)  
**Submitted:** 2026-08-29T05:25:24.650Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/sort-the-people/)