package edu.ustc.shshen.LeetCode._201611;

/**
 * @Title: LeetCode5_2
 * @Description: 减小时间复杂度至 O(N)
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月30日上午12:11:11*/
public class LeetCode5_2 {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("cbbd"));
	}
	public static String longestPalindrome(String s) {
		char[]s1 = s.toCharArray();
		if(s1.length == 0 || s1.length == 1)return s;
		char[]deal = new char[2*s1.length+3];
		deal[0] = '$';
		deal[1] = '#';
		for(int i = 0;i<s1.length;i++){
			deal[2*(i+1)] = s1[i];
			deal[2*(i+1)+1] = '#';
		}
		deal[2*s1.length+2] = '\0';
		String max = "";
		int[]p = new int[deal.length]; 

		for(int i = 1,id = 0; i < deal.length - 1; i++){
			if(p[id]+id>i)
				p[i] = p[2*id-i]<p[id]+id-i?p[2*id-i]:p[id]+id-i;
			else
				p[i] = 1;
			while(deal[i-p[i]] == deal[i+p[i]]) p[i]++;
			if(p[i]+i > p[id]+id)
				id = i;
			if(p[i]-1 > max.length()){
				max = s.substring((i-p[i])/2,(i-p[i])/2+p[i]-1);
			}
		}
		return max;
	}
}
