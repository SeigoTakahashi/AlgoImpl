package list;

public class ListQueue {
	MyList queueList;
	public ListQueue() {
		this.queueList = new MyList();
	}

	public boolean enqueue(int x) {
		this.queueList.add(x);
		return true;
	}

	public int dequeue() {
		return this.queueList.removeHead();
	}

	public int peak() {
		if(this.queueList.isEmpty()) {
			return -1;
		}
		return this.queueList.head.data;
	}
}
