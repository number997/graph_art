package graph_art.samples.edge_weighted_graph;

public class Edge {
	private int v;
	private int w;
	private double weight;
	
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int either() {
		return v;
	}
	
	public int other(int u) {
		if(u == v) {
			return w;
		}
		
		return v;
	}
	
	public double weight() {
		return weight;
	}
	
	public String toString() {
		return v+" -- " + w + "[label="+weight+"];\n";
	}
}
