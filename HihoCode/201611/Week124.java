package HihoCoder.y2016m11;
import java.util.*;

/**
 * @Title: Week124
 * @Description: 四叉树存取节点   计算距离指定节点距离在r内的节点数
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月26日下午11:17:26*/
public class Week124 {
	static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int N = scanner.nextInt(),M = scanner.nextInt();
		QuadTree root = new QuadTree(0, 30000, 30000, 0);
		for(int i = 0;i < N; i++){
			int x = scanner.nextInt(),y = scanner.nextInt();
			root.insert(x, y);
		}
		for(int i = 0;i < M; i++){
			int x = scanner.nextInt(),y = scanner.nextInt(),
					r = scanner.nextInt();
			System.out.println(root.find(x, y, r));
		}
	}
}

class QuadTree{
	int capacity = 200;
	int count;
	QuadTree child[];
	LinkedList<Node> nodes = new LinkedList<Node>();
	Boundary boundary;
	
	public QuadTree(double left,double right,double top,double bottom){
		this.boundary = new Boundary(left, right, top, bottom);
		this.count = 0;
	}
	
	public void insert(int x,int y){
		if(child == null){
			if(count == capacity){
				this.split();
				insert(x, y);
				return;
			}else {
				count++;
				Node node = new Node(x, y);
				nodes.add(node);
				return;
			}
		}else {
			child[boundary.getIndex(x, y)].insert(x, y);
			count++;
		}		
	}
	
	public void split(){
		child = new QuadTree[4];
		Boundary b = this.boundary;
		child[0] = new QuadTree(b.left, b.centx, b.centy, b.bottom);
		child[1] = new QuadTree(b.centx, b.right, b.centy, b.bottom);
		child[2] = new QuadTree(b.left, b.centx, b.top, b.centy);
		child[3] = new QuadTree(b.centx, b.right, b.top, b.centy);
		for(Node n : this.nodes){
			child[b.getIndex(n.x, n.y)].insert(n.x, n.y);
		}
		nodes = null;
	}
	
	public int find(int x,int y,int r){
		double r0 = distance(x, y, boundary.left, boundary.bottom),
				r1 = distance(x, y, boundary.right, boundary.bottom),
				r2 = distance(x, y, boundary.left, boundary.top),
				r3 = distance(x, y, boundary.right, boundary.top);
		if(r0<=r && r1<=r && r2<=r && r3<=r)
			return count;
		if(child == null){
			int n = 0;
			for(Node node :nodes){
				if(distance(x, y, node.x, node.y) <= r){
					n++;
				}
			}
			return n;
		}else {
			int n = 0;
			n += child[0].find(x, y, r);
			n += child[1].find(x, y, r);
			n += child[2].find(x, y, r);
			n += child[3].find(x, y, r);
			return n;
		}
	}
	
	public double distance(double x,double y,double rx,double ry){
		return Math.sqrt((x-rx)*(x-rx)+(y-ry)*(y-ry));
	}
}

class Node{
	int x,y;
	public Node(int x,int y){
		this.x = x;
		this.y = y;
	}
}

class Boundary{
	double left,right,top,bottom;
	double centx,centy;
	
	public Boundary(double left, double right, double top, double bottom) {
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
		this.centx = (left+right)/2;
		this.centy = (top+bottom)/2;
	}
	
	int getIndex(int x,int y){
		boolean p = (x >= this.left)&&(x<= this.centx);
		boolean q = (y >= this.bottom)&&(y <= this.centy);
		if(p&&q){
			return 0;
		}else if(p){
			return 2;
		}else if (q) {
			return 1;
		}else{
			return 3;
		}
	}
}

