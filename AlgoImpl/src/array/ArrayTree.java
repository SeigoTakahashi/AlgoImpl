package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

		if (treeArray[left] == -1 && treeArray[right] == -1) {
			treeArray[target] = -1;
			return;
		}

		if (treeArray[left] != -1 && treeArray[right] == -1) {
			int[] newTree = Arrays.copyOf(this.treeArray, this.treeArray.length);
			int[] oldTree = Arrays.copyOf(this.treeArray, this.treeArray.length);
			Queue<int[]> queue = new LinkedList<>();
			int new_i = target;
			int old_i = left;
			queue.add(new int[] { old_i, new_i });

			while (!queue.isEmpty()) {
				int[] i = queue.poll();
				old_i = i[0];
				new_i = i[1];

				newTree[new_i] = oldTree[old_i];
				newTree[old_i] = -1;

				int old_left = 2 * old_i + 1;
				int old_right = 2 * old_i + 2;

				int new_left = 2 * new_i + 1;
				int new_right = 2 * new_i + 2;

				if (oldTree[old_left] != -1) {
					queue.add(new int[] { old_left, new_left });
				}

				if (oldTree[old_right] != -1) {
					queue.add(new int[] { old_right, new_right });
				}
			}
			this.treeArray = newTree;
			return;

		}

		if (treeArray[left] == -1 && treeArray[right] != -1) {
			int[] newTree = Arrays.copyOf(this.treeArray, this.treeArray.length);
			int[] oldTree = Arrays.copyOf(this.treeArray, this.treeArray.length);
			Queue<int[]> queue = new LinkedList<>();
			int new_i = target;
			int old_i = right;
			queue.add(new int[] { old_i, new_i });

			while (!queue.isEmpty()) {
				int[] i = queue.poll();
				old_i = i[0];
				new_i = i[1];

				newTree[new_i] = oldTree[old_i];
				newTree[old_i] = -1;

				int old_left = 2 * old_i + 1;
				int old_right = 2 * old_i + 2;

				int new_left = 2 * new_i + 1;
				int new_right = 2 * new_i + 2;

				if (oldTree[old_left] != -1) {
					queue.add(new int[] { old_left, new_left });
				}

				if (oldTree[old_right] != -1) {
					queue.add(new int[] { old_right, new_right });
				}
			}
			this.treeArray = newTree;
			return;
		}

		if (treeArray[left] != -1 && treeArray[right] != -1) {
			int min_value = this.min(right);
			int min_i = this.search(min_value);
			int min_right = 2 * min_i + 2;
			if(this.treeArray[min_right] == -1) {
				this.treeArray[min_i] = -1;
				this.treeArray[target] = min_value;
				return;
			}
			
			if(this.treeArray[min_right] != 1) {
				int[] newTree = Arrays.copyOf(this.treeArray, this.treeArray.length);
				int[] oldTree = Arrays.copyOf(this.treeArray, this.treeArray.length);
				Queue<int[]> queue = new LinkedList<>();
				int new_i = min_i;
				int old_i = min_right;
				queue.add(new int[] { old_i, new_i });

				while (!queue.isEmpty()) {
					int[] i = queue.poll();
					old_i = i[0];
					new_i = i[1];

					newTree[new_i] = oldTree[old_i];
					newTree[old_i] = -1;

					int old_left = 2 * old_i + 1;
					int old_right = 2 * old_i + 2;

					int new_left = 2 * new_i + 1;
					int new_right = 2 * new_i + 2;

					if (oldTree[old_left] != -1) {
						queue.add(new int[] { old_left, new_left });
					}

					if (oldTree[old_right] != -1) {
						queue.add(new int[] { old_right, new_right });
					}
				}
				this.treeArray = newTree;
				this.treeArray[target] = min_value;
				return;
			}
		}

	}
}