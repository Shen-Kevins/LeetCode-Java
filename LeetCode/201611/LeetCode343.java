package edu.ustc.shshen.LeetCode.y2016m11;
/**
 * @Title: LeetCode343
 * @Description: 
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月17日下午3:58:44*/
public class LeetCode343 {
	public int integerBreak(int n) {
        int result[] = new int[n+1];
        result[1] = 1;
        result[2] = 1;
        int max;
        for(int i = 3;i <= n;i++){
        	max = 1;
        	for(int j = 1;j<=(i+1)/2;j++){
        		if(j*(i-j) > max)
        			max = j*(i-j);
        		if(j*result[i-j] > max)
        			max = j*result[i-j];
        	}
        	result[i] = max;
        }
        return result[n];
      }
}
