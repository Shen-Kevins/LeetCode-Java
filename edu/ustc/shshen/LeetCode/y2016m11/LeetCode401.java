package edu.ustc.shshen.LeetCode.y2016m11;
/**
 * @Title: LeetCode401
 * @Description: 
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月20日上午12:09:56
 */
public class LeetCode401 {
	public static void main(String[] args) {
		int[] tt = {7,2,5,10,8};
		LeetCode401 test = new LeetCode401();
		System.out.println(test.splitArray(tt, 2));
	}
	
	public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for(int num : nums){
        	max = max > num ? max : num;
        	sum += num;
        }
        return (int)binary(nums, sum, max, m);
    }
	
	public long binary(int[] nums,long hight,long low,int m){
		long mid = 0;
		while(low < hight){
			mid = (low + hight) / 2;
			if(valid(nums, mid, m)){
				hight = mid;
			}else {
				low = mid + 1;
			}
		}
		return hight;
	}
	
	public boolean valid(int[] nums,long barrier,int m){
		int sum = 0;
		int count = 1;
		for(int num : nums){
			sum += num;
			if(sum > barrier){
				sum = num;
				count ++;
			}
			if(count > m)
				return false;
		}
		return true;
	}
}
