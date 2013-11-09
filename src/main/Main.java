package main;

import java.util.ArrayList;
import java.util.HashMap;

import main.TextInputParser.Node;


public class Main {



	public static void main(String args[]) {
		TextInputParser text = new TextInputParser();
		HashMap<String, ArrayList<Node>> adjacencyList = new HashMap<String, ArrayList<Node>>();

		try {
			String fileName = args[0]; 
			adjacencyList = text.readList(fileName);
			Integer size = text.getSize(fileName);
			Integer d[];
			String parent[];
			System.out.println(size);
			
			
		}
		catch (Exception e) {
			System.out.println("Parse Error");
			
			
		}
	}
}
