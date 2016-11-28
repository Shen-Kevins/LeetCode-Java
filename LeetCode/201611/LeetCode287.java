package edu.ustc.shshen.LeetCode.y2016m11;
/**
 * @Title: LeetCode287
 * @Description: 二分查找 
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月17日下午1:32:14
 */
public class LeetCode287 {
	public int findDuplicate(int[] nums) {
        return binarySearch(nums, 1, nums.length);
    }	
	public int binarySearch(int[] nums,int left,int right){
		if(left == right)
			return left;
		
		int times = 0;
		for(int i = 0;i < nums.length;i++){
			if(nums[i] >= left && nums[i] <= (right + left)/2){
				times ++;
			}
		}		
		if(times > (right+left)/2 - left +1){
			return binarySearch(nums, left, (left+right)/2);
		}else{
			return binarySearch(nums, (left+right)/2 + 1, right);
		}
		
	}
}
