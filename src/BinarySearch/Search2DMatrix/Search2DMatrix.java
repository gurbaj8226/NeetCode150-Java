package BinarySearch.Search2DMatrix;

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
