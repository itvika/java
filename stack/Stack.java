package stack;
/*********************************************
 * @author Vikas Kumar
 * @Email  itvika@gmail.com
 * @Phone  9868366690
 * @LinkedIn https://linkedin.com/in/itvika/
Output is :
10 item pushed to statck at 0
20 item pushed to statck at 1
30 item pushed to statck at 2
40 item pushed to statck at 3
50 item pushed to statck at 4
Stack is full!! 5
50 item poped to statck from 4
40 item poped to statck from 3
30 item poped to statck from 2
20 item poped to statck from 1
10 item poped to statck from 0
Stack is empty!! 0
Stack is empty!! 0
70 item pushed to statck at 0
 */

public class Stack {
	int top;
	int stackArray[];
	int capacity;
	
	Stack(int N){
		capacity=N;
		stackArray=new int[N];
	}
	public void push(int x) {
		if(isFull()) {
			
			System.out.println("Stack is full!! "+top);
			return;
			
		}
		stackArray[top++]=x;
		System.out.println(x+" item pushed to statck at "+(top-1));
	}
	
	public void pop() {
		if(isEmpty()) {
			
			System.out.println("Stack is empty!! "+top);
			return;
		}
		System.out.println(stackArray[--top]+" item poped to statck from "+top);
	}
	
	public boolean isFull() {
		if(top==capacity)
			return true;
		else
			return false;
	}
	
	public boolean isEmpty() {
		if(top==0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Stack st=new Stack(5);
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		st.push(60);
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.push(70);

	}

}
