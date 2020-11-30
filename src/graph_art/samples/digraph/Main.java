package graph_art.samples.digraph;

import graph_art.GraphArt;

public class Main {
	public static void main(String[] args) {
		GraphArt gv = new GraphArt();
		Digraph d = new Digraph("digraph.txt");
		gv.drawGraph(d);
		gv.drawGraph("directed_graph", d);
		gv.drawInBrowser(d);
	}
}
