package HihoCoder.y2016m11;

import java.util.Scanner;

/**
 * @Title: Week125
 * @Description: 传说中的geohash编码   虽然不知道有什么用   但还是实现了下 另外，Java为什么没有Base32..
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月28日上午12:39:34*/
public class Week125_geohash{
	static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int N = scanner.nextInt(),M = scanner.nextInt();
		for(int i = 0;i < N; i++){
			double x = scanner.nextDouble(),y = scanner.nextDouble();
			System.out.println(Encode(x, y, 50));
		}
		for(int i = 0;i < M;i++){
			String geohash = scanner.next();
			double decode[] = DeCode(geohash);
			System.out.print(String.format("%.6f", decode[0]));
			System.out.println(String.format("%.6f", decode[1]));
		}
		
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
	
	public static double[] DeCode(String geohash) {
		double situation[] = new double[2];
		double latitudeInterval[] = {-90.0,90.0};
		double longitudeInterval[] = {-180.0,180.0};
		int bits = 0,bit = 0;
		boolean odd = true;
		double mid = 0;
		for(int i = 0;i < geohash.length();i++){
			bits = DeBase32(geohash.charAt(i));
			for(int j = 4;j>=0;j--){
				bit = (bits>>j)&1;
				if(!odd){
					mid = (latitudeInterval[0]+latitudeInterval[1])/2;
					latitudeInterval[1-bit] = mid;
				}else {
					mid = (longitudeInterval[0]+longitudeInterval[1])/2;
					longitudeInterval[1-bit] = mid;
				}
				odd = !odd;
			}
		}
		situation[0] = (latitudeInterval[0]+latitudeInterval[1])/2;
		situation[1] = (longitudeInterval[0]+longitudeInterval[1])/2;
		return situation;
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
	
	public static int DeBase32(char c){
		if(c <= '9' && c>='0'){
			return c-'0';
		}else if(c >= 'b' && c <= 'h'){
			return c-'b'+10;
		}else if (c >= 'j' && c<= 'k'){
			return c-'j'+17;
		}else if (c >= 'm' && c <= 'n') {
			return c-'m'+19;
		}else {
			return c-'p'+21;
		}
	}
}
