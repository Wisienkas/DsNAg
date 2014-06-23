package algorithms.heap;


public interface PQ<T> {
	Element<T> extractMin();
	void Insert(Element<T> e);
	void printArray();
}
