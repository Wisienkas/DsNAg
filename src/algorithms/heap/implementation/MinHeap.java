package algorithms.heap.implementation;

import java.util.ArrayList;

import algorithms.heap.Element;
import algorithms.heap.PQ;

public class MinHeap<T> implements PQ<T> {

	ArrayList<Element<T>> heap;
	
	public MinHeap(){
		heap = new ArrayList<Element<T>>();
	}
	
	@Override
	public Element<T> extractMin() {
		if(heap.isEmpty()){
			System.out.println("Returning null... heap has no elements!");
			return null;
		}
		Element<T> result = heap.get(0);
		
		if(heap.size() > 1){
			heap.set(0, heap.get(heap.size() - 1));
			heap.remove(heap.size() - 1);
			extractify(0);
		}else{
			heap.remove(0);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private void extractify(int i) {
		if(heap.size() < 2){
			return;
		}
		Element<T> parent = heap.get(i);
		Element<T> LChild = heap.size() > i * 2 + 1 ? heap.get((i * 2) + 1) : null; // 3 -> 7
		Element<T> RChild = heap.size() > i * 2 + 2 ? heap.get((i * 2) + 2) : null; // 3 -> 8
		
		if(LChild != null){
			if(RChild != null && RChild.compareTo((T)(LChild)) < 0 && RChild.compareTo((T)(parent)) < 0){
				swap(i, i * 2 + 2);
				extractify(i);
			}else if(LChild.compareTo((T)(parent)) < 0){
				swap(i, i * 2 + 1);
				extractify(i);
			}
		}
	}

	@Override
	public void Insert(Element<T> e) {
		heap.add(e);
		
		insertify(heap.size() - 1);
	}

	@SuppressWarnings("unchecked")
	private void insertify(int i) {
		if(i < 1) return;
		
		if(heap.get(i).compareTo((T) (heap.get((i - 1) / 2))) < 0){
			swap(i, (i - 1) / 2);
			insertify((i - 1) / 2);
		}
	}

	private void swap(int i, int j) {
		Element<T> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}

	@Override
	public void printArray() {
		for (int i = 0; i < heap.size(); i++) {
			System.out.println("Key: " + heap.get(i).getKey().longValue());
		}
	}


}
