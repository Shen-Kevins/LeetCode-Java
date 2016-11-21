package edu.ustc.shshen.LeetCode.y2016m11;


/**
 * @Title: LeetCode376
 * @Description: 递推   时间复杂度 O(n)
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月21日下午6:03:17*/
public class LeetCode376 {
	public int wiggleMaxLength(int[] nums) {
	       if(nums.length == 0)
				return 0;
			if(nums.length == 1)
				return 1;
	        int positive[] = new int[nums.length];
	        int negative[] = new int[nums.length];
	        
	        positive[nums.length-1] = negative[nums.length-1] = 1;
	        if(nums[nums.length-1] > nums[nums.length-2]){
	        	positive[nums.length-2] = 1;
	        	negative[nums.length-2] = 2;
	        }else if(nums[nums.length-1] < nums[nums.length-2]){
	        	positive[nums.length-2] = 2;
	        	negative[nums.length-2] = 1;
	        }else {
				positive[nums.length-2] = negative[nums.length-2] = 1;
			}
	        
	        for(int i = nums.length-3; i >= 0; i--){
	        	if(nums[i] == nums[i+1])
	        	{
	        		negative[i] = negative[i+1];
	        		positive[i] = positive[i+1];
	        		continue;
	        	}
	        	
	        	int pos =i, neg = i ;
	        	while(pos < nums.length-1 && nums[pos+1] < nums[i])
	        		pos++;
	        	pos++;
	        	while(neg < nums.length-1 && nums[neg+1] > nums[i])
	        		neg++;
	        	neg++;
	        	while(pos < nums.length-1 && nums[pos+1] - nums[pos]> 0){
	        		pos ++;
	        	}
	        	if(pos == nums.length)
	        	{
	        		negative[i] = 1;
	        	}else{
					negative[i] = positive[pos] + 1;
				}
	        	
	        	while(neg < nums.length-1 && nums[neg+1] - nums[neg] < 0)
	        		neg++;
	        	if(neg == nums.length)
	        	{
	        		positive[i] = 1;
	        	}else {
					positive[i] = negative[neg] + 1;
				}
	        }
	        return positive[0] > negative[0]?positive[0]:negative[0];
	    }
}
