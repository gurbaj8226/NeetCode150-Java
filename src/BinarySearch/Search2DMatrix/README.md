# Search a 2D Matrix

**Category:** Arrays / Binary Search (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(log(m × n))  
**Space Complexity:** O(1)

## Problem Description
You are given an `m × n` matrix where:

* Each row is sorted left to right.  
* The first element of each row is greater than the last element of the previous row.

Given a `target`, determine if it exists in the matrix.

## Approach
* Treat the entire 2D matrix as a **single sorted 1D array**.  
* Use **binary search** on the range `[0 … m*n - 1]`.  
* Convert mid index back into row/col using:
  * `row = mid / n`
  * `col = mid % n`
* Compare and move search boundaries normally.

## Example
**Input:**  
matrix =  
[  
  [1, 3, 5, 7],  
  [10, 11, 16, 20],  
  [23, 30, 34, 50]  
]  
target = 3

**Output:**  
`true`

## Java Code
```java

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int left = 0;
        int right = r * c -1;

        while(left <= right){
            int mid = (left + right)/2;

            int rows = mid / c;
            int cols = mid % c;

            if(target > matrix[rows][cols]){
                left = mid + 1;
            }
            else if(target < matrix[rows][cols]){
                right = mid - 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
