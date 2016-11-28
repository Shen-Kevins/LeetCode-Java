package edu.ustc.shshen.LeetCode.y2016m11;
/**
 * @Title: LeetCode409_2
 * @Description: 
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月16日下午10:17:36
 */
public class LeetCode409_2 {
	public static int longestPalindrome(String s) {
        int result = 0,temp = 0;
        int chara[] = new int[255];
        for(int i = 0; i < s.length(); i++){
        	chara[s.charAt(i)]++;
        }
        for(int i = 0; i < 255; i ++){
        	if(chara[i]%2 == 1 && temp == 0){
        		temp = 1;
        	}
        	result += chara[i] - chara[i]%2;
        }
        return result + temp;
    }
}
