package edu.ustc.shshen.HihoCoder._201611;
import java.util.Scanner;

/**
 * @Title: _1032_3
 * @Description: 时间复杂度O(N)
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月30日上午12:12:05*/
public class _1032_3 {
	static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		for(int i = 0;i < N; i++){
			System.out.println(LongestManacher(scanner.next().toCharArray()));
		}
	}
	
	public static int LongestManacher(char s[]){
		if(s.length == 1 && s.length == 0)
			return s.length;	
		char[] s1 = new char[2*s.length+3];
		s1[0] = '$';
		s1[1] = '#';
		for(int i=0;i < s.length;i++){
			s1[2*(i+1)] = s[i];
			s1[2*(i+1)+1] = '#';
		}
		s1[2*s.length+2] = '\0';		
		int p[] = new int[s1.length];
		int max = 0;
		for(int id = 0,i = 1;i < s1.length-1; i++){
			if(id+p[id] > i)
				p[i] = p[2*id-i]<p[id]+id-i?p[2*id-i]:p[id]+id-i;
			else p[i] = 1;
			while(s1[i-p[i]] == s1[i+p[i]]) p[i]++;
			if(p[id] + id < p[i]+i)
				id = i;
			max = max > p[i]?max:p[i];
		}
		return max-1;
	}
}
