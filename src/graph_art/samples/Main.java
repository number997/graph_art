package graph_art.samples;

import graph_art.GraphArt;
import graph_art.samples.digraph.Digraph;
import graph_art.samples.edge_weighted_digraph.EdgeWeightedDigraph;
import graph_art.samples.edge_weighted_graph.EdgeWeightedGraph;
import graph_art.samples.graph.Graph;

public class Main {
	public static void main(String[] args) {
		GraphArt ga = new GraphArt();
		Graph g = new Graph("graph.txt");
		Digraph d = new Digraph("digraph.txt");
		EdgeWeightedGraph ewg = new EdgeWeightedGraph("ewd.txt");
		EdgeWeightedDigraph ewd = new EdgeWeightedDigraph("ewg.txt");
		
		GraphArt.help();
		ga.drawGraph(g);
		ga.drawGraph(d.toString());
		ga.drawGraph(ewg.toDot());
		ga.drawGraph("directed_edge_weighted_graph", ewd);
		ga.drawInBrowser(ewd);
	}
}
