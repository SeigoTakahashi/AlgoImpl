package rec_list;

public class RecList {
	Node head;
	Node tail;
	int size;

	public RecList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public boolean add(int data) {
		Node node = new Node(data);
		if (this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
		this.size++;
		return true;

	}

	public boolean add(int idx, int data) {
		if (0 > idx || idx > this.size) {
			return false;
		}
		this.head = addRec(this.head, idx, data);
		return true;

	}

	private Node addRec(Node node, int idx, int data) {
		if (node == null && idx == 0) {
			Node target = new Node(data);
			this.tail = target;
			this.size++;
			return target;
		}
		if (node == null) {
			this.tail = null;
			return null;
		}
		if (idx == 0) {
			Node target = new Node(data);
			target.next = node;
			this.size++;
			return target;
		}
		node.next = addRec(node.next, idx - 1, data);
		return node;
	}

	public boolean contains(int data) {
		return containsRec(this.head, data);
	}

	private boolean containsRec(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		} else {
			return containsRec(node.next, data);
		}

	}

	public int get(int idx) {
		return getRec(this.head, idx);

	}

	private int getRec(Node node, int idx) {
		if (node == null) {
			return -1;
		}
		if (idx == 0) {
			return node.data;
		} else {
			return getRec(node.next, idx - 1);
		}

	}

	private Node getNodeRec(Node node, int idx) {
		if (node == null) {
			return null;
		}
		if (idx == 0) {
			return node;
		}
		return getNodeRec(node.next, idx - 1);
	}

	Node getNode(int idx) {
		return getNodeRec(this.head, idx);

	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int removeHead() {
		return remove(0);
	}

	public int removeTail() {
		return remove(this.size - 1);
	}

	public int remove(int idx) {
		if(this.isEmpty()) {
			return -1;
		}
		if (0 > idx || idx >= this.size) {
			return -1;
		}
		if(idx == this.size - 1) {
			this.tail = this.getNode(this.size - 2);
		}
		int value = this.get(idx);
		this.head = this.removeRec(this.head, idx);
		if(this.isEmpty()) {
			this.head = null;
			this.tail = null;
		}
		return value;
	}

	private Node removeRec(Node node, int idx) {
		if(this.isEmpty()) {
			return null;
		}
		
		if(idx == 0) {
			this.size --;
			Node next = node.next;
			node.next = null;
			return next;
		}
		node.next = removeRec(node.next, idx - 1);
		return node;
	}

	public int size() {
		return this.size;
	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}