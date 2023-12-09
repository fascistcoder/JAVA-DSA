package com.datastructures.Graphs;

import java.util.ArrayList;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 08/12/23
 */
public class GraphNodeLink {
	public String name;
	public int index;
	public boolean isVisited = false;
	public ArrayList<GraphNodeLink> neighbors = new ArrayList<>();

	public GraphNodeLink(String name, int index) {
		this.name = name;
		this.index = index;
	}

}
