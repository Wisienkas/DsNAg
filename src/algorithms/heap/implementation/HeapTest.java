package algorithms.heap.implementation;

import algorithms.heap.PQ;

public class HeapTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("rawtypes")
		PQ heap = new MinHeap<HeapElement<HeapElement>>();
		int[] arr = {1,3,5,4,10,13,7,6,17, 2}; // Inputs
		insertArray(arr, heap);
		heap.printArray();
	}

	@SuppressWarnings("unchecked")
	private static void insertArray(int[] arr, PQ heap) {
		for (int i = 0; i < arr.length; i++) {
			heap.Insert(new HeapElement<>(new Integer(arr[i]), null));
		}
	}
}
