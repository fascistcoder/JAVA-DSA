package com.datastructures.Stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 21/11/23
 */
public class StackPb {

	public static void main(String[] args) {
		StackPb stackPb = new StackPb();
		//	stackPb.reverseWords("i.like.this.program.very.much");
		//stackPb.firstUniqChar("abccbaacz");
		stackPb.asteroidCollision(new int[] { 5, 10, -5 });
		stackPb.asteroidCollision(new int[] { 5, -5 });
		stackPb.asteroidCollision(new int[] { -2, -1, 1, 2 });
		stackPb.asteroidCollision(new int[] { 8, -8, 10 });
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.empty()) {
					return false;
				} else {
					Character top = stack.pop();
					if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
						return false;
					}
				}
			}
		}
		return stack.empty();
	}

	String reverseWords(String S) {
		// your code here
		Stack<String> stack = new Stack<>();
		Stack<String> revStack = new Stack<>();
		String[] splitString = S.split("\\.");
		StringBuilder ans = null;

		for (String s : splitString) {
			stack.push(s);
		}

		for (int i = 0; i < splitString.length; i++) {
			String stackS = stack.pop();
			StringBuilder sb = new StringBuilder(stackS).reverse();
			String revS = sb.toString();
			revStack.push(revS);
		}

		for (int i = 0; i < splitString.length; i++) {
			String stackS = revStack.pop();
			if (ans == null) {
				ans = new StringBuilder(stackS).append(".");
			} else {
				ans.append(stackS).append(".");
			}
		}
		return (ans == null) ? null : ans.substring(0, ans.length() - 1);
	}

	public char firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		Queue<Character> characterQueue = new LinkedList<>();

		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
			characterQueue.offer(c);

			while (!characterQueue.isEmpty() && map.get(characterQueue.peek()) == 1) {
				characterQueue.poll();
			}
		}

		return characterQueue.peek();

	}

	public int[] asteroidCollision(int[] asteroids) {
		if (asteroids.length == 1) {
			return asteroids;
		}

		Stack<Integer> stack = new Stack<>();

		for (int asteroid : asteroids) {
			if (asteroid > 0) {
				stack.push(asteroid);
			} else {
				while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroid) > stack.peek()) {
					stack.pop();
				}

				if (stack.isEmpty() || stack.peek() < 0) {
					stack.push(asteroid);
				}

				if (stack.peek() == Math.abs(asteroid)) {
					stack.pop();
				}
			}
		}

		System.out.println(stack);
		int[] res = new int[stack.size()];

		for (int i = 0; i < res.length; i++) {
			res[i] = stack.pop();
		}

		return res;
	}

}
