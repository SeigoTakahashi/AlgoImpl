package array;

public class ArrayTree {

	int[] treeArray;
	static final int MAX_SIZE = 1023;

	public ArrayTree() {
		this.treeArray = new int[MAX_SIZE];
		for (int i = 0; i < this.treeArray.length; i++) {
			this.treeArray[i] = -1;
		}
	}

	public int add(int x) {
		int target = 0;
		while (treeArray[target] != -1) {
			if (x < treeArray[target]) {
				target = 2 * target + 1;
			} else {
				target = 2 * target + 2;
			}
			if (target >= MAX_SIZE) {
				return -1;
			}
		}
		treeArray[target] = x;
		return x;

	}

	public boolean contains(int x) {
		int target = 0;
		while (treeArray[target] != -1) {
			if (treeArray[target] == x) {
				return true;
			}
			if (x < treeArray[target]) {
				target = 2 * target + 1;
			} else {
				target = 2 * target + 2;
			}
		}
		return false;
	}

	public int search(int x) {
		int target = 0;
		while (treeArray[target] != -1) {
			if (treeArray[target] == x) {
				return target;
			}
			if (x < treeArray[target]) {
				target = 2 * target + 1;
			} else {
				target = 2 * target + 2;
			}
		}
		return -1;
	}

	int max(int idx) {
		int target = idx;
		if (treeArray[target] == -1) {
			return -1;
		}
		int parent = -1;
		while (treeArray[target] != -1) {
			parent = target;
			target = 2 * target + 2;
		}
		return treeArray[parent];
	}

	int min(int idx) {
		int target = idx;
		if (treeArray[target] == -1) {
			return -1;
		}
		int parent = -1;
		while (treeArray[target] != -1) {
			parent = target;
			target = 2 * target + 1;
		}
		return treeArray[parent];
	}

	public void remove(int x) {
		int target = this.search(x);
		if (target == -1) {
			return;
		}
		int left = 2 * target + 1;
		int right = 2 * target + 2;
		int parent = (target - 1) / 2;

		if (treeArray[left] == -1 && treeArray[right] == -1) {
			treeArray[target] = -1;
			return;
		}

		if (treeArray[left] != -1 && treeArray[right] == -1) {
			ArrayQueue que = new ArrayQueue();
			
		}

		if (treeArray[left] == -1 && treeArray[right] != -1) {

		}
		
		if (treeArray[left] != -1 && treeArray[right] != -1) {

		}

	}
}
