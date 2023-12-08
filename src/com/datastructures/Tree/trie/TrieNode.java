package com.datastructures.Tree.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 04/12/23
 */
public class TrieNode {
	Map<Character, TrieNode> children;
	boolean endOfString;

	public TrieNode(){
		children = new HashMap<>();
		endOfString = false;
	}
}
