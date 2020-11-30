package graph_art.samples.edge_weighted_graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EdgeWeightedGraph {
	private int V;
	private int E;
	private List<Set<Edge>> adj;
	
	public EdgeWeightedGraph(String file) {
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
		Edge e = new Edge(v, w, weight);
		adj.get(v).add(e);
		adj.get(w).add(e);
	}
	
	public Iterable<Edge> adj(int v) {
		return adj.get(v);
	}
	
	public Iterable<Edge> edges() {
		Set<Edge> edges = new HashSet<>();
		for(int v = 0; v < V; v++) {
			for(Edge e : adj.get(v)) {
				edges.add(e);
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
		StringBuilder sb = new StringBuilder("graph {");
		for(int v = 0; v < V; v++) {
			for(Edge e : adj.get(v)) {
				if(v > e.other(v)) {
					sb.append(e.toString());
				}
			}
		}
		sb.append("}");
		return sb.toString();
	}
}
