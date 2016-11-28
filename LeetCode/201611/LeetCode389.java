package edu.ustc.shshen.LeetCode.y2016m11;
/**
 * @Title: LeetCode389
 * @Description: 
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月16日下午10:17:17
 */
public class LeetCode389 {
	public static char findTheDifference(String s, String t) {
        int Schar[] = new int[255];
        int Tchar[] = new int[255];
        for(int i = 0; i < s.length(); i++){
        	Schar[s.charAt(i)]++;
        }
        for(int i = 0 ; i < t.length(); i++){
        	Tchar[t.charAt(i)]++;
        }
        for(int i = 0;i < 255; i++){
        	if(Schar[i] != Tchar[i])
        		return (char)i;
        }
        return 'a';
    }
}
