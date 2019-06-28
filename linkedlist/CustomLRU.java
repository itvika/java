package linkedlist;

/*********************************************
 * @author Vikas Kumar
 * @Email  itvika@gmail.com
 * @Phone  9868366690
 * @LinkedIn https://linkedin.com/in/itvika/
Output is :
============1
1-100
============1
1-100
============2
1-100
2-200
============3
1-100
2-200
3-300
============4
1-100
2-200
3-300
4-400
============4
2-200
3-300
4-400
5-500
============4
3-300
4-400
5-500
6-600
300
============4
4-400
5-500
6-600
3-300
============4
5-500
6-600
3-300
7-700

 */

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomLRU {
	Map<Integer,Integer> map;
	int capacity;
	
	CustomLRU(int N){
		this.capacity=N;
		map=new LinkedHashMap<Integer,Integer>(this.capacity);
		
	}
	
	public void set(int k,int v) {
		if(!this.map.containsKey(k)) {
			if(map.size()==this.capacity) {
				int first=map.keySet().iterator().next();
				map.remove(first);
				
			}
			map.put(k, v);
		}else {
			int value=map.get(k);
			map.remove(k);
			map.put(k, value);
		}
	}
	public int get(int k) {
		if(!this.map.containsKey(k)) {
			return -1;
		}
		
		int value=this.map.get(k);
		if(map.size()>1) {
			map.remove(k);
			map.put(k, value);
		}
		
		return value;
	}
	
	public void printLRU() {
		System.out.println("============"+map.size());
		for (Map.Entry<Integer, Integer> entry : this.map.entrySet()) {
			Integer key = entry.getKey();
		    Integer val = entry.getValue();
		    System.out.println(key+"-"+val);
		 }
	}

	public static void main(String[] args) {
		CustomLRU lru=new CustomLRU(4);
		lru.set(1, 100);
		lru.printLRU();
		lru.set(1, 100);
		lru.printLRU();
		lru.set(2, 200);
		lru.printLRU();
		lru.set(3, 300);
		lru.printLRU();
		lru.set(4, 400);
		lru.printLRU();
		lru.set(5, 500);
		lru.printLRU();
		lru.set(6, 600);
		lru.printLRU();
		System.out.println(lru.get(3));
		lru.printLRU();
		lru.set(7, 700);
		lru.printLRU();
		

	}

}
