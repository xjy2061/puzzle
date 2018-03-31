package org.xjy.java.puzzle;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *     }
 * }
 */
public class AddTwoNumbers {

	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode n1 = l1;
		ListNode n2 = l2;
		int carry = 0;
		ListNode head = null;
		ListNode current = null;
		while (n1 != null || n2 != null) {
			int val1 = n1 != null ? n1.val : 0;
			int val2 = n2 != null ? n2.val : 0;
			int sum = val1 + val2 + carry;
			if (sum >= 10) {
				sum = sum % 10;
				carry = 1;
			} else {
				carry = 0;
			}
			if (head == null) {
				head = new ListNode(sum);
				current = head;
			} else {
				current.next = new ListNode(sum);
				current = current.next;
			}
			n1 = n1 != null ? n1.next : null;
			n2 = n2 != null ? n2.next : null;
		}
		if (carry > 0) {
			current.next = new ListNode(carry);
		}
		return head;
	}

	private static ListNode createNumber(int[] digits) {
		ListNode head = null;
		ListNode tail = null;
		for (int digit : digits) {
			if (head == null) {
				head = new ListNode(digit);
				tail = head;
			} else {
				tail.next = new ListNode(digit);
				tail = tail.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode sum = addTwoNumbers(createNumber(new int[] { 2, 4, 3 }), createNumber(new int[] { 5, 6, 4 }));
		StringBuilder sb = new StringBuilder();
		boolean head = true;
		while (sum != null) {
			if (head) {
				sb.append(sum.val);
				head = false;
			} else {
				sb.append(" -> ").append(sum.val);
			}
			sum = sum.next;
		}
		System.out.println(sb.toString());
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}