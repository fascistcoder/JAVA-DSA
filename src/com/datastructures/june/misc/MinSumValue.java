package com.datastructures.june.misc;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 20/06/22
 */
public class MinSumValue {
	static int smallestSumSubarray(int[] a, int size) {
		// your code here
		int min = Integer.MAX_VALUE;
		int sum = 0;

		for (int num : a) {
			sum += num;
			if (sum > num) {
				sum = num;
			}
			min = Math.min(sum, min);
		}
		return min;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 3, -4, 2, -3, -1, 7, -5 };
		System.out.println(smallestSumSubarray(a, a.length));
	}

	/*
	int calc(Node *list) {
    if (list == nullptr) return 1;
    int newCarry = calc(list->next);
    int dig = list->digit + newCarry;
    list->digit = dig % 10;
    return dig/10;
}

void addOne(List* list) {
    //first add 1 to the last node and propagate the carry to recursion calls
    int carry = calc(list->first);
    if (carry) {
        Node *t = new Node(carry, list->first);
        list->first = t;
    }
	 */
}
