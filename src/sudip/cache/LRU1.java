package sudip.cache;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRU1 {
	
	static Deque<Integer> q;
	static HashSet<Integer> map;
	static int maxSize;
	
	LRU1(int capacity) {
		q = new LinkedList<>();
		map = new HashSet<>();
		maxSize = capacity;
	}
	
	public void refer(int data) {
		if(map.contains(data)) {
			q.remove(data);
		}
		else {
			if(q.size() == maxSize) {
				int last = q.removeLast();
				map.remove(last);
			}
		}
		q.push(data);
		map.add(data);
	}
	
	 public void display() 
	    { 
	        Iterator<Integer> itr = q.iterator(); 
	        while (itr.hasNext()) { 
	            System.out.print(itr.next() + " "); 
	        } 
	    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LRU1 ca = new LRU1(4); 
        ca.refer(1); 
        ca.refer(2); 
        ca.refer(3); 
        ca.refer(1); 
        ca.refer(4); 
        ca.refer(5); 
        ca.display(); 
	}

}
