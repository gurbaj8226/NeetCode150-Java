package BinarySearch.KokoEatingBananas;

import java.util.Arrays;

public class KokoEatingBananas {
	 public int minEatingSpeed(int[] piles, int h) {
	        int left = 1;
	        int right = Arrays.stream(piles).max().getAsInt();
	        int result = 0;

	        while(left <= right){
	            int k = (left + right)/2;

	            long totalTime = 0;
	            for(int p: piles){
	                totalTime += Math.ceil((double)p / k);
	            }

	            if(totalTime <= h){
	                result = k;
	                right = k - 1;
	            }
	            else{
	                left = k + 1;
	            }
	        }
	        return result;
	    }
}
