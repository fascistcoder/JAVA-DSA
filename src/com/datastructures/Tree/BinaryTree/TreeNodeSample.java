package com.datastructures.Tree.BinaryTree;

import java.util.ArrayList;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 30/11/23
 */
public class TreeNodeSample {
	String data;
	ArrayList<TreeNodeSample> children;

	public TreeNodeSample(String data) {
		this.data = data;
		this.children = new ArrayList<>();
	}

	public static void main(String[] args) {
		TreeNodeSample drinks = new TreeNodeSample("Drinks");
		TreeNodeSample hot = new TreeNodeSample("hot");
		TreeNodeSample cold= new TreeNodeSample("Cold");
		drinks.addChild(hot);
		drinks.addChild(cold);
		System.out.println(drinks.print(0));
	}

	public void addChild(TreeNodeSample node) {
		this.children.add(node);
	}

	public String print(int level) {
		StringBuilder ret;
		ret = new StringBuilder(" ".repeat(level) + data + "\n");
		for (TreeNodeSample node : this.children) {
			ret.append(node.print(level + 1));
		}
		return ret.toString();
	}
}

