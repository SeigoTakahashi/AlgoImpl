package list;

public class MyDList {
	DNode head;
	DNode tail;
	int size;
	public MyDList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	public boolean add(int data) {
		DNode add_node = new DNode(data);
		if(this.isEmpty()) {
			this.head = add_node;
			this.tail = add_node;
		} else {
			DNode prev_tail_node = this.tail;
			prev_tail_node.next = add_node;
			add_node.prev = prev_tail_node;
			add_node.next = null;
			this.tail = add_node;
		}
		this.size += 1;
		return true;
	}
	public boolean add(int idx, int data) {
		DNode add_node = new DNode(data);
        
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
			return this.add(data);
		}
		DNode node = this.head;
		int i = 0;
    	while(node != null) {
    		if(i == idx) {
				node.prev.next = add_node;
				add_node.prev = node.prev;
				add_node.next = node;
				break;
            }
            i++;
            node = node.next;
        }
    	this.size += 1;
        return true;
	}

	public boolean contains(int data) {
		DNode node = this.head;
        while(node != null) {
            if(node.data == data) {
                return true;
            }
            node = node.next;
        }
        return false;
	}

	public int get(int idx) {
		int i = 0;
        DNode node = this.head;
        while(node != null) {
            if(i == idx) {
                return node.data;
            }
            i++;
            node = node.next;
        }
        return -1;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int removeHead() {
		if(this.isEmpty()) {
			return -1;
		}
		DNode remove_node = this.head;
		int value = remove_node.data;
		this.head = remove_node.next;
		remove_node.next = null;
		this.size -= 1;
		if(this.isEmpty()) {
			this.tail = null;
		}
		return value;
	}

	public int removeTail() {
		if(this.isEmpty()) {
            return -1;
        }
        int value = this.tail.data;
        int i = 0;
        DNode remove_node = this.tail;
        this.tail = remove_node.prev;
        remove_node.next = null;
        this.size -= 1;
        return value;
	}

	public int remove(int idx) {
		if(this.isEmpty()) {
            return -1;
        }
        DNode target = getNode(idx);
        if(target == null) {
            return -1;
        }
        int value = target.data;
        
        if(this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
        	DNode node = this.head;
			int i = 0;
        	while(node != null) {
        		if(i == idx) {
        			if(node.prev == null) {
        				return this.removeHead();
        			}
					if(node.next == null) {
						return this.removeTail();
					}
					node.prev.next = node.next;
					break;
                }
                i++;
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

	DNode getNode(int idx) {
		int i = 0;
		DNode node = this.head;
		while(node != null) {
			if(i == idx) {
				return node;
			}
			i++;
			node = node.next;
		}
		return null;
	}
}

class DNode{
	int data;
	DNode next;
	DNode prev;
	DNode(int data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
