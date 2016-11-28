package edu.ustc.shshen.LeetCode.y2016m11;

/**
 * @Title: LeetCode392
 * @Description: 时间复杂度O(n)，空间复杂度O(1)
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月22日上午9:59:07*/
public class LeetCode392 {
	public boolean isSubsequence(String s, String t) {
		int indexS=0,indexT=0;
		while(indexS < s.length() && indexT < t.length()){
			if(s.charAt(indexS) == t.charAt(indexT)){
				indexS++;indexT++;
			}else{
				indexT++;
			}
		}
		return indexS == s.length()? true:false;
    }
}
