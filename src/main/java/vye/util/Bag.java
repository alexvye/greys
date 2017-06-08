package vye.util;

import java.util.ArrayList;
import java.util.List;

public class Bag<T> {
	
	private List<T> items; 
	
	public Bag() {
		items = new ArrayList<T>();
	}
	
	public void additems(T item, int count) {
		for(int i=0;i<count;i++) {
			items.add(item);
		}
	}
	
	public T grabOne(boolean remove) {
		
		T result = null;

		if(items.size() > 0) {
		
			int index = Roller.roll(1, items.size());
			result = items.get(index);
			
			if(remove) {
				items.remove(index);
			}
		} 
		return result;
	}
	
	public void empty() {
		items.clear();
	}
}
