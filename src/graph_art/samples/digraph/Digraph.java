package graph_art.samples.digraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Digraph {
	private int V;
	private int E;
	private List<Set<Integer>> adj;
	
	public Digraph(String file) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(file)));
			V = Integer.parseInt(br.readLine());
			E = Integer.parseInt(br.readLine());
			
			adj = new ArrayList<>();
			for(int v = 0; v < V; v++) {
				adj.add(new HashSet<>());
			}
			
			String vertices;
			
			while((vertices = br.readLine()) != null && vertices.length() > 0) {
				String[] parts = vertices.split(" ");
				int v = Integer.parseInt(parts[0]);
				int w = Integer.parseInt(parts[1]);
				
				addEdge(v, w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addEdge(int v, int w) {
		adj.get(v).add(w);
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public Iterable<Integer> adj(int v) {
		return adj.get(v);
	}
}
