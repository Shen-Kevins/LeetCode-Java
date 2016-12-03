package edu.ustc.shshen.LeetCode._201612;


import java.util.ArrayList;
import java.util.List;

/**
 * @Title: NQueens
 * @Description: 回溯法搜索  最多可以解决15皇后问题...
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年12月3日下午8:25:40*/
public class LeetCode51_NQueen {
	public static List<List<String>> Find(int n){
		List<List<String>> result = new ArrayList<>();
		int row = 0,col = 0;
		int rownum[] = new int[n];
		int colnum[] = new int[n];
		for(int i = 0;i < n;i++){rownum[i] = colnum[i] = 0;}
		int leftIncline[] = new int[2*n-1];
		int rightIncline[] = new int[2*n-1];
		for(int i = 0;i < 2*n-1;i++){leftIncline[i] = rightIncline[i] = 0;}
		
		int queens[][] = new int[n][n];
		int choose[] = new int[n];
		while(true){
			if(rownum[row] ==1 || colnum[col] == 1 || 
					leftIncline[row+col] == 1 || rightIncline[row-col+n-1] == 1){
				while(col == n-1)
				{
					if(row == 0) return result;
					row = row-1;
					col = choose[row];
					queens[row][col] = 0;
					rownum[row] = 0;
					colnum[col] = 0;
					leftIncline[row+col] = 0;
					rightIncline[row-col+n-1] = 0;
				}
				col++;
			}else{
				choose[row] = col;
				queens[row][col] = 1;
				rownum[row] = 1;
				colnum[col] = 1;
				leftIncline[row+col] = 1;
				rightIncline[row-col+n-1] = 1;
				row++;
				col = 0;
				if(row == n){
					List<String> one = new ArrayList<String>();
					for(int i = 0;i < n;i++){
						char []set = new char[n];
						for(int j = 0;j < n;j++){
							if(queens[i][j] == 0)
								set[j] = '.';
							else
								set[j] = 'Q';
						}
						one.add(String.valueOf(set));
					}
					result.add(one);
					while(col == n || row == n)
					{
						if(row == 0) return result;
						row = row-1;
						col = choose[row];
						queens[row][col] = 0;
						rownum[row] = 0;
						colnum[col] = 0;
						leftIncline[row+col] = 0;
						rightIncline[row-col+n-1] = 0;
						col++;
					}
				}
			}
		}
	}
}
