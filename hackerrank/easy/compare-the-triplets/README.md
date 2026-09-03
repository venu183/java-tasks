# Compare the Triplets

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges, awarding points on a scale from <em>1</em> to <em>100</em> for three categories: <em>problem clarity</em>, <em>originality</em>, and <em>difficulty</em>. 
  
The rating for Alice's challenge is the triplet <em>a = (a[0], a[1], a[2])</em>, and the rating for Bob's challenge is the triplet <em>b = (b[0], b[1], b[2])</em>.
  
The task is to calculate their comparison points by comparing each category:    
   
<ul>
<li> If <em>a[i] > b[i]</em>, then Alice is awarded <em>1</em> point. </li>
<li> If <em>a[i] &lt; b[i]</em>, then Bob is awarded <em>1</em> point. </li>
<li> If <em>a[i] = b[i]</em>, then neither person receives a point.</li>
</ul>
 
  
<strong>Example</strong>   
  
<em>a = [1, 2, 3]</em>  
<em>b = [3, 2, 1]</em>  
<br/ >  
<ul>
<li>For elements *0*, Bob is awarded a point because <em>a[0] &lt; b[0]</em>. </li> 
<li>For the equal elements <em>a[1]</em> and <em>b[1]</em>, no points are earned. </li> 
<li>Finally, for elements <em>2</em>, <em>a[2] > b[2]</em> so Alice receives a point. </li> 
</ul>
  
The return array is <em>[1, 1]</em> with Alice's score first and Bob's second.  
  
<strong>Function Description</strong>  
  
Complete the function <em>compareTriplets</em> with the following parameter(s):  
  

- <em>int a[3]</em>: Alice's challenge rating  
- <em>int b[3]</em>: Bob's challenge rating   

  
<strong>Returns</strong>  
  
- <em>int[2]</em>: the first element is Alice's score and the second is Bob's score

**Input Format**

The first line contains <em>3</em> space-separated integers, <em>a[0]</em>, <em>a[1]</em>, and <em>a[2]</em>, the respective values in triplet <em>a</em>.		
The second line contains <em>3</em> space-separated integers, <em>b[0]</em>, <em>b[1]</em>, and <em>b[2]</em>, the respective values in triplet <em>b</em>.

**Constraints**

   
<ul>
<li> <em>1 &le; a[i] &le; 100</em></li>
<li> <em>1 &le; b[i] &le; 100</em></li>
</ul>

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-03T05:45:42.049Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alice = 0;
        int bob = 0;

        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                alice++;
            } else if (a.get(i) < b.get(i)) {
                bob++;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(alice);
        result.add(bob);

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] aInput = br.readLine().split(" ");
        String[] bInput = br.readLine().split(" ");

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            a.add(Integer.parseInt(aInput[i]));
            b.add(Integer.parseInt(bInput[i]));
        }

        List<Integer> result = compareTriplets(a, b);

        System.out.println(result.get(0) + " " + result.get(1));
    }
}


```

---

[View on HackerRank](https://www.hackerrank.com/challenges/compare-the-triplets/problem)