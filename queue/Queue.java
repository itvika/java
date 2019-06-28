package queue;
/*********************************************
 * @author Vikas Kumar
 * @Email  itvika@gmail.com
 * @Phone  9868366690
 * @LinkedIn https://linkedin.com/in/itvika/
Output is :
Queue is empty!!
10 enqueued!!
30 enqueued!!
50 enqueued!!
10 dequeued!!
60 enqueued!!
70 enqueued!!
90 enqueued!!
Queue is full!!
Queue is full!!
 */
public class Queue {
	int Q[];
	int size,front,rear,capacity;
	Queue(int N){
		size=front=0;
		capacity=N;
		rear=N-1;
		Q=new int[capacity];
	}
	public boolean isFull() {
		if(size==capacity) {
			System.out.println("Queue is full!!");
			return true;
		}
		return false;
	}
	public boolean isEmpty() {
		if(size==0) {
			System.out.println("Queue is empty!!");
			return true;
		}
		return false;
	}
	
	public void enqueue(int x) {
		if(!isFull()) {
			rear=(rear+1)%capacity;
			Q[rear]=x;
			rear++;
			size++;
			System.out.println(x+" enqueued!!");
		}
	}
	public void dequeue() {
		if(!isEmpty()) {
			System.out.println(Q[front]+" dequeued!!");
			front=(front+1)%capacity;
			size--;
		}
	}
	
	

	public static void main(String[] args) {
		Queue q=new Queue(5);
		q.dequeue();
		q.enqueue(10);
		q.enqueue(30);
		q.enqueue(50);
		q.dequeue();
		q.enqueue(60);
		q.enqueue(70);
		q.enqueue(90);
		q.enqueue(20);
		q.enqueue(50);
		

	}

}
