package csd;

class Node {
	
	protected int info;
	protected Node next;

	Node(int x, Node n){
		this.info = x;
		this.next = n;
	}
	Node(int x){
		this(x, null);
	}
}

class Test {
	void addMany(int [] a){
		for(int i=0; i<a.length; i++) 
		   addLast(a[i]);
	}
	void addLast(int x){
		Node q = new Node(x);
	    if(isEmpty()) {
	    	head=tail=q;
	    	return;
	    }
	    tail.next=q;
	    tail=q;
	}
	Node head, tail;
	Test(){
		head = tail = null;
	}
	boolean isEmpty() {
		return head==null;
	}
	void addToHead(int x) {
		Node no = new Node(x, head);
		head = no;
		if (tail == null)
			tail = head;
	}
	void addToTail(int x) {
		Node nod = new Node(x);
		if (isEmpty()) {
			head = tail;
			return;
		}
		tail.next = nod;
		tail = nod;
	}
	void addAfter(Node p, int x) {
		Node q = new Node(x);
		q.next = p.next;
		p.next = q;
	}
	void traverse() {
		Node p = head;
		while (p != null) {
			System.out.print(p.info + "  ");
			p = p.next;
		}
	}
	int deleteFromHead() {
		int in = head.info;
		if (head == tail) {
			head = tail = null;
		}
		else head = head.next;
		return in;
	}
	int deleteFromTail() {
		int in = tail.info;
		if (head == tail) {
			head = tail = null;
		}
		else {
			Node tg;
			for (tg = head; tg.next != null; tg = tg.next)
				tail = tg;
			tail.next = null;
		}
		return in;
	}
	int deleteAfter(Node p) {
		Node tg = head;
		int inf = 0;
		while (tg != null) {
			if (tg.next == p.next) {
				inf = p.next.info;
				tg.next = tg.next.next;
			}
			tg = tg.next;
		}
		return inf;
	}
	void dele(int x) {
		if (head.info == x)
			head = head.next;
	}
	boolean search(int x) {
		while(head != null) {
			if (head.info == x)
				return true;
			head = head.next;
		}
		return false;
	}
	int count() {
		int c = 1;
		Node tg = head.next;
		while (tg != null) {
			c++;
			tg = tg.next;
		}
		return c;
	}
	void delete(final int x) {
		Node tg = head;
		while ( tg.next != null) {
			if ( tg.next.info == x )
				tg.next = tg.next.next;
			tg = tg.next;
		}
	}
	void sort(){
		Node pi,pj; int t;
	    pi=head;
	    while(pi!=null){
	    	pj=pi.next;
	    	while(pj!=null){
	    		if(pj.info<pi.info){
	    			t=pi.info;
	    			pi.info=pj.info;
	    			pj.info=t;
	    		} 
	        pj=pj.next;
	    	}
	    pi=pi.next;
	    }
	}
}

public class csd{
	public static void main(String [] args){
		Test t = new Test();
		int []a = {7,2,9,8,6,3};
		t.addMany(a);
		t.traverse();
		
		System.out.println("\nAdd to head : ");
		t.addToHead(11);
		t.traverse();
		
		System.out.println("\nAdd to tail : ");
		t.addToTail(19);
		t.traverse();
		
		System.out.println("\nDelete from head : ");
		t.deleteFromHead();
		t.traverse();
		
		System.out.println("\nDelete from tail : ");
		t.deleteFromTail();
		t.traverse();
		
		System.out.println("\nDelete number : ");
		t.delete(6);
		t.traverse();
		
		System.out.print("\nLength : " + t.count());
		
		System.out.println("\nSort the array : ");
		t.sort();
		t.traverse();
		
		System.out.println("\nAdd after : ");
		t.addAfter(t.head.next, 7);
		t.traverse();
		
		System.out.println("\nDelete after : ");
		t.deleteAfter(t.head.next.next);
		t.traverse();
		
		System.out.println("\nSearch : (6) - " + t.search(6));
		System.out.println();  	
  }
}