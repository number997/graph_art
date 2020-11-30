package graph_art.samples.edge_weighted_digraph;

import graph_art.GraphArt;

public class Main {
	public static void main(String[] args) {
		//will look for GraphViz on specified path
		GraphArt ga = new GraphArt("C:/Program Files/Graphviz 2.44.1/bin/dot.exe");
		EdgeWeightedDigraph ewd = new EdgeWeightedDigraph("ewd.txt");
		ga.drawGraph(ewd.toDot());
		ga.drawGraph(ewd);
		ga.drawInBrowser(ewd);
	}
}
