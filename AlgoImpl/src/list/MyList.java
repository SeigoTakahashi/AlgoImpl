 package list;
public class MyList {
    Node head;
    Node tail;
    int size;
    public MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public boolean add(int data) {
        Node node = new Node(data);
        if(this.isEmpty()) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
        this.size += 1;
        
        return true;
    }
    public boolean add(int idx, int data) {
        Node add_node = new Node(data);
        
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
		Node node = this.head;
		Node pre = null;
		int i = 0;
    	while(node != null) {
    		if(i == idx) {
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
    public boolean contains(int data) {
        Node node = this.head;
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
        Node node = this.head;
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
        int value = this.head.data;
        Node remove_node = this.head;
        Node next_head = this.head.next;
        remove_node.next = null;        
        this.head = next_head;
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
        Node pre = null;
        Node node = this.head;
        Node tail = this.tail;
        this.size -= 1;
        while(node != null) {
            if(node == this.tail) {
                if(this.isEmpty()) {
                    this.head = null;
                    this.tail = null;
                    tail.next = null;
                } else {
                    pre.next = null;
                    this.tail = pre;
                    tail.next = null;
                }
                
            }
            i++;
            pre = node;
            node = node.next;
        }
        return value;
    }
    public int remove(int idx) {
        if(this.isEmpty()) {
            return -1;
        }
        Node target = getNode(idx);
        if(target == null) {
            return -1;
        }
        int value = target.data;
        
        if(this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
        	Node node = this.head;
			Node pre = null;
			int i = 0;
        	while(node != null) {
        		if(i == idx) {
					if (pre == null) {
						return this.removeHead();
					}
					if(node.next == null) {
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
    Node getNode(int idx) {
        int i = 0;
        Node node = this.head;
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
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}