package graph_art.samples.edge_weighted_digraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EdgeWeightedDigraph {
	private int V;
	private int E;
	private List<Set<DirectedEdge>> adj;
	
	public EdgeWeightedDigraph(String file) {
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
				double weight = Double.parseDouble(parts[2]);
				
				addEdge(v, w, weight);
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
	
	public void addEdge(int v, int w, double weight) {
		DirectedEdge de = new DirectedEdge(v, w, weight);
		adj.get(v).add(de);
	}
	
	public Iterable<DirectedEdge> adj(int v) {
		return adj.get(v);
	}
	
	public Iterable<DirectedEdge> edges() {
		Set<DirectedEdge> edges = new HashSet<>();
		for(int v = 0; v < V; v++) {
			for(DirectedEdge de : adj.get(v)) {
				edges.add(de);
			}
		}
		return edges;
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public String toDot() {
		StringBuilder sb = new StringBuilder("digraph {");
		for(int v = 0; v < V; v++) {
			for(DirectedEdge de : adj.get(v)) {
				sb.append(de.toString());
			}
		}
		sb.append("}");
		return sb.toString();
	}
}
