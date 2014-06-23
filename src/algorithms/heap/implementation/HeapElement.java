package algorithms.heap.implementation;

import algorithms.heap.Element;

@SuppressWarnings("rawtypes")
public class HeapElement<T extends HeapElement> implements Element<T>{

	private Number key;
	private Object val;
	
	public HeapElement(Number key, Object val){
		this.key = key;
		this.val = val;
	}
	
	@Override
	public int compareTo(T o) {
		return this.key.intValue() - o.getKey().intValue();
	}

	@Override
	public Object getValue() {
		return this.val;
	}

	@Override
	public Number getKey() {
		return this.key;
	}
	
	
}
