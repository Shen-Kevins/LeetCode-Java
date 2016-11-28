package HihoCoder.y2016m11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Title: Week126
 * @Description: 要注意的地方   球面距离公式：Length = r * Acos(Cos(x1-x2) * Cos(y1-y2));
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月29日上午12:00:36*/
public class Week126_SphericalDistance{
	static Scanner scanner;
	public static void main(String[] args) {
		Map<String, ArrayList<Node2>> map = new HashMap<String,ArrayList<Node2>>();
		scanner = new Scanner(System.in);
		int N = scanner.nextInt(),M = scanner.nextInt();
		for(int i = 0;i < N; i++){
			double x = scanner.nextDouble();
			double y = scanner.nextDouble();
			String geohash = Encode(x, y, 30);
			if(map.get(geohash) == null){
				map.put(geohash, new ArrayList<Node2>());
			}
			map.get(geohash).add(new Node2(x, y));
		}
		double dx = (double)180.0/Math.pow(2, 15);
		double dy = (double)360.0/Math.pow(2, 15);
		for(int i = 0; i < M; i++){
			int num = 0;
			double x = scanner.nextDouble();
			double y = scanner.nextDouble();
			for(int j = 0;j < 3;j++){
				for(int k = 0; k < 3;k++){
					double nx = x + (j-1)*dx;
					double ny = y + (k-1)*dy;
					if(nx > 90){
						continue;
					}else if(nx < -90){
						continue;
					}
					
					if(ny > 180){
						ny = ny-360.0;
					}else if(ny < -180){
						ny = ny +360.0;
					}
					
					String geohash = Encode(nx, ny, 30);
					if(map.get(geohash) != null){					
						for(Node2 node2 : map.get(geohash)){
							if(distance(node2.x, node2.y, x, y) <= 500.0)
								num ++;
						}
					}
				}
			}
			System.out.println(num);
		}
	}
	
	
	
	public static double distance(double x,double y,double x1,double y1){
		x = x*Math.PI/180.0;
		y = y*Math.PI/180.0;
		x1 = x1*Math.PI/180.0;
		y1 = y1*Math.PI/180.0;
//		double degree = Math.acos(Math.cos(x)*Math.cos(x1)*Math.cos(y-y1)+Math.sin(x1)*Math.sin(x));
		double degree = Math.acos(Math.cos(x-x1)*Math.cos(y-y1));
		return 6e6*degree;
	}
	
	public static String Encode(double latitude,double longitude,int precision){
		String geohash = "";
		double latitudeInterval[] = {-90.0,90.0};
		double longitudeInterval[] = {-180.0,180.0};
		int bits = 0;
		double mid = 0;		
		for(int i = 0;i < precision; i++){
			if(i%2 == 1){
				mid = (latitudeInterval[0]+latitudeInterval[1])/2;
				if(latitude > mid){
					bits = bits*2+1;
					latitudeInterval[0] = mid;
				}else {
					bits = bits*2;
					latitudeInterval[1] = mid;
				}
			}else {
				mid = (longitudeInterval[0]+longitudeInterval[1])/2;
				if(longitude > mid){
					bits = bits*2+1;
					longitudeInterval[0] = mid;
				}else {
					bits = bits*2;
					longitudeInterval[1] = mid;
				}
			}			
			if(i%5 == 4){
				geohash += Base32(bits);
				bits = 0;
			}
		}	
		return geohash;
	}
	
	public static char Base32(int bit){
		if(bit >=32)
			return ' ';
		
		if(bit < 10 && bit >=0)
		{
			return (char)('0'+bit);
		}else if(bit >=10 && bit < 17){
			return (char)('b'+bit-10);
		}else if(bit >=17 && bit < 19){
			return (char)('j'+bit-17);
		}else if(bit >= 19 && bit < 21){
			return (char)('m'+bit-19);
		}else{
			return (char)('p'+bit-21);
		}
	}
}

class Node2{
	double x;
	double y;
	public Node2(double x,double y){
		this.x = x;
		this.y = y;
	}
}
