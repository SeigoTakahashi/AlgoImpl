
package gen_list;

public class GenList<T> {
	Node<T> head;
	Node<T> tail;
	int size;

	public GenList() {
       this.head = null;
       this.tail = null;
       this.size = 0;
   }

	public boolean add(T data) {
		Node<T> node = new Node<T>(data);
		
		if (this.isEmpty()) {
			this.head = node;
		} else {
			this.tail.next = node;
		}
		this.tail = node;
		this.size += 1;

		return true;
	}

	public boolean add(int idx, T data) {
		Node<T> add_node = new Node<T>(data);

		if (this.isEmpty() && idx == 0) {
			this.head = add_node;
			this.tail = add_node;
			this.size += 1;
			return true;
		}
		if (this.isEmpty()) {
			this.head = null;
			this.tail = null;
			return false;
		}

		if (0 > idx || idx > this.size) {
			return false;
		}

		if (idx == 0) {
			add_node.next = this.head;
			this.head = add_node;
			this.size += 1;
			return true;
		}
		if (idx == this.size) {
			this.tail.next = add_node;
			this.tail = add_node;
			this.size += 1;
			return true;
		}
		Node<T> node = this.head;
		Node<T> pre = null;
		int i = 0;
		while (node != null) {
			if (i == idx) {
				pre.next = add_node;
				add_node.next = node;
				break;
			}
			i++;
			pre = node;
			node = node.next;
		}
		this.size += 1;
		return true;
	}

	public boolean contains(T data) {
		Node<T> node = this.head;
		while (node != null) {
			if (node.data == data) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public T get(int idx) {
		int i = 0;
		Node<T> node = this.head;
		while (node != null) {
			if (i == idx) {
				return node.data;
			}
			i++;
			node = node.next;
		}
		return null;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public T removeHead() {
		if (this.isEmpty()) {
			return null;
		}
		T value = this.head.data;
		Node<T> remove_node = this.head;
		Node<T> next_head = this.head.next;
		remove_node.next = null;
		this.head = next_head;
		this.size -= 1;
		if (this.isEmpty()) {
			this.tail = null;
		}
		return value;
	}

	public T removeTail() {
		if (this.isEmpty()) {
			return null;
		}
		T value = this.tail.data;
		Node<T> pre = null;
		Node<T> node = this.head;
		Node<T> tail = this.tail;
		this.size -= 1;
		while (node != null) {
			if (node == this.tail) {
				if (this.isEmpty()) {
					this.head = null;
					this.tail = null;
					tail.next = null;
				} else {
					pre.next = null;
					this.tail = pre;
					tail.next = null;
				}

			}
			pre = node;
			node = node.next;
		}
		return value;
	}

	public T remove(int idx) {
		if (this.isEmpty()) {
			return null;
		}
		Node<T> target = getNode(idx);
		if (target == null) {
			return null;
		}
		T value = target.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node<T> node = this.head;
			Node<T> pre = null;
			int i = 0;
			while (node != null) {
				if (i == idx) {
					if (pre == null) {
						return this.removeHead();
					}
					if (node.next == null) {
						return this.removeTail();
					}
					pre.next = node.next;
					break;
				}
				i++;
				pre = node;
				node = node.next;
			}
		}
		target.next = null;
		this.size -= 1;
		return value;
	}

	public int size() {
		return this.size;
	}

	Node<T> getNode(int idx) {
		int i = 0;
		Node<T> node = this.head;
		while (node != null) {
			if (i == idx) {
				return node;
			}
			i++;
			node = node.next;
		}
		return null;
	}
}

class Node<T> {
	T data;
	Node<T> next;
	Node(T data) {
		this.data = data;
		this.next = null;
	}
}
