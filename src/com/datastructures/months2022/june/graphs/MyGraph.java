package com.datastructures.months2022.june.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 09/06/22
 */
public class MyGraph {
	// Edge List
	//int[][] graph = new int[][]{{0,2}, {2,3}};

	//Adjacent List

	//Adjacent Matrix
	//int[][] getGraph = new int[][]{{0,0,1,0}, {0,0,1,1}, {1,1,0,1}, {0,1,1,0}};

	private HashMap<Integer, List<Integer>> adjacentList;
	private int numberOfNodes;

	public MyGraph() {
		adjacentList = new HashMap<>();
		numberOfNodes = 0;
	}

	public void addNode(int value) {
		adjacentList.put(value, new ArrayList<>());
		numberOfNodes++;
	}

	public void addEdge(int value1, int value2){
		adjacentList.get(value1).add(value2);
		adjacentList.get(value2).add(value1);
	}

	public void showConnections() {
		Set<Integer> keys = adjacentList.keySet();
		for (int node : keys) {
			List<Integer> nodeConnections = adjacentList.get(node);
			StringBuilder sb = new StringBuilder();
			for (int edge : nodeConnections) {
				sb.append(edge).append(" ");
			}
			System.out.println(node + "---->" + sb);
		}
	}

	public static void main(String[] args) {
		MyGraph graph = new MyGraph();
		graph.addNode(0);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addNode(6);
		graph.addEdge(3, 1);
		graph.addEdge(3, 4);
		graph.addEdge(4, 2);
		graph.addEdge(4, 5);
		graph.addEdge(1, 2);
		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(6, 5);
		graph.showConnections();
	}
}
