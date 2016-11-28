package edu.ustc.shshen.LeetCode.y2016m11;
/**
 * @Title: LeetCode413
 * @Description: 
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月16日下午10:16:37
 */
public class LeetCode413 {
	public static int numberOfArithmeticSlices(int[] A) {
        int result = 0;
        int times = 0;
        for(int i = 2;i < A.length; i++){
        	if(A[i] - A[i-1] == A[i-1] - A[i-2]){
        		if(times == 0){
        			times = 3;
        		}else{
        			times++;
        		}
        	}else{
        		if(times >= 3){
        			result += (times -1)*(times-2)/2;
        			times = 0;
        		}
        	}
        }
        if(times >= 3){
			result += (times -1)*(times-2)/2;
			times = 0;
		}
        
        return result;
    }
}
