package edu.ustc.shshen.LeetCode._201612;

/**
 * @Title: LeetCode162
 * @Description: 嗯.....为什么会有这种题
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年12月2日下午2:39:45*/
public class LeetCode162 {
	public static int findPeakElement(int[] nums) {
      for(int i = 0;i < nums.length-1;i++){
    	  if(nums[i] > nums[i+1])
    		  return i;
      }
      return nums.length-1;
   }
}
