package edu.ustc.shshen.HihoCoder._201611;

import java.util.Scanner;

/**
 * @Title: _1032_1
 * @Description:TimeLimitExceeded 应该还可以优化 
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月29日下午1:01:33*/
public class _1032_1 {
	static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		for(int i = 0;i < N; i++){
			System.out.println(LongestManacher(scanner.next()));
		}
	}
	
	public static int LongestManacher(String input){
		if(input.length() == 1 && input.length() == 0)
			return input.length();	
		int max = 0;
		for(int i = 1;i < input.length(); i++){
			int length1 = Manacher(input, i, i);
			max = length1>max?length1:max;
			int length2 = Manacher(input, i-1, i);
			max = length2>max?length2:max;
		}
		return max;
	}
	
	public static int Manacher(String input,int left,int right){
		while(left >= 0 && right <input.length() && input.charAt(left) == input.charAt(right)){
			left--;
			right++;
		}
		return right-left-1;
	}
}
