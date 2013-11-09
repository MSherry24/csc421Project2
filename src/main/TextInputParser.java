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

	
	public class ReturnProperties {
		public HashMap<String, ArrayList<Node>> adjacencyList;
		public Integer size;
		public HashMap<String, String> parents;
		public HashMap<String, Integer> distance;
	}


	public ReturnProperties readList(String filename) throws IOException {
		ReturnProperties rp = readFromFile(filename);
		return rp;
	}


	private ReturnProperties readFromFile(String filename)
			throws FileNotFoundException, IOException {
		ReturnProperties rp = new ReturnProperties();
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		HashMap<String, ArrayList<Node>> adjacencyList = new HashMap<String, ArrayList<Node>>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if (line.equals(""))
				break;
			String[] s = line.split(" ");
			if (s.length != 3) {
				rp.size = Integer.parseInt(s[0]);
				continue;
			}
			if (!adjacencyList.containsKey(s[0])) {
				adjacencyList.put(s[0], new ArrayList<Node>());
			}
			if (!adjacencyList.containsKey(s[1])) {
				adjacencyList.put(s[1], new ArrayList<Node>());
			}
			rp.parents.put(s[0], null);
			rp.parents.put(s[1], null);
			rp.distance.put(s[0], Integer.MAX_VALUE);
			rp.distance.put(s[1], Integer.MAX_VALUE);

			adjacencyList.get(s[0]).add(new Node(s[1], Integer.parseInt(s[2])));
			adjacencyList.get(s[1]).add(new Node(s[0], Integer.parseInt(s[2])));
		}
		bufferedReader.close();
		rp.adjacencyList = adjacencyList;
		return rp;
	}




}

