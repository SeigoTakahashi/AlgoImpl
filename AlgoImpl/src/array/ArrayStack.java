package array;

public class ArrayStack {
	int[] stackArray;
	static final int MAX_SIZE = 1000;
	int top;

	public ArrayStack() {
		this.stackArray = new int[MAX_SIZE];
		top = 0;
	}

	public int push(int x) {
		if(top >= MAX_SIZE) {
			return -1;
		}
		this.stackArray[top] = x;
		top++;
        return x;
    }

	public boolean empty() {
		return top == 0;
	}

	public int pop() {
		top--;
		if (top < 0) {
			top = 0;
			return -1;
		}
		return this.stackArray[top];
	}

	public int peek() {
		if (top == 0) {
			return -1;
		}
		return this.stackArray[top-1];
	}

	public int search(int x) {
		int result = -1;
		for(int i = top-1;i >= 0;i--) {
			if(this.stackArray[i] == x) {
				result = top - i;
				break;
			}
		}
		return result;
	}
}
