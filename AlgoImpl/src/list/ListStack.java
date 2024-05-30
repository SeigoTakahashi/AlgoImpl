package list;

public class ListStack {
	MyList stackList;

	public ListStack() {
		this.stackList = new MyList();
	}

	public boolean empty() {
		return this.stackList.isEmpty();
	}

	public int pop() {
		return this.stackList.removeTail();
	}

	public int push(int x) {
		this.stackList.add(x);
		return x;
	}

	public int peek() {
		if (this.stackList.isEmpty()) {
			return -1;
		}
		return this.stackList.tail.data;
	}

	public int search(int x) {
		Node node = this.stackList.head;
		int i = 0;
		int temp = 0;
		boolean flag = false;
		while (node != null) {
			if (node.data == x) {
				temp =  this.stackList.size - i;
				flag = true;
			}
			node = node.next;
			i += 1;
		}
		if(flag) {
			return temp;
		}
		return -1;
	}
}
