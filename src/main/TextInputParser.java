package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TextInputParser {
	public class Node {
		private String vertex;
		private Integer weight;

		Node(String v, Integer w) {
			this.vertex = v;
			this.weight = w;
		}
	}


	public HashMap<String, ArrayList<Node>> readList(String filename) throws IOException {
		HashMap<String, ArrayList<Node>> points = readFromFile(filename);
		return points;
	}

	public Integer getSize(String filename) throws FileNotFoundException, IOException {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if (line.equals(""))
				break;
			String[] s = line.split(" ");
			bufferedReader.close();
			return Integer.parseInt(s[0]);
			
		}
		bufferedReader.close();
		return null;
	}

	private HashMap<String, ArrayList<Node>> readFromFile(String filename)
			throws FileNotFoundException, IOException {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		HashMap<String, ArrayList<Node>> adjacencyList = new HashMap<String, ArrayList<Node>>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if (line.equals(""))
				break;
			String[] s = line.split(" ");
			if (s.length != 3) {
				continue;
			}
			if (!adjacencyList.containsKey(s[0])) {
				adjacencyList.put(s[0], new ArrayList<Node>());
			}
			if (!adjacencyList.containsKey(s[1])) {
				adjacencyList.put(s[1], new ArrayList<Node>());
			}
			adjacencyList.get(s[0]).add(new Node(s[1], Integer.parseInt(s[2])));
			adjacencyList.get(s[1]).add(new Node(s[0], Integer.parseInt(s[2])));
		}
		bufferedReader.close();
		return adjacencyList;
	}




}

