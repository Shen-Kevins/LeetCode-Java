package edu.ustc.shshen.LeetCode.y2016m11;

/**
 * @Title: LeetCode209
 * @Description: two points    时间复杂度O(N)   不是自己做的
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月24日上午12:07:12*/
public class LeetCode209 {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
            return 0;
  
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
  
        while (j < nums.length) {
            sum += nums[j++];
    
            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
