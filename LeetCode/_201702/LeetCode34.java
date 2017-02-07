package edu.ustc.shshen.LeetCode._201702;


public class LeetCode34 {
	
	public static void main(String[] args) {
		int test[] = {5,7,7,8,8,10};
		System.out.println(searchRange(test, 8)[0]);
	}
	
	public static int[] searchRange(int[] nums, int target) {
		int result[] = {-1,-1};
		if(nums.length == 0)
			return result;
		result[0] = findFirst(nums, 0, nums.length - 1, target);
		if(result[0] == -1)
		{
			result[1] = -1;
			return result;
		}else{
			result[1] = findEnd(nums, result[0], nums.length - 1, target);
			return result;
		}
    }
	
	public static int findFirst(int nums[] , int begin,int end,int target){
		if(nums[begin] > target || nums[end] < target)
			return -1;
		else if(nums[begin] == target)
			return begin;
		int medium = (begin + end)/2;
		if(nums[medium] < target)
			begin = medium +1;
		else
			end = medium;
		return findFirst(nums, begin, end, target);
	}
	
	public static int findEnd(int nums[],int begin,int end,int target){
		if(nums[begin] > target || nums[end] < target)
			return -1;
		else if(nums[end] == target)
			return end;
		else if(end == begin +1)
			return begin;
		
		int medium = (begin + end)/2;
		if(nums[medium] > target)
			end = medium -1;
		else
			begin = medium;
		return findEnd(nums, begin, end, target);
	}
}
