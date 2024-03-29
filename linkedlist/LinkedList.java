/*********************************************
 * @author Vikas Kumar
 * @Email  itvika@gmail.com
 * @Phone  9868366690
 * @LinkedIn https://linkedin.com/in/itvika/
 * This is a  custom linkedlist implementation
 * List of Functions
 * 1.	LinkedList insertList(LinkedList list,int data)
 * 2.	LinkedList insertAfterKey(LinkedList list,int data,int key)
 * 3.	LinkedList insertAtStart(LinkedList list,int data)
 * 4.	void findMidElement(LinkedList list)
 * 5.	LinkedList deleteByKey(LinkedList list,int key)
 * 6.	void printList(LinkedList list)
 */
package linkedlist;
public class LinkedList{
	Node head;
	static class Node{
		int data;
		Node next;
		public Node(int d) {
			this.data=d;
			this.next=null;
		}
	}
	
	LinkedList(){
		head=null;
	}
	LinkedList insertList(LinkedList list,int data) {
		Node new_node=new Node(data);
		if(list.head==null) {
			list.head=new_node;
			
		}else {
			Node current_node=list.head;
			while(current_node.next!=null) {
				current_node=current_node.next;
				
			}
			current_node.next=new_node;
		}
		return list;
	}
	LinkedList insertAfterKey(LinkedList list,int data,int key) {
		Node new_node=new Node(data);
		Node curr_node=list.head;
		while(curr_node!=null) {
			if(curr_node.data==key) {
				new_node.next=curr_node.next;
				curr_node.next=new_node;
				break;
			}
			curr_node=curr_node.next;
		}
		return list;
	}
	LinkedList insertAtStart(LinkedList list,int data) {
		Node new_node=new Node(data);
		new_node.next=list.head;
		list.head=new_node;
		return list;
	}
	LinkedList insertByPos(LinkedList list,int data,int pos) {
		Node new_node=new Node(data);
		Node curr_node=list.head;
		if(pos==0) {
			
			new_node.next=list.head;
			list.head=new_node;
		}else {
			int count=0;
			while(curr_node!=null) {
				if(count==pos-1) {
					new_node.next=curr_node.next;
					curr_node.next=new_node;
					break;
				}
				count++;
				curr_node=curr_node.next;
			}
		}
		return list;
	}
	LinkedList deleteByKey(LinkedList list,int key) {
		if(list.head.data==key) {
			list.head=list.head.next;
		}else {
			Node curr_node=list.head;
			Node pre_node=null;
			while(curr_node!=null) {
				if(curr_node.data==key) {
					pre_node.next=curr_node.next;
					break;
				}
				pre_node=curr_node;
				curr_node=curr_node.next;
			}
		}
		return list;
	}
	void findMidElement(LinkedList list) {
		Node slow_ptr=list.head;
		Node fast_ptr=list.head;
		while(fast_ptr!=null && fast_ptr.next!=null) {
			slow_ptr=slow_ptr.next;
			
			fast_ptr=fast_ptr.next.next;
			
		}
		
		System.out.println("Middle node is :"+slow_ptr.data);
	}
	
	void printList(LinkedList list) {
		Node current_node=list.head;
		while(current_node!=null) {
			System.out.println(current_node.data);
			current_node=current_node.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list=list.insertList(list,10);
		list=list.insertList(list,20);
		list=list.insertList(list,30);
		list=list.insertList(list,40);
		list=list.insertList(list,50);
		System.out.println("=====LIST======");
		list.printList(list);
		list=list.insertAtStart(list,8);
		System.out.println("=====After Insert at begin======");
		list.printList(list);
		System.out.println("=====After Insert at 20======");
		list=list.insertAfterKey(list,2,30);
		list=list.insertAfterKey(list,100,50);
		list=list.insertAfterKey(list,7,8);
		list.printList(list);
		System.out.println("=====After 1st post======");
		list=list.insertByPos(list,120,2);
		list.printList(list);
		System.out.println("=====Delete by Value======");
		list=list.deleteByKey(list,50);
		//list=list.deleteByKey(list,20);
		list.printList(list);
		list.findMidElement(list);
		
		
	}
	
}