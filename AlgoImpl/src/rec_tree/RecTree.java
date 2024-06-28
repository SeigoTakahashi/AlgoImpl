package rec_tree;

public class RecTree {
	TreeNode root;

	public RecTree() {
		this.root = null;
	}

	public void add(int x) {
		this.root = addRec(this.root, x);
	}

	private TreeNode addRec(TreeNode node, int x) {
		if (node == null) {
			TreeNode target = new TreeNode(x);
			return target;
		}
		if (x < node.data) {
			node.left = addRec(node.left, x);
		} else {
			node.right = addRec(node.right, x);
		}
		return node;
	}

	public boolean contains(int x) {
		return containsRec(this.root, x);
	}

	private boolean containsRec(TreeNode node, int x) {
		if (node == null) {
			return false;
		}
		if (x == node.data) {
			return true;
		} else if (x < node.data) {
			return containsRec(node.left, x);
		} else {
			return containsRec(node.right, x);
		}
	}

	public TreeNode minNode(TreeNode node) {
		return minNodeRec(node);
	}

	private TreeNode minNodeRec(TreeNode node) {
		if (node == null) {
			return null;
		}
		if (node.left == null) {
			return node;
		}
		return minNodeRec(node.left);
	}

	public int nodeSize() {
		return nodeSizeRec(this.root);
	}

	private int nodeSizeRec(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + nodeSizeRec(node.right) + nodeSizeRec(node.left);
	}

	public int depth() {
		return depthRec(this.root);
	}

	private int depthRec(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(1 + depthRec(node.left), 1 + depthRec(node.right));
	}

	public void remove(int x) {
		this.root = removeRec(this.root, x);
	}

	private TreeNode removeRec(TreeNode node, int x) {
		if (node == null) {
			return null;
		}
		if (!this.contains(x)) {
			return node;
		}
		if (x == node.data) {
			if (node.isLeaf()) {
				return null;
			} else if (node.left != null && node.right == null) {
				return node.left;
			} else if (node.left == null && node.right != null) {
				return node.right;
			} else if (node.left != null && node.right != null) {
				int minData = this.minNode(node.right).data;
				node.data = minData;
				return removeRec(node.right, minData);
			}
		} else if (x < node.data) {
			node.left = removeRec(node.left, x);
		} else {
			node.right = removeRec(node.right, x);
		}
		return node;
	}

	public int sum() {
		return sumRec(this.root);
	}

	private int sumRec(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return node.data + sumRec(node.left) + sumRec(node.right);
	}

	public int[] sort() {
		return sortRec(this.root);
	}

	private int[] sortRec(TreeNode node) {
		if (node == null) {
			return new int[] {};
		}
		if (node.isLeaf()) {
			return new int[] { node.data };
		}
		return joinArray(joinArray(sortRec(node.left), new int[] { node.data }),sortRec(node.right));
	}

	private int[] joinArray(int[] x, int[] y) {
		if (x.length == 0) {
			return y;
		}
		if (y.length == 0) {
			return x;
		}
		int[] z = new int[x.length + y.length];
		for (int i = 0; i < x.length; i++) {
			z[i] = x[i];
		}
		for (int i = 0; i < y.length; i++) {
			z[i + x.length] = y[i];
		}
		return z;
	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int x) {
		this.data = x;
		this.left = null;
		this.right = null;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}
}
