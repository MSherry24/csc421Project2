package main;

public class Heap {

	private Integer size;
	private String[] heap;

	public Heap(Integer size) {
		this.size = 0;
		this.heap = new String[size];
	}

	public void add(String s) {
		heap[size] = s;
		this.size++;
		this.swim();
	}
	
	private void swim() {
		
	}
	
	private void sink() {
		
	}
	
	private int getLeftChild(int i) {
		return 2*i;
	}
	
	private int getRightChild(int i) {
		return 2*i+1;
	}

	private int getParent(int i) {
		return i/2;
	}
}
