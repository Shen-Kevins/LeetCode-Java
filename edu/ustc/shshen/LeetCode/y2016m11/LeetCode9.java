package edu.ustc.shshen.LeetCode.y2016m11;
/**
 * @Title: LeetCode9
 * @Description: 
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月16日下午10:17:03
 */
public class LeetCode9 {
	public static boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x%10 == 0))
        	return false;
        int rev = 0;
        while(x > rev){
        	rev = rev * 10 + x % 10;
        	x = x/10;
        }
        return (x == rev || x == rev/10);
    }
}
