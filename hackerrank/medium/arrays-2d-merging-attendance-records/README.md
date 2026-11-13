# Array 2D - Merging Attendance Records

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a school, teachers maintain attendance records for each class using matrices. Each row of the matrix represents a different class, while each column represents a different day. The value in each cell indicates the number of students present on that day. Occasionally, the school administration needs to combine attendance records from two different weeks to get an overall view of student attendance.

You have been tasked to create a program that reads two attendance matrices, each representing the attendance records for a different week, and then adds them together to create a final matrix representing the total attendance for those two weeks.

 **Problem Statement** 

Write a program that takes two matrices of the same dimensions (number of classes and days) as input and computes the element-wise sum of these matrices. The output should reflect the total number of students present for each class on each day over the two weeks.

 **Input Format** 

- The first line contains two integers, classes and days, representing the dimensions of the matrices.
- The next classes lines contain space-separated integers representing the attendance records for the first week.
- The following classes lines contain space-separated integers representing the attendance records for the second week.

 **Constraints** 

- Both matrices will have the same dimensions (i.e., both matrices are classes x days).
- All integers are non-negative.

 **Output Format** 

Print the resulting attendance matrix with each row on a new line, where each element in a row is separated by a space.

 **Sample Input 0** 

```
2 3
1 2 3
4 5 6
7 8 9
1 1 1

```

 **Sample Output 0** 

```
8 10 12 
5 6 7 

```

 **Explanation 0** 

In the sample input, the first matrix represents attendance records for the first week and the second matrix represents records for the second week. The program sums the attendance for each class on each day, resulting in a new matrix that shows the combined attendance over the two weeks.

 **Sample Input 1** 

```
3 2
1 2
3 4
5 6
7 8
9 10
11 12

```

 **Sample Output 1** 

```
8 10 
12 14 
16 18 

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-13T06:57:01.250Z  

```java
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int a[][] = new int[r][c];
        int b[][] = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                b[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print((a[i][j] + b[i][j]) + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/arrays-2d-merging-attendance-records/problem)