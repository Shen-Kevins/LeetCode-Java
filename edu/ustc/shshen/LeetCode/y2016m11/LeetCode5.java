package edu.ustc.shshen.LeetCode.y2016m11;
public class LeetCode5 {
	public static String longestPalindrome(String s) {
		if(s.length() == 0 || s.length() == 1)return s;
		String max = "";
		for(int i = 0; i < s.length() - 1; i++){
			String sample1 = helper(s, i, i);
			if(sample1.length() > max.length())
				max = sample1;
			
			String sample2 = helper(s, i, i+1);
			if(sample2.length() > max.length())
				max = sample2;
		}
		return max;
	}
	public static String helper(String s,int left,int right){
		while(left >= 0 && right <= s.length()-1){
			if(s.charAt(left) == s.charAt(right))
			{
				left --;
				right ++;
			}else{
				break;
			}
		}
		String result = s.substring(left+1,right);
		return result;
	}
}
