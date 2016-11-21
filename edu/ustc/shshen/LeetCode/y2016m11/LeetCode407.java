package edu.ustc.shshen.LeetCode.y2016m11;
import java.util.PriorityQueue;

/**
 * @Title: LeetCode407
 * @Description: 
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月17日下午2:51:32*/
public class LeetCode407 {
	class cell implements Comparable<cell>{
		int row;
		int col;
		int value;
		@Override
		public int compareTo(cell o) {
			return value - o.value;
		}
		public cell(int row, int col, int value) {
			super();
			this.row = row;
			this.col = col;
			this.value = value;
		}
	}
	private int water = 0;
	private boolean[][] visited;
	public int trapRainWater(int[][] heightMap) {
        if(heightMap.length == 0) return 0;
        PriorityQueue<cell> walls = new PriorityQueue<cell>();
        water = 0;
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        visited = new boolean[rows][cols];
        //build walls
        for(int i = 0;i < rows;i++){
        	walls.add(new cell(i, 0, heightMap[i][0]));
        	walls.add(new cell(i, cols-1, heightMap[i][cols-1]));
        	visited[i][0] = true;
        	visited[i][cols-1] = true;
        }
        for(int i = 1;i < cols-1;i++){
        	walls.add(new cell(0, i, heightMap[0][i]));
        	walls.add(new cell(rows-1, i, heightMap[rows-1][i]));
        	visited[0][i] = true;
        	visited[rows-1][i] = true;
        }
        
        while(!walls.isEmpty()){
        	cell min = walls.poll();
        	deal(heightMap,min,walls);
        }
        return water;
    }
	
	public void deal(int[][] heightMap,cell min,PriorityQueue<cell> walls){
		fill(heightMap, min.row-1, min.col, walls, min.value);
		fill(heightMap, min.row+1, min.col, walls, min.value);
		fill(heightMap, min.row, min.col-1, walls, min.value);
		fill(heightMap, min.row, min.col+1, walls, min.value);
	}
	
	public void fill(int[][] heightMap,int row,int col,PriorityQueue<cell> walls,int min){
		if(row < 0 || col < 0 || row >heightMap.length-1 || col > heightMap[0].length-1) 
			return;
		else if(visited[row][col]) return;
		else if(heightMap[row][col] >= min)
		{
			walls.add(new cell(row, col, heightMap[row][col]));
			visited[row][col] = true;
			return;
		}else {
			water += min - heightMap[row][col];
			visited[row][col] = true;
			fill(heightMap, row-1, col, walls, min);
			fill(heightMap, row+1, col, walls, min);
			fill(heightMap, row, col-1, walls, min);
			fill(heightMap, row, col+1, walls, min);
		}
		
	}
}
