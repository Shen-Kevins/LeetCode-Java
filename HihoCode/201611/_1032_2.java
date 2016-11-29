package edu.ustc.shshen.HihoCoder._201611;

import java.util.Scanner;

public class _1032_2 {
	static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		for(int i = 0;i < N; i++){
			solve(scanner.next());
		}
	}
	
	public static void solve(String s){
		char []s1 = new char[2*s.length()+3];
		s1[2*s.length()+2] = '\0';
		s1[0] = '$';
		s1[1] = '#';
		for(int i = 0;i<s.length();i++){
			s1[(i+1)<<1]=s.charAt(i);
			s1[((i+1)<<1) +1] = '#';
		}
		int p[] = new int[s1.length];
		int res = 0;
	    for (int id = 0, i = 1; i < s1.length-1; ++i) {
	        if (p[id] + id > i)  
	        	p[i] = p[2 * id - i]<p[id] + id - i?p[2 * id - i]:p[id] + id - i;
	        else p[i] = 1;
	        while (s1[i + p[i]] == s1[i - p[i]]) ++p[i];
	        if (i + p[i] > id + p[id]) id = i;
	        res = res>p[i]?res:p[i];
	    }
	    System.out.println(res-1);
	}
}
