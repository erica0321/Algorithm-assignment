package algorithms;

public class StackUsingArray {
	public int top;
	public int stackSize;
	public Object[] stackArray;
	
	public static final int STACK_SIZE = 20;
	public static final int INCREMENT = 10;
	
	public StackUsingArray() {	
		top = -1;
		stackSize = STACK_SIZE;
		stackArray = new Object[stackSize];
	}
	
	public boolean isEmpty() {	//check if stackArray is empty
		return (top == -1);
	}
	
	public void push(Object x) {	//save x to stackArray and make x top
		if(top == stackSize - 1) {
			stackFull();
		}else {
			stackArray[++top] = x;
		}
	}
	
	public void stackFull() {	//if stack is full, using this function to increase stack's length
		stackSize += INCREMENT;
		Object[] nextArray = new Object[stackSize];
		for(int i = 0; i <= top; i++) {
			nextArray[i] = stackArray[i];
		}
		stackArray = nextArray;
	}
	
	public Object pop() {	//return top element
		if(isEmpty()) {
			return null;
		}else {
			return stackArray[top--];
		}
	}
	
}
