package algorithms;

import java.util.Arrays;

public class DAry {
	
	private int[] heap;
	private boolean isMinHeap;
	private int splitfactor;
	
	public DAry(){
		this(new int[0], true, 2);
	}
	
	public DAry(int[] A, boolean isMinHeap, int splitfactor){
		this.heap = new int[A.length];
		this.isMinHeap = isMinHeap;
		this.splitfactor = splitfactor;
		for (int i = this.heap.length/2; i >= 0; i--) {
			heapify(this.heap, i, isMinHeap, splitfactor);
		}
	}
	
	public boolean heapify(int[] A, int i, boolean isMinHeap, int splitfactor){
		int[] indexes = new int[splitfactor + 1];
		indexes[0] = i;
		for(int j = 0; j < splitfactor; j++){
			indexes[j + 1] = ((i + 1) * splitfactor) + j - 1;
		}
		indexes = getChilds(A, i, splitfactor);
		int swap = getCandidate(A, indexes, isMinHeap);
		
		if(swap == i){
			return false;
		}
		swapElements(A, swap, i);
		return true;
	}
	
	private int[] getChilds(int[] A, int i, int splitfactor) {
		int childAmount = 0;
		if(i * 2 + splitfactor < A.length){
			childAmount = splitfactor;
		}else{
			childAmount = i * 2 + splitfactor - A.length;
			if(childAmount < 0){
				childAmount = 0;
			}
		}
		int[] childs = new int[childAmount + 1];
		childs[0] = i;
		for(int j = 1; j <= splitfactor; j++){
			childs[j] = i * splitfactor + (j);
		}
		return childs;
	}

	private void swapElements(int[] A, int swap, int i) {
		int holder = A[i];
		A[i] = A[swap];
		A[swap] = holder;
	}

	public int getCandidate(int[] A, int[] candidates, boolean isMinHeap){
		int result = 0;
		int highestValue = 0;
		boolean set = false;
		for(int i = 0 ; i < candidates.length; i++){
			if(!set){
				result = i;
				highestValue = A[i];
				set = true;
			}else{
				if(A[i] > highestValue){
					highestValue = A[i];
					result = i;
				}
			}
		}
		return result;
	}
	
	public int extractBest(){
		int result = this.heap[0];
		this.heap[0] = this.heap[this.heap.length - 1];
		this.heap = Arrays.copyOf(this.heap, this.heap.length - 1);
		for(int i = 0; i < this.heap.length / 2; i++){
			heapify(this.heap, i, this.isMinHeap, this.splitfactor);
		}
		return result;
	}
	
	public void insertElement(int element){
		this.heap = Arrays.copyOf(this.heap, this.heap.length + 1);
		this.heap[this.heap.length - 1] = element;
		int index = (this.heap.length - 1) / splitfactor; 
		while(heapify(this.heap, index, isMinHeap, element)){
			index /= this.splitfactor;
			if(index == 0){
				return;
			}
		}
	}
}
