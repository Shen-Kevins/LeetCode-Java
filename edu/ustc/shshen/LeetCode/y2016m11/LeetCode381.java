package edu.ustc.shshen.LeetCode.y2016m11;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * @Title: LeetCode381
 * @Description: 
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月20日下午3:28:02*/
public class LeetCode381 {
	List<Integer> list;
	Map<Integer,HashSet<Integer>> map;
	
	/** Initialize your data structure here. */
    public LeetCode381() {
        list = new ArrayList<>();
        map = new HashMap<Integer,HashSet<Integer>>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
        {	
        	map.get(val).add(list.size());
        	list.add(val);
        	return false;
        }else{
        	map.put(val, new HashSet<Integer>());
        	map.get(val).add(list.size());        	
        	list.add(val);
        	return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
        	if(map.get(val).size() == 1){
        		int last = list.get(list.size()-1);
        		int mvindex = map.get(val).iterator().next();
        		map.get(last).remove(list.size()-1);
        		map.get(last).add(mvindex);
        		list.set(mvindex,list.get(list.size()-1));
        		list.remove(list.size()-1);
        		map.remove(val);
        	}else {
        		int last = list.get(list.size()-1);
        		int mvindex = map.get(val).iterator().next();
        		map.get(last).remove(list.size()-1);
        		map.get(last).add(mvindex);
        		list.set(mvindex, list.get(list.size()-1));
        		list.remove(list.size()-1);
        		if(last != val)
        			map.get(val).remove(mvindex);
			}      	
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
