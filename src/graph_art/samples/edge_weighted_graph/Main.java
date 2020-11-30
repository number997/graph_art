package graph_art.samples.edge_weighted_graph;

import graph_art.GraphArt;

public class Main {
	public static void main(String[] args) {
		//if your graph viz is on following location "C:/Program Files/Graphviz 2.44.1/bin/dot.exe"
		GraphArt ga = new GraphArt();
		EdgeWeightedGraph ewg = new EdgeWeightedGraph("ewg.txt");
		ga.setFileType("svg");
		ga.drawGraph("graf", ewg);
		ga.drawInBrowser(ewg.toDot());
	}
}
