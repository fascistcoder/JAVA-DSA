package com.datastructures.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 08/12/23
 */
public class Graph {
	ArrayList<GraphNode> nodeArrayList = new ArrayList<>();
	int[][] adjacencyMatrix;

	public Graph(ArrayList<GraphNode> nodeArrayList) {
		this.nodeArrayList = nodeArrayList;
		adjacencyMatrix = new int[nodeArrayList.size()][nodeArrayList.size()];
	}

	public void addUndirectedEdge(int i, int j) {
		adjacencyMatrix[i][j] = 1;
		adjacencyMatrix[j][i] = 1;
	}

	public static void main(String[] args) {
		ArrayList<GraphNode> graphNodeArrayList = new ArrayList<>();
		graphNodeArrayList.add(new GraphNode("A", 0));
		graphNodeArrayList.add(new GraphNode("B", 1));
		graphNodeArrayList.add(new GraphNode("C", 2));
		graphNodeArrayList.add(new GraphNode("D", 3));
		graphNodeArrayList.add(new GraphNode("E", 4));
		graphNodeArrayList.add(new GraphNode("F", 5));
		graphNodeArrayList.add(new GraphNode("G", 6));
		graphNodeArrayList.add(new GraphNode("H", 7));

//		Graph graph = new Graph(graphNodeArrayList);
//		graph.addUndirectedEdge(0, 1);
//		graph.addUndirectedEdge(0, 2);
//		graph.addUndirectedEdge(0, 3);
//		graph.addUndirectedEdge(1, 4);
//		graph.addUndirectedEdge(2, 3);
//		graph.addUndirectedEdge(3, 4);
//
//		System.out.println(graph.toString());

		Graph graph1 = new Graph(graphNodeArrayList);
		graph1.addDirectEdge(0, 2);
		graph1.addDirectEdge(2, 4);
		graph1.addDirectEdge(4, 7);
		graph1.addDirectEdge(4, 5);
		graph1.addDirectEdge(5, 6);
		graph1.addDirectEdge(1, 2);
		graph1.addDirectEdge(1, 3);
		graph1.addDirectEdge(3, 5);

		System.out.println(graph1.toString());
		graph1.topologicalSort();

		graph1.bfs();
		graph1.dfs();

	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("   ");
		for (GraphNode graphNode : nodeArrayList) {
			stringBuilder.append(graphNode.name).append(" ");
		}
		stringBuilder.append("\n");
		for (int i = 0; i < nodeArrayList.size(); i++) {
			stringBuilder.append(nodeArrayList.get(i).name).append(": ");
			for (int j : adjacencyMatrix[i]) {
				stringBuilder.append(j).append(" ");
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	ArrayList<GraphNode> getNeighbors(GraphNode node) {
		ArrayList<GraphNode> neighbors = new ArrayList<>();
		int nodeIndex = node.index;
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[nodeIndex][i] == 1) {
				neighbors.add(nodeArrayList.get(i));
			}
		}
		return neighbors;
	}

	void bfsVisit(GraphNode node) {
		LinkedList<GraphNode> graphNodeQueue = new LinkedList<>();
		graphNodeQueue.add(node);
		while (!graphNodeQueue.isEmpty()) {
			GraphNode currentNode = graphNodeQueue.remove();
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");
			ArrayList<GraphNode> neighbours = getNeighbors(currentNode);
			for (GraphNode neighbour : neighbours) {
				if (!neighbour.isVisited) {
					graphNodeQueue.add(neighbour);
					neighbour.isVisited = true;
				}
			}
		}
	}

	void bfs() {
		for (GraphNode node : nodeArrayList) {
			if (!node.isVisited) {
				bfsVisit(node);
			}
		}
	}

	void dfsVisit(GraphNode node) {
		Stack<GraphNode> graphNodeStack = new Stack<>();
		graphNodeStack.push(node);
		while (!graphNodeStack.isEmpty()) {
			GraphNode currentNode = graphNodeStack.pop();
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");
			ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
			for (GraphNode neighbor : neighbors) {
				if (!neighbor.isVisited) {
					graphNodeStack.push(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
	}

	void dfs() {
		for (GraphNode node : nodeArrayList) {
			if (!node.isVisited) {
				dfsVisit(node);
			}
		}
	}

	//TODO Topological Sort
	public void addDirectEdge(int i, int j){
		adjacencyMatrix[i][j] = 1;
	}

	void topologicalVisit(GraphNode node, Stack<GraphNode>stack){
		ArrayList<GraphNode> neighbors = getNeighbors(node);
		for (GraphNode neighbour : neighbors) {
			if (!neighbour.isVisited) {
				topologicalVisit(neighbour, stack);
			}
		}
		node.isVisited = true;
		stack.push(node);
	}

	void topologicalSort(){
		Stack<GraphNode> stack = new Stack<>();
		for(GraphNode node : nodeArrayList){
			if(!node.isVisited){
				topologicalVisit(node, stack);
			}
		}

		while (!stack.isEmpty()){
			System.out.print(stack.pop().name + " ");
		}
	}
}
