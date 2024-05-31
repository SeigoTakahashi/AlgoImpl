package tree;

public class MyTree {
	TreeNode root;

	public MyTree() {
		this.root = null;
	}

	public void add(int x) {
		TreeNode target = new TreeNode(x);
		if (this.root == null) {
			this.root = target;
			return;
		}
		TreeNode parent = this.root;
		TreeNode child = null;
		if (parent.data < target.data) {
			child = parent.right;
			if (child == null) {
				parent.right = target;
				return;
			}
		} else {
			child = parent.left;
			if (child == null) {
				parent.left = target;
				return;
			}
		}

		while (child != null) {
			if (child.data < target.data) {
				parent = child;
				child = child.right;
				if (child == null) {
					parent.right = target;
					return;
				}
			} else {
				parent = child;
				child = child.left;
				if (child == null) {
					parent.left = target;
					return;
				}
			}
		}
	}

	public boolean contains(int x) {
		if (this.root == null) {
			return false;
		}
		TreeNode target = new TreeNode(x);
		if (this.root.data == target.data) {
			return true;
		}
		TreeNode parent = this.root;
		TreeNode child = null;
		if (parent.data < target.data) {
			child = parent.right;
		} else {
			child = parent.left;
		}
		if (child == null) {
			return false;
		}
		while (child != null) {
			if (child.data == target.data) {
				return true;
			}
			if (child.data < target.data) {
				child = child.right;
			} else {
				child = child.left;
			}

		}
		return false;
	}

	TreeNode searchNode(int x) {
		if (this.root == null) {
			return null;
		}
		TreeNode target = new TreeNode(x);
		if (this.root.data == target.data) {
			return this.root;
		}
		TreeNode parent = this.root;
		TreeNode child = null;
		if (parent.data < target.data) {
			child = parent.right;
		} else {
			child = parent.left;
		}
		if (child == null) {
			return null;
		}
		while (child != null) {
			if (child.data == target.data) {
				return child;
			}
			if (child.data < target.data) {
				child = child.right;
			} else {
				child = child.left;
			}

		}
		return null;

	}

	TreeNode maxNode(TreeNode node) {
		if (this.root == null) {
			return null;
		}
		TreeNode parent = node;
		TreeNode right = parent.right;
		while (right != null) {
			parent = right;
			right = right.right;
		}
		return parent;
	}

	TreeNode minNode(TreeNode node) {
		if (this.root == null) {
			return null;
		}
		TreeNode parent = node;
		TreeNode left = parent.left;
		while (left != null) {
			parent = left;
			left = left.left;
		}
		return parent;
	}

	public void remove(int x) {
		if(this.root == null) {
			return;
		}
		TreeNode target = this.searchNode(x);
		if(target == null) {
			return;
		}
		TreeNode parent = this.root;
		if (parent.isLeaf() && parent.data == target.data) {
			this.root = null;
			return;
		}
		
		if(parent.data == target.data) {
			
		}
		
		TreeNode child = null;
		int flag = 0;
		if(parent.data < target.data) {
			flag = 1;
			child = parent.right;
		} else {
			flag = 0;
			child = parent.left;
		}
		
		while(child != target) {
			parent = child;
			if (child.data < target.data) {
				child = child.right;
				flag = 1;
			} else {
				child = child.left;
				flag = 0;
			}
		}
		if(child.isLeaf()) {
			if(flag == 0) {
				parent.left = null;
				return;
			} else {
				parent.right = null;
				return;
			}
		}
		
		if(child.left != null && child.right == null) {
			if(flag == 0) {
				parent.left = child.left;
				child.left = null;
				return;
			} else {
				parent.right = child.left;
				child.left = null;
				return;
			}
		}
		
		if(child.left == null && child.right != null) {
			if(flag == 0) {
				parent.left = child.right;
				child.right = null;
				return;
			} else {
				parent.right = child.right;
				child.right = null;
				return;
			}
		}
		
		if(child.left != null && child.right != null) {
			TreeNode min = this.minNode(child.right);
			child = min;
			min.
			
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
