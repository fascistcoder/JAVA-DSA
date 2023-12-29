package com.datastructures.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 08/12/23
 */
public class GraphLinkedList {
	ArrayList<GraphNodeLink> nodeLinkedList;

	public GraphLinkedList(ArrayList<GraphNodeLink> nodeLinkedList) {
		this.nodeLinkedList = nodeLinkedList;
	}

	public void addUndirectedEdge(int i, int j) {
		GraphNodeLink first = nodeLinkedList.get(i);
		GraphNodeLink second = nodeLinkedList.get(j);
		first.neighbors.add(second);
		second.neighbors.add(first);
	}

	public static void main(String[] args) {
		ArrayList<GraphNodeLink> graphNodeArrayList = new ArrayList<>();
		graphNodeArrayList.add(new GraphNodeLink("A", 0));
		graphNodeArrayList.add(new GraphNodeLink("B", 1));
		graphNodeArrayList.add(new GraphNodeLink("C", 2));
		graphNodeArrayList.add(new GraphNodeLink("D", 3));
		graphNodeArrayList.add(new GraphNodeLink("E", 4));
		graphNodeArrayList.add(new GraphNodeLink("F", 5));
		graphNodeArrayList.add(new GraphNodeLink("G", 6));
		graphNodeArrayList.add(new GraphNodeLink("H", 7));

//		GraphLinkedList graph = new GraphLinkedList(graphNodeArrayList);
//		graph.addUndirectedEdge(0, 1);
//		graph.addUndirectedEdge(0, 2);
//		graph.addUndirectedEdge(0, 3);
//		graph.addUndirectedEdge(1, 4);
//		graph.addUndirectedEdge(2, 3);
//		graph.addUndirectedEdge(3, 4);

		GraphLinkedList graph1 = new GraphLinkedList(graphNodeArrayList);
		graph1.addDirectEdge(0, 2);
		graph1.addDirectEdge(2, 4);
		graph1.addDirectEdge(4, 7);
		graph1.addDirectEdge(4, 5);
		graph1.addDirectEdge(5, 6);
		graph1.addDirectEdge(1, 2);
		graph1.addDirectEdge(1, 3);
		graph1.addDirectEdge(3, 5);

//		System.out.println(graph.toString());
		System.out.println(graph1.toString());
		graph1.topologicalSort();

		graph1.bfs();
		graph1.dfs();
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (GraphNodeLink graphNodeLink : nodeLinkedList) {
			stringBuilder.append(graphNodeLink.name).append(": ");
			for (int j = 0; j < graphNodeLink.neighbors.size(); j++) {
				if (j == graphNodeLink.neighbors.size() - 1) {
					stringBuilder.append((graphNodeLink.neighbors.get(j).name));
				} else {
					stringBuilder.append(graphNodeLink.neighbors.get(j).name).append(" -> ");
				}
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	void bfsVisit(GraphNodeLink node) {
		LinkedList<GraphNodeLink> graphNodeQueue = new LinkedList<>();
		graphNodeQueue.add(node);
		while (!graphNodeQueue.isEmpty()) {
			GraphNodeLink currentNode = graphNodeQueue.remove();
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");
			ArrayList<GraphNodeLink> neighbours = currentNode.neighbors;
			for (GraphNodeLink neighbour : neighbours) {
				if (!neighbour.isVisited) {
					graphNodeQueue.add(neighbour);
					neighbour.isVisited = true;
				}
			}
		}
	}

	void bfs() {
		for (GraphNodeLink node : nodeLinkedList) {
			if (!node.isVisited) {
				bfsVisit(node);
			}

		}
	}

	void dfsVisit(GraphNodeLink node) {
		Stack<GraphNodeLink> graphNodeLinkStack = new Stack<>();
		graphNodeLinkStack.push(node);
		while (!graphNodeLinkStack.isEmpty()) {
			GraphNodeLink currentNode = graphNodeLinkStack.pop();
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");
			for (GraphNodeLink neighbor : currentNode.neighbors) {
				if (!neighbor.isVisited) {
					graphNodeLinkStack.push(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
	}

	void dfs() {
		for (GraphNodeLink node : nodeLinkedList) {
			if (!node.isVisited) {
				dfsVisit(node);
			}
		}
	}

	 void addDirectEdge(int i, int j){
		 GraphNodeLink first = nodeLinkedList.get(i);
		 GraphNodeLink second = nodeLinkedList.get(j);
		 first.neighbors.add(second);
	 }

	void topologicalVisit(GraphNodeLink node, Stack<GraphNodeLink>stack){
		for (GraphNodeLink neighbour : node.neighbors) {
			if (!neighbour.isVisited) {
				topologicalVisit(neighbour, stack);
			}
		}
		node.isVisited = true;
		stack.push(node);
	}

	void topologicalSort(){
		Stack<GraphNodeLink> stack = new Stack<>();
		for(GraphNodeLink node : nodeLinkedList){
			if(!node.isVisited){
				topologicalVisit(node, stack);
			}
		}

		while (!stack.isEmpty()){
			System.out.print(stack.pop().name + " ");
		}
	}
}