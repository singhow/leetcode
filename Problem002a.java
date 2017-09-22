
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode head = result;
		int carry = 0;
		int value = 0;
		
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				value = l2.val + carry;
				l2 = l2.next;
			}
			else if (l2 == null) {
				value = l1.val + carry;
				l1 = l1.next;
			}
			else {
				value = l1.val + l2.val + carry;
				l1 = l1.next;
				l2 = l2.next;
			}
			
			if (value < 10) {
				carry = 0;
			}
			else {
				carry = 1;
				value = value - 10;
			}
			
			result.val = value;
			
			if (l1 != null || l2 != null) {
				result.next = new ListNode(0);
				result = result.next;
			}			
		}
		
		if (carry == 1)
			result.next = new ListNode(1);
		
		return head;
	}
}

public class Problem002a {
	public static void print(ListNode l) {
		while (l != null) {
			System.out.print(l.val + " -> ");
			l = l.next;
		}
		
		System.out.print("null\n");
	}
	
	public static void main(String args[]) {
		Solution solution = new Solution();
		
		ListNode l1 = new ListNode(8);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		print(l1);
		
		ListNode l2 = new ListNode(2);
		//l2.next = new ListNode(2);
		print(l2);
		
		ListNode result = solution.addTwoNumbers(l1, l2);
		print(result);
	}	
}
