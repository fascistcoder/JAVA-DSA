package com.datastructures.Graphs;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 08/12/23
 */
public class GraphNode {
	public String name;
	public int index;
	public boolean isVisited = false;

	public GraphNode(String name, int index) {
		this.name = name;
		this.index = index;
	}
}
