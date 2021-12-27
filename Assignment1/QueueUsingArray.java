package algorithms;

public class QueueUsingArray {
	public int front;	//where to delete
	public int rear;	//where to insert
	public int count;	//number of element
	public int queueSize;	//length of queue
	public Object[] queueArray;
	
	public static final int QUEUE_SIZE = 20;
	public static final int INCREMENT = 10;
	
	public QueueUsingArray() {
		front = 0;	
		rear = 0;	
		count = 0;	
		queueSize = QUEUE_SIZE;	
		queueArray = new Object[queueSize];
	}
	
	public boolean isEmpty() {	//check if queueArray is empty
		return (count == 0);
	}
	
	public void enqueue(Object x) {	//save x 
		if(count == queueSize) {
			queueFULL();
		}else {
			queueArray[rear] = x;	//if queue is not full(number of element != queuesize) save x
			rear = (rear+1) % queueSize;
			count ++;
		}
	}
	
	public void queueFULL() {	//if queue is full, using this function to increase queue's length
		int lastSize = queueSize;
		queueSize += INCREMENT;
		Object[] nextArray = new Object[queueSize];
		for(int i = 0; i < count; i++){
			nextArray[i] = queueArray[front];
			front = (front + 1) % lastSize;
		}
		queueArray = nextArray;
		front = 0;
		rear = count;
	}
	
	public Object dequeue() {	//delete x 
		if(isEmpty()) {
			return null;
		}else {
			Object item = queueArray[front];
			front = (front + 1) % queueSize;
			count --;
			return item;
		}
	}
	
}
