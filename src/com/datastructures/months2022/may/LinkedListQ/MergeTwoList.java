package com.datastructures.months2022.may.LinkedListQ;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 30/05/22
 */
public class MergeTwoList {
	public MiddleNode.ListNode mergeTwoLists(MiddleNode.ListNode  list1, MiddleNode.ListNode  list2) {


		MiddleNode.ListNode ptr = list1;

		if(list1.val > list2.val){
			ptr = list2;
			list2 = list2.next;
		}else {
			list1 = list1.next;
		}

		MiddleNode.ListNode merge = ptr;
		while (list1!=null && list2!=null){
			if(list1.val < list2.val){
				merge.next = list1;
				list1 = list1.next;
			} else {
				merge .next= list2;
				list2 = list2.next;
			}

			merge = merge.next;
		}

		while (list1!=null){
			merge.next = list1;
			merge = merge.next;
			list1 = list1.next;
		}

		while (list2!=null){
			merge.next = list2;
			merge = merge.next;
			list2 = list2.next;
		}


		return ptr;
	}
}
