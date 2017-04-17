package org.xjy.java.puzzle;

import java.util.HashMap;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example, 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val; 
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthNodeFromEndOfList {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		for (int i = 0; i <= n; i++) {
			first = first.next;
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}

	public static ListNode removeNthFromEndStraightly(ListNode head, int n) {
		HashMap<Integer, ListNode> map = new HashMap<>();
		int i = 0;
		ListNode current = head;
		while (current != null) {
			map.put(i++, current);
			current = current.next;
		}
		int size = map.size();
		i = size - n;
		if (i == 0)
			return head.next;
		if (i == size - 1) {
			map.get(i - 1).next = null;
		} else {
			map.get(i - 1).next = map.get(i).next;
		}
		return head;
	}

	private static void printListNode(ListNode head) {
		StringBuilder sb = new StringBuilder();
		boolean isHead = true;
		while (head != null) {
			if (isHead) {
				sb.append(head.val);
				isHead = false;
			} else {
				sb.append(" -> ");
				sb.append(head.val);
			}
			head = head.next;
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode tail = head;
		for (int i = 2; i <= 5; i++) {
			tail.next = new ListNode(i);
			tail = tail.next;
		}
		printListNode(head);
		head = removeNthFromEnd(head, 2);
		printListNode(head);
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
}
