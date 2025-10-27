package TwoPointer.ContainerWithMostWater;

public class ContainerWithMostWater {
	public static int maxArea(int[] heights) {
        int right = heights.length-1;
        int area = 0;
        int max = 0;
        int left = 0;
        while(left<right) {
        	area=(right-left)*Math.min(heights[left], heights[right]);
        	max = Math.max(max, area);
        	if(heights[left]<=heights[right]) {
        		left++;
        	}
        	else {
        		right--;
        	}
        }
        return max;
    }
}
