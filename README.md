# GraphArt

GraphArt.java - a library to create graph images and dot graph representations from Java programs. This library strives to be compatible with graph definitions and implementations on Data Structures and Algorithms 3 course on  Faculty of Sciences University of Novi Sad.

GraphArt expects GraphViz ``(https://graphviz.org/)`` to be installed on your computer. GraphArt is made to be used within graph classes used and implemented on course Data Structures and Algorithms 3. GraphArt works as expected with ``Graph``, ``Digraph``, ``EdgeWeightedGraph`` and ``EdgeWeightedDigraph`` from ``edu.princeton.cs.algs4`` package on ``Windows 10``, and ``Ubuntu 20.04 LTS`` operating systems. Custom implemetations of mentioned classes also works fine as long as methods are defined or set as described further in text. ``MacOSX`` is not tested.

GraphArt can be used for making dot string representation of Graphs used and implemented on course Data Structures and Algorithms 3. To make graph image GraphArt expects either object of one of graph types used on aforementioned course or valid dot representation of required graph.

Default allowed class names are ``Graph``, ``Digraph``, ``EdgeWeightedGraph`` and ``EdgeWeightedDigraph``.
Class names can be changed by using methods:

```
setGraphClassName(String className)
setDigraphClassName(String className)
setEdgeWeightedGraphClassName(String className)
setEdgeWeightedDigraphClassName(String className)
```

For example if name of Digraph class is Digraf, ``setDigraphClassName("Digraf")`` should be used.

Our implementation expects graph and digraph implementations to have following methods:
  - (by default) ``V()`` that returns number of vertices in graph
  - (by default) ``adj(int v)`` that return ``Iterable<Integer>`` of vertices adjacent to vertex v.
  
These method names can be changed by using methods:

```
setNumberOfVerticesMethodName(String methodName)
setAdjacentVerticesMethodName(String methodName)
```

For ``EdgeWeightedGraph`` and ``EdgeWeightedDigraph`` it is expected that edge is Object of some type.
Methods expected in mentioned edge object are:
  - (by default) ``edges()`` that returns ``Iterable<Object>`` of edges from ``EdgeWeightedGraph/EdgeWeightedDigraph``
  - (by default) ``either()`` and ``other(int v)`` that return vertices incident to ``Edge`` in ``EdgeWeightedGraph``
  - (by default) ``from()`` and ``to()`` that return vertices incident ot ``DirectedEdge`` in ``EdgeWeightedDigraph``
  - (by default) ``weight()`` that returns edge weight.  
These method names can be changed by using:

```
setEdgeMethodName(String methodName)
setEdgeWeightedGraphEither(String methodName)
setEdgeWeightedGraphOther(String methodName)
setEdgeWeightedDigraphFrom(String methodName)
setEdgeWeightedDigraphTo(String methodName)
setEdgeWeightMethodName(String methodName)
```
  
If in your implementation of ``Graph/Digraph`` your method for number of vertices in ``Graph/Digraph`` is: ``public int getNumberOfVertices(){...}`` then ``setNumberOfVerticesMethodName(String methodName)`` should be used as: ``setNumberOfVerticesMethodName("getNumberOfVertices")``. Same can be applied for other methods for setting method name. All method and graph names can be reset to default by using methods ``resetMethodNames()`` and ``resetGraphClassNames()`` respectively.

By using method ``toDot(Object graph)`` GraphArt will return String representation of graph passed to method.

Output image type can be changed by using method ``setFileType(String fileType)``. Allowed file types are:
  - png (default)
  - jpg
  - gif
  - svg.
  
For example if gif is required, method ``setFileType(String fileType)`` should be used as ``setFileType("gif")``.

If in your implementation of graph you have ``toDot()`` method, or ``toString()`` method that returns dot format of graph, (or for that purpose any other method that returns dot formated string of graph) GraphArt can be used to draw your graph by using ``drawGraph(String dotSource)`` as ``drawGraph(graph.toDot())`` or ``drawGraph(graph.toString())``.

For graphs that have less than 400 edges method ``drawInBrowser(Object graph)`` or ``drawInBrowser(String dot)`` can be used. Default browser will be opened and appropriate query sent to service that does drawing.

### ----Usage example----
``` 
public class Main {
    public static void main(String[] args) {
        Digraph d = new Digraph(Svetovid.in("digraf-zavrsni.txt"));
        Graph g = new Graph(Svetovid.in("mediumG.txt"));
        EdgeWeightedDigraph ewd = new EdgeWeightedDigraph(new In("tinyEWD.txt"));
        EdgeWeightedGraph ewdd = new EdgeWeightedGraph(new In("tinyEWD.txt"));
        GraphArt graphArt = new GraphArt();
        //usage example by providing graph object, and notifying GraphArt about method names
        graphArt.drawGraph(ewd);
        graphArt.setFileType("jpg");
        graphArt.drawGraph(ewdd);
        graphArt.setFileType("gif");
        graphArt.setAdjacentVerticesMethodName("susjedi");
        graphArt.setNumberOfVerticesMethodName("brojCvorova");
        graphArt.drawGraph(d);
        graphArt.resetMethodNames();
        graphArt.setFileType("png");
        graphArt.drawGraph(g);
        //if your toString() or toDot() method returns proper dot representation of graph respectively
        graphArt.drawGraph(g.toString())
        graphArt.drawGraph(g.toDot())
        //to draw graph using online service
        graphArt.drawInBrowser(ewd);
    }
}
```