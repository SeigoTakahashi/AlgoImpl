package map;

public class MyHashMap {
	static final int MAX_SIZE = 100;
	HashNode[] hashTable;
	int size;

	public MyHashMap() {
		this.hashTable = new HashNode[MAX_SIZE];
		this.size = 0;
	}

	int hash(String key) {
		int hash = 0;
		for (int i = 0; i < key.length(); i++) {
			hash = 31 * hash + key.charAt(i);
		}
		return hash % MAX_SIZE;
	}

	public int put(String key, int value) {
		int ret = -1;
		int hash = this.hash(key);
		if(this.hashTable[hash] == null) {
			HashNode newNode = new HashNode(key,value);
			this.hashTable[hash] = newNode;
			this.size += 1;
		} else if(this.hashTable[hash].key == key) {
			ret = this.hashTable[hash].value;
			this.hashTable[hash].value = value;
		} else {
			HashNode newNode = new HashNode(key,value);
			HashNode node = this.hashTable[hash];
			while(node.next != null) {
				node = node.next;
			}
			node.next = newNode;
			this.size += 1;
		}
		
		return ret;
	}

	public int get(String key) {
		int hash = this.hash(key);
		if(this.hashTable[hash] !=null) {
			HashNode node = this.hashTable[hash];
			while(node != null) {
				if(node.key == key) {
					return node.value;
				}
				node = node.next;
			}
		}
		return -1;
	}

	public boolean containsKey(String key) {
		int hash = this.hash(key);
		if(this.hashTable[hash] !=null) {
			HashNode node = this.hashTable[hash];
			while(node != null) {
				if(node.key == key) {
					return true;
				}
				node = node.next;
			}
		}
		return false;
	}

	public boolean replace(String key, int oldVal, int newVal) {
		if(!this.containsKey(key)) {
			return false;
		}
		if(this.get(key) != oldVal) {
			return false;
		}
		int hash = this.hash(key);
		HashNode node = this.hashTable[hash];
		while(true) {
			if(node.key == key) {
				node.value = newVal;
				return true;
			}
			node = node.next;
		}
		
	}

	public int remove(String key) {
		if(!this.containsKey(key)) {
			return -1;
		}
		int hash = this.hash(key);
		HashNode node = this.hashTable[hash];
		if(node.key == key) {
			int ret = node.value;
			node = node.next;
			this.hashTable[hash] = node;
			this.size -= 1;
			return ret;
		}
		HashNode prev = node;
		node = node.next;
		while(true) {
			if(node.key == key) {
				int ret = node.value;
				prev.next = node.next;
				this.size -= 1;
				return ret;
			}
			prev = node;
			node = node.next;
		}
	}

	public void clear() {
		this.hashTable = new HashNode[MAX_SIZE];
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public boolean containsValue(int value) {
		for(HashNode node:this.hashTable) {
			HashNode n = node;
			while(n != null) {
				if(n.value == value) {
					return true;
				}
				n = n.next;
			}
		}
		return false;
	}
}

class HashNode {
	String key;
	int value;
	HashNode next;

	HashNode(String key, int value) {
		this.key = key;
		this.value = value;
	}
}
