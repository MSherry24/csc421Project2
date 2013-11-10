package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import main.TextInputParser.Node;
import main.TextInputParser.ReturnProperties;


public class Main {



	public static void main(String args[]) {
		TextInputParser text = new TextInputParser();
		HashMap<String, ArrayList<Node>> adjacencyList = new HashMap<String, ArrayList<Node>>();

		try {
			String fileName = args[0]; 
			ReturnProperties rp = text.readList(fileName);
			Integer size = rp.size;
			HashMap<String, Integer> d = rp.distance;
			HashMap<String, String> parent = rp.parents;
			MinHeap heap = new MinHeap(size);
			adjacencyList = rp.adjacencyList;
			d.put("A", 0);

			for (String k : rp.keys) {
				heap.insert(k, d.get(k));
			}
			
			for (int i = 0; i < size; i++) {
				HeapNode currentNode = heap.removeMin();
				String currentKey = currentNode.key;
				ArrayList<Node> currentKeyList = adjacencyList.get(currentKey);
				for (Node key : currentKeyList) {
					if (heap.keyIndex.get(key.vertex) == null) {
						continue;
					}
					if (d.get(key.vertex) > d.get(currentKey) + key.weight) {
						d.put(key.vertex, d.get(currentKey) + key.weight);  
						parent.put(key.vertex, currentKey);
						Integer keyIndex = heap.keyIndex.get(key.vertex);
						heap.updateValue(keyIndex, d.get(key.vertex));
						heap.swim(heap.minheap[keyIndex]);
					}
				}
			}
			
			System.out.println(d.get("B"));
			
			 
			String parentVertex = parent.get("B");
			Stack<String> s1 = new Stack<String>();
			if (parentVertex != null) {
				s1.push("B");
			}
			while (parentVertex != null) {
				s1.push(parentVertex);
				parentVertex = parent.get(parentVertex);
			}
			
			while (!s1.isEmpty()) {
				System.out.print(s1.pop() + " ");
			}

						
		}
		catch (Exception e) {
			System.out.println("Parse Error");
			
			
		}
	}
}
