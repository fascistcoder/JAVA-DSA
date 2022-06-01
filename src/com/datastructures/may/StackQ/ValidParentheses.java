package com.datastructures.may.StackQ;

import java.util.Stack;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/06/22
 */
public class ValidParentheses {
	public static boolean isValid(String s) {
		Stack<Character> s1 = new Stack<>();

		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
				s1.push(s.charAt(i));
			}else{
				if(s1.empty()) {
					return false;
				}else {
					Character c = s1.peek();

					if(c == '(' && s.charAt(i) == ')' ||
							c == '{' && s.charAt(i) == '}' ||
							c == '[' && s.charAt(i) == ']'){
						s1.pop();
					}else {
						return false;
					}
				}
			}
		}
		return s1.empty();
	}

	public static void main(String[] args) {
	//	System.out.println(isValid("({[}]})"));
		//	System.out.println(isValid("(("));
			System.out.println(isValid("()"));
	}
}
