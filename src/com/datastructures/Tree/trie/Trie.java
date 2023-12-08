package com.datastructures.Tree.trie;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 04/12/23
 */
public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
		System.out.println("Trie has been created");
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("API");
		trie.insert("APIS");
		trie.insert("AIS");
		trie.search("AI");
		trie.search("A");
		trie.search("AIS");
		trie.search("jf");
		trie.delete("API");
		trie.search("API");
	}

	void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfString = true;
		System.out.println("Successfully inserted " + word + " in trie");
	}

	boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				System.out.println("Word is not exits in Trie " + word);
				return false;
			}
			current = node;
		}
		return current.endOfString;
	}

	private boolean delete(TrieNode parentNode, String word, int index) {
		char ch = word.charAt(index);
		TrieNode currentNode = parentNode.children.get(ch);
		boolean canThisNodeBeDeleted;

		if (currentNode.children.size() > 1) {
			delete(currentNode, word, index + 1);
			return false;
		}
		if (index == word.length() - 1) {
			if (currentNode.children.size() >= 1) {
				currentNode.endOfString = false;
				return false;
			} else {
				parentNode.children.remove(ch);
				return true;
			}
		}
		if (currentNode.endOfString) {
			delete(currentNode, word, index);
			return false;
		}
		canThisNodeBeDeleted = delete(currentNode, word, index + 1);
		if (canThisNodeBeDeleted) {
			parentNode.children.remove(ch);
			return true;
		} else {
			return false;
		}
	}

	public void delete(String word) {
		boolean s = search(word);
		if (s) {
			delete(root, word, 0);
		}
	}

}
