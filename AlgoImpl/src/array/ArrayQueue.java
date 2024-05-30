package array;

public class ArrayQueue {
	int[] queueArray;
	static final int MAX_SIZE = 1000;
	int front;
	int rear;
	int size;
	public ArrayQueue() {
		this.queueArray = new int[MAX_SIZE];
		front = 0;
		rear = 0;
		size = 0;
	}

	public boolean enqueue(int x) {
		if(size == MAX_SIZE) {
			return false;
		}
		this.queueArray[rear] = x;
		size += 1;
		rear = (rear + 1) % MAX_SIZE;
		return true;
	}

	public int dequeue() {
		if(size == 0) {
			return -1;
		}
		size -= 1;
		int value = this.queueArray[front];
		front = (front + 1) % MAX_SIZE;
		return value;
	}

	public int peak() {
		if(size == 0) {
			return -1;
		}
		int value = this.queueArray[front];
		return value;
	}
}
