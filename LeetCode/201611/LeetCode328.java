package edu.ustc.shshen.LeetCode.y2016m11;

public class LeetCode328 {
	public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
		ListNode hhead = head,ttail = head;
		ListNode p = null,pl = new ListNode(1000);
		
		int length = 1;
		while(ttail.next != null)
		{
			ttail = ttail.next;
			length++;
		}
		
		
		int i = 1;p=hhead;
		pl.next = p;
		while(i <= length){
			if (i%2 == 1) {
				i++;
				pl = p;
				p = p.next;
			}else {
				i++;
				pl.next = p.next;
				ttail.next = p;
				ttail = ttail.next;
				ttail.next = null;
				p = pl.next;
			}
		}
		return hhead;
    }
}

class ListNode {
	      Integer val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	      
	      @Override
	      public String toString(){
	    	  String result = val.toString();
	    	  while(next != null){
	    		  result +=","+next.val;
	    		  next = next.next;
	    	  }
	    	  return result;
	      }
	 }