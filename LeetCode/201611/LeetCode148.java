package edu.ustc.shshen.LeetCode.y2016m11;

/**
 * @Title: LeetCode148
 * @Description: 归并排序  O(n*lgn)
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年11月24日下午10:52:23*/
public class LeetCode148 {
	public ListNode sortList(ListNode head) {
		return split(head);
    }
	
	public ListNode split(ListNode head){
		ListNode slow = head,quick = head;
		if(head == null || head.next == null) return head;
		
		while(quick.next != null && quick.next.next != null){
			slow = slow.next;
			quick = quick.next.next;
		}
		quick = slow.next;
		slow.next = null;
		
		return MergeSort(split(head), split(quick));
	}
	
	public ListNode MergeSort(ListNode l,ListNode r){
		ListNode newfirst = null,first = null;
		if(l.val < r.val){
			newfirst = first = l;
			l = l.next;
		}else {
			newfirst = first = r;
			r = r.next;
		}
		
		while(l != null && r != null){
			if(l.val < r.val){
				newfirst.next = l;
				newfirst = newfirst.next;
				l = l.next;
			}else{
				newfirst.next = r;
				newfirst = newfirst.next;
				r = r.next;
			}
		}
		
		while(l != null){
			newfirst.next = l;
			newfirst = newfirst.next;
			l = l.next;
		}
		
		while(r != null){
			newfirst.next = r;
			newfirst = newfirst.next;
			r = r.next;
		}
		
		return first;
	}
}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}