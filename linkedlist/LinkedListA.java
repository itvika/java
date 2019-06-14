package linkedlist;

public class LinkedListA<T> {
	static class Node<T>{
		T data;
		Node<T> next;
		public Node(T d){
			this.data=d;
			this.next=null;
		}
		
	}
	
	Node<T> head;
	public LinkedListA(){
		head=null;
	}
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
	public void addLast(T v) {
		add(v);
	}
	
	public void removeFirst(T v) {
		this.head=this.head.next;
	}
	public void removeLast(T v) {
		this.remove(v);
	}
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
	
	
	public void removeAll() {
		this.head=null;
		
	}
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
	public LinkedListA<T> clone() {
		LinkedListA<T> list_new=new LinkedListA<T>();
		Node<T> current_node=this.head;
		while(current_node!=null) {
			list_new.add(current_node.data);
			current_node=current_node.next;
		}
		
		return list_new;
	}
	
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
