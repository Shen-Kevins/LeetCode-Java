package edu.ustc.shshen.LeetCode.y2016m11;

/**
 * @Title: LeetCode377
 * @Description: 动归   时间复杂度O(N*N)
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月22日上午10:18:56*/
public class LeetCode377 {
	public int combinationSum4(int[] nums, int target) {
        int result[] = new int[target+1];
        result[0] = 1;
        for(int i = 1 ; i <= target; i++){
        	result[i] = 0;
        	for(int j = 0;j < nums.length; j++){
        		if(nums[j] <= i){
        			result[i] += result[i-nums[j]];
        		}
        	}
        }
        return result[target];
    }
}
