package edu.ustc.shshen.LeetCode._201612;

/**
 * @Title: LeetCode61
 * @Description: 嗯...为什么会有这种题
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年12月2日下午2:50:14*/
public class LeetCode61 {
	
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
		ListNode vail = head;
        int length = 1;
        while(vail.next != null)
        {
        	vail = vail.next;
        	length++;
        }
        vail.next = head;
        ListNode newhead;
        for(int i = 0;i < length-k%length-1;i++){
        	head = head.next;
        }
        newhead = head.next;
        head.next = null;
        return newhead;
    }
}

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }