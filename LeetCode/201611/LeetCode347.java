package edu.ustc.shshen.LeetCode.y2016m11;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 基数排序   时间复杂度  O(n)
 * @author shshen
 *
 */
public class LeetCode347 {
	class asset{
		Integer num;
		Integer value;
		public asset(int num,int value) {
			this.num = num;
			this.value = value;
		}
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> freq = new HashMap<Integer,Integer>();
		
		for(int i = 0; i < nums.length; i++){
			if(freq.containsKey(nums[i])){
				freq.put(nums[i], freq.get(nums[i])+1);
			}else{
				freq.put(nums[i], 1);
			}
		}
		
		asset[] assets = new asset[freq.keySet().size()];
		int i = 0;
		for(Integer num : freq.keySet()){
			assets[i] = new asset(num, freq.get(num));
			i++;
		}
		
		CountingSort(assets, result, nums.length, k);
		return result;
	}
	
	public void CountingSort(asset assets[],List<Integer> result,int size,int k){
		asset[] assetss = new asset[assets.length];
		int c[] = new int[size+1];
		for(int i = 0 ; i < assets.length; i++){
			c[assets[i].value] ++;
		}
		
		for(int i = 1; i < size; i++){
			c[i] = c[i]+c[i-1];
		}
		
		for(int i = 0;i < assets.length; i++){
			assetss[c[assets[i].value]-1] = assets[i];
			c[assets[i].value]--;
		}
		
		for(int i = assetss.length-1 ;i >= assetss.length - k; i--){
			result.add(assetss[i].num);
		}
	}
	
}
