package algorithms;

public class LinkedList {
	class ListNode{
		String data;
		ListNode link;
	}
	
	public ListNode head;
	
	public void addNodeFirst(String x) {	//add newNode LinkedList's first
		ListNode newNode = new ListNode();
		newNode.data = x;
		newNode.link = head;
		head = newNode;
	}
	
	public void addNodeLast(String x) {		//add newNode LinkedList's last
		ListNode newNode = new ListNode();
		newNode.data = x;
		newNode.link = null;
		
		if(head == null) {
			head = newNode;
			return;
		}else {
			ListNode p = head;
			while(p.link != null) {
				p = p.link;
			}
			p.link = newNode;
		}
	}
	
	public void insertNode(ListNode p, String x) {		//add newNode behind ListNode p
		ListNode newNode = new ListNode();
		newNode.data = x;
		
		if(head == null) {
			head = newNode;
			newNode.link = null;
		}else {
			newNode.link = null;
			p.link = newNode;
		}
	}
	
}
