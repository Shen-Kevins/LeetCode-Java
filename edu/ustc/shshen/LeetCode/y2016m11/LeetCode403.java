package edu.ustc.shshen.LeetCode.y2016m11;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/**
 * @Title: LeetCode403
 * @Description: 前向搜索，将每个节点可跳跃的步数存在hash表中，综合时间复杂度接近 O(n)
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月20日下午12:27:47*/
public class LeetCode403 {
	public boolean canCross(int[] stones) {
        if(stones.length <= 1)
        	return true;
        if(stones[1] != 1 || stones[stones.length-1] > stones.length*(stones.length-1)/2)
        	return false;

		Map<Integer, HashSet<Integer>> map = new HashMap<Integer,HashSet<Integer>>(stones.length);
        for(int i = 0 ; i < stones.length; i++){
        	map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(1);
        
        for(int i = 0;i < stones.length; i++){
        	int stone = stones[i];
        	for(int step : map.get(stone)){
        		if(step+stone == stones[stones.length-1])
        			return true;
       
        		HashSet<Integer> newset = map.get(stone+step);
        		if(newset != null){
        			map.get(stone+step).add(step);
        			map.get(step+stone).add(step+1);
        			if(step-1 > 0) map.get(step+stone).add(step-1);
        		}
        	}
        }
        return false;
    }
}
