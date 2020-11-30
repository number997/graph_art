package graph_art.samples.graph;

import graph_art.GraphArt;

public class Main {
	public static void main(String[] args) {
		GraphArt ga = new GraphArt();
		Graph g = new Graph("graph.txt");
		ga.drawGraph(g);
		ga.drawGraph("gRaPh_1", g);
		ga.drawInBrowser(g);
	}
}
