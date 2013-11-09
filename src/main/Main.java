package main;

import java.util.ArrayList;
import java.util.HashMap;

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
			HashMap d = rp.distance;
			HashMap parent = rp.parents;
			Heap heap = new Heap(size);
			adjacencyList = rp.adjacencyList;
			
	
			

						
		}
		catch (Exception e) {
			System.out.println("Parse Error");
			
			
		}
	}
}
