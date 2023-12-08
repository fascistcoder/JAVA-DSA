package com.datastructures.months2022.may.LinkedListQ;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 02/06/22
 */
public class SortLinkedList {
	public RemoveLoopInLinkedList.Node sort(RemoveLoopInLinkedList.Node head){
		//your code here, return the head of the sorted list

		RemoveLoopInLinkedList.Node temp = head;

		ArrayList<Integer> arrayList =new ArrayList<>();

		while (temp!=null){
			arrayList.add(temp.data);
			temp = temp.next;
		}

		Collections.sort(arrayList);

		RemoveLoopInLinkedList.Node t = null;

		for(int i = arrayList.size() - 1; i >= 0; i--){
			RemoveLoopInLinkedList.Node newNode = new RemoveLoopInLinkedList.Node(arrayList.get(i));
			newNode.next = t;
			t = newNode;

		}

		return t;
	}
}
