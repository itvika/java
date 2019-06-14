/*********************************************
 * @author Vikas Kumar
 * @Email  itvika@gmail.com
 * @Phone  9868366690
 * @LinkedIn https://linkedin.com/in/itvika/
 * This is a non-generic custom linked list implementation
 * List of Functions
 * 1.	void addFirst(T v)
 * 2.	void add(T v)
 * 3.	void addLast(T v)
 * 4.	void removeFirst(T v)
 * 5.	void removeLast(T v)
 * 6.	void remove(T v)
 * 7.	void removeAll()
 * 8.	int size()
 * 9.	T findMid()
 * 10.	boolean contains(T v)
 * 11.	LinkedListA<T> clone()
 * 12.	void print()
 * 13.	void add(int pos,T v)
 */

package linkedlist;

public class LinkedListA<T> {
	//Node class 
	static class Node<T>{
		T data;
		Node<T> next;
		//Constructor of Node class
		public Node(T d){
			this.data=d;
			this.next=null;
		}
		
	}
	
	//Initialization of head of link list
	Node<T> head;
	
	//LinkedListA Constructor
	public LinkedListA(){
		head=null;
	}
	
	//Add element at beginning of the link list
	public void addFirst(T v) {
		Node<T> new_node=new Node<T>(v);
		if(this.head==null) {
			this.head=new_node;
		}
		else {
			new_node.next=this.head;
			this.head=new_node;
		}
	}
	
	//Add element at the end of the link list
	public void add(T v) {
		Node<T> new_node=new Node<T>(v);
		if(this.head==null) {
			addFirst(v);
		}else {
			Node<T> current_node=this.head;
			while(current_node.next!=null) {
				current_node=current_node.next;
			}
			current_node.next=new_node;
		}
		
	}
	//Add element at specified position in the link list
	public void add(int pos,T v) {
		if(pos==0) {
			addFirst(v);
		}else {
			int c=1;
			Node<T> new_node=new Node<T>(v);
			Node<T> current_node=this.head;
			
			while(current_node.next!=null) {
				if(c==pos) {
					new_node.next=current_node.next;
					current_node.next=new_node;
					break;
				}
				
				current_node=current_node.next;
				c++;
			}
			current_node.next=new_node;
		}
	}
	
	//Add element at the end of the link list
	public void addLast(T v) {
		add(v);
	}
	
	//Remove first element from the link list
	public void removeFirst(T v) {
		this.head=this.head.next;
	}
	
	//Remove last element from the link list
	public void removeLast(T v) {
		this.remove(v);
	}
	
	//Remove element by value from the link list
	public void remove(T v) {
		Node<T> current_node=this.head;
		Node<T> prev_node=null;
		int c=0;
		while(current_node!=null) {
			if(c==0 && current_node.data==v) {
				this.removeFirst(v);
				break;
			}
			else if(current_node.data==v) {
				prev_node.next=current_node.next;
			}
			prev_node=current_node;
			current_node=current_node.next;
			c++;
			
		}
	}
	
	//Remove all elements of the link list
	public void removeAll() {
		this.head=null;
		
	}
	//Get size of the link list
	public int size() {
		
		int c=0;
		if(this.head==null) {
			return c;
		}else {
			Node<T> current_node=this.head;
			while(current_node!=null) {
				c++;
				current_node=current_node.next;
			}
			
		}
		
		return c;
	}
	
	//Find middle element of the link list
	public T findMid() {
		Node<T> fast_node=this.head;
		Node<T> slow_node=this.head;
		T mid=null;
		while(slow_node.next!=null && fast_node.next.next!=null) {
			//System.out.println("=====999");
			mid=slow_node.next.data;
			slow_node=slow_node.next;
			fast_node=fast_node.next.next;
			
			if(fast_node.next==null) {
				break;
			}
		}
		return mid;
	}
	
	//Check whether the link list contains a specific element
	public boolean contains(T v) {
		
		if(this.head==null) {
			return false;
		}else {
			Node<T> current_node=this.head;
			while(current_node!=null) {
				if(current_node.data==v)
					return true;
				current_node=current_node.next;
			}
			
		}
		
		return false;
	}
	
	//Custom clone implementation
	public LinkedListA<T> clone() {
		LinkedListA<T> list_new=new LinkedListA<T>();
		Node<T> current_node=this.head;
		while(current_node!=null) {
			list_new.add(current_node.data);
			current_node=current_node.next;
		}
		
		return list_new;
	}
	
	//Print each element of the list
	public void print() {
		Node<T> current_node=this.head;
		while(current_node!=null) {
			
			System.out.println(current_node.data);
			current_node=current_node.next;
		}
	}

	
	public static void main(String[] args) {
		LinkedListA<Integer> list=new LinkedListA<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.addLast(40);
		list.addFirst(5);
		list.add(0,2);
		list.add(2,8);
		list.add(50);
		//list.removeAll();
		list.print();
		list.remove(2);
		list.remove(50);
		System.out.println("===LIST1=====");
		list.print();
		System.out.println("===LIST2=====");
		LinkedListA<Integer> list1=new LinkedListA<Integer>();
		list1=list.clone();
		list1.addLast(400);  
		list1.print();
		
		System.out.println("===LIST1=====");
		list.print();
		System.out.println(list.contains(2));
		System.out.println(list.contains(40));
		System.out.println(list.contains(10));
		System.out.println(list.contains(1000));
		System.out.println("=================");
		
		System.out.println(list.size());
		System.out.println(list.findMid());
		
		

	}

}
