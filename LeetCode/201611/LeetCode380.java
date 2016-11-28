package edu.ustc.shshen.LeetCode.y2016m11;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Title: LeetCode380
 * @Description: 击败百分之98已提交代码😜
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月20日下午2:35:56*/

public class LeetCode380 {
	List<Integer> list;
	Map<Integer,Integer> map;
	
	/** Initialize your data structure here. */
    public LeetCode380() {
        list = new ArrayList<>();
        map = new HashMap<Integer,Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
        	return false;
        else{
        	map.put(val, list.size());
        	list.add(val);
        	return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){	
        	map.put(list.get(list.size()-1), map.get(val));
			list.set(map.get(val), list.get(list.size()-1));
			list.remove(list.size()-1);
			map.remove(val);
        	return true;
        }else {
			return false;
		}
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int val = list.get( random.nextInt(list.size()));
        return val;
    }
}
