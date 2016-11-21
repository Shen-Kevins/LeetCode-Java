package edu.ustc.shshen.LeetCode.y2016m11;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * @Title: LeetCode409_1
 * @Description: 
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月16日下午10:17:26
 */
public class LeetCode409_1 {
	public static int longestPalindrome(String s) {
        HashMap<Character, Integer> temp= new HashMap<>();
        for(int i = 0; i < s.length(); i++){
        	if(temp.containsKey(s.charAt(i))){
        		int value = temp.remove(s.charAt(i));
        		temp.put(s.charAt(i), value+1);
        	}else {
				temp.put(s.charAt(i), 1);
			}
        }
        
        int a=0,result = 0;
        Iterator iter = temp.entrySet().iterator();
        while(iter.hasNext()){
        	Map.Entry entry = (Map.Entry)iter.next();
        	int key = (int)entry.getValue();
        	if(key % 2 == 1)
        		a = 1;
        	result += key - key%2;
        }
        return result+a;
    }
}
