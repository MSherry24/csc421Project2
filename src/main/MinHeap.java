package main;

import java.util.HashMap;

public class MinHeap {

	HeapNode[] minheap;
	Integer size;
	HashMap<String, Integer> keyIndex;

	public MinHeap(Integer size) {
		this.minheap = new HeapNode[size+1];
		this.size = 1;
		keyIndex = new HashMap<String, Integer>();
	}

	public void insert(String s, Integer value) {
		minheap[this.size] = new HeapNode(s, value, this.size);
		keyIndex.put(s, this.size);
		swim(minheap[this.size]);
		this.size++;
		
	}

	public HeapNode removeMin() {
		if (this.size == 1) {
			return null;
		}
		if (this.size == 2) {
			HeapNode returnNode = this.minheap[1];
			this.keyIndex.put(returnNode.key, null);
			this.minheap[1] = null;
			this.size--;
			return returnNode;
		}
		this.size--;
		HeapNode returnNode = this.minheap[1];
		this.keyIndex.put(returnNode.key, null);
		this.minheap[1] = this.minheap[this.size];
		this.keyIndex.put(this.minheap[1].key, 1);
		this.minheap[1].index = 1;
		this.minheap[this.size] = null;
		sink(this.minheap[1]);
		return returnNode;
	}
	
	public void swim(HeapNode node) {
		HeapNode parent = getParent(node);
		if (parent == null) {
			return;
		}
		if (parent.value  > node.value) {
			swapNodes(node, parent);
			swim(node);
		}
	}

	public void sink(HeapNode node) {
		HeapNode lChild = (node.index * 2 > this.size) ? null : this.minheap[node.index * 2];
		HeapNode rChild = (node.index * 2 + 1 > this.size) ? null : this.minheap[node.index * 2 + 1];
		HeapNode smallChild;
		if (lChild == null && rChild == null) {
			return;
		}
		else if (lChild == null && rChild != null) {
			smallChild = rChild;
		}
		else if (lChild != null && rChild == null) {
			smallChild = lChild;
		}
		else {
			smallChild = (lChild.value < rChild.value ? lChild : rChild);
		}
		if (node.value > smallChild.value) {
			swapNodes(node, smallChild);
			sink(node);
		}
	}

	private HeapNode getParent(HeapNode node) {
		return this.minheap[node.index / 2];
	}

	private void swapNodes(HeapNode a, HeapNode b) {
		int aIndex = a.index;
		int bIndex = b.index;
		a.index = bIndex;
		b.index = aIndex;
		this.keyIndex.put(a.key, a.index);
		this.keyIndex.put(b.key, b.index);

		minheap[aIndex] = b;
		minheap[bIndex] = a;
	}
	
	public void updateValue(Integer index, Integer value) {
		minheap[index].value = value;
	}


	public static void main(String argsp[]) {
		MinHeap mh = new MinHeap(10);

		mh.insert("A", 5);
		mh.insert("B", 100);
		mh.insert("C", 7);
		mh.insert("D", 15);
		mh.insert("E", 10);

		while(mh.size > 1) {
			HeapNode node = mh.removeMin();
			System.out.println(node.key + " " + node.value);
		}
	}




}
