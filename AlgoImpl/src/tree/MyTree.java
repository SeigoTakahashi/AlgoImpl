package tree;

public class MyTree {
	TreeNode root;

	public MyTree() {
		this.root = null;
	}

	public void add(int x) {
		TreeNode node = new TreeNode(x);
		if (this.root == null) {
			this.root = node;
			return;
		}

		TreeNode parent = null;
		TreeNode target = this.root;
		while (target != null) {
			parent = target;
			if (node.data <= target.data) {
				target = target.left;
			} else {
				target = target.right;
			}
		}
		if (node.data <= parent.data) {
			parent.left = node;
		} else {
			parent.right = node;
		}
	}

	public boolean contains(int x) {
		return this.searchNode(x) != null;
	}

	TreeNode searchNode(int x) {
		if (this.root == null) {
			return null;
		}
		TreeNode parent = null;
		TreeNode target = this.root;
		while (target != null) {
			if (target.data == x) {
				return target;
			}
			parent = target;
			if (x <= target.data) {
				target = target.left;
			} else {
				target = target.right;
			}
		}
		return null;

	}

	TreeNode maxNode(TreeNode node) {
		if (this.root == null) {
			return null;
		}
		TreeNode parent = null;
		TreeNode target = node;
		while (target != null) {
			parent = target;
			target = target.right;
		}
		return parent;
	}

	TreeNode minNode(TreeNode node) {
		if (this.root == null) {
			return null;
		}
		TreeNode parent = null;
		TreeNode target = node;
		while (target != null) {
			parent = target;
			target = target.left;
		}
		return parent;
	}

	public void remove(int x) {
		if (this.root == null) {
			return;
		}
		TreeNode target = this.searchNode(x);
		if (target == null) {
			return;
		}
		TreeNode parent = null;
		target = this.root;
		while (target != null) {
			if (target.data == x) {
				break;
			}
			parent = target;
			if (x <= target.data) {
				target = target.left;
			} else {
				target = target.right;
			}
		}

		if (target.isLeaf()) {
			if (target == this.root) {
				this.root = null;
				return;
			}
			if (target.data <= parent.data) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			return;
		}

		if (target.left != null && target.right == null) {
			if (target == this.root) {
				this.root = target.left;
				target.left = null;
				return;
			}
			if (target.data <= parent.data) {
				parent.left = target.left;
			} else {
				parent.right = target.left;
			}
			target.left = null;
			return;
		}

		if (target.left == null && target.right != null) {
			if (target == this.root) {
				this.root = target.right;
				target.right = null;
				return;
			}
			if (target.data <= parent.data) {
				parent.left = target.right;
			} else {
				parent.right = target.right;
			}
			target.right = null;
			return;
		}

		if (target.left != null && target.right != null) {
			TreeNode minNode = this.minNode(target.right);

			target.data = minNode.data;
			TreeNode min_parent = target;
			TreeNode min_target = target.right;
			int min_x = minNode.data;
			while (min_target != null) {
				if (min_target.data == min_x) {
					break;
				}
				min_parent = min_target;
				if (min_x <= min_target.data) {
					min_target = min_target.left;
				} else {
					min_target = min_target.right;
				}
			}
			
			if (min_target.data < min_parent.data) {
				min_parent.left = min_target.right;
			} else {
				min_parent.right = min_target.right;
			}
			min_target.right = null;

		}

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