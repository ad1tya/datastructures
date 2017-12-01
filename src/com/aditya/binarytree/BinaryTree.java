/**
 * 
 */
package com.aditya.binarytree;

/**
 * @author Aditya Kulkarni
 *
 */
public class BinaryTree<E extends Comparable<E>> {

	/**
	 * 
	 */
	public BinaryTree() {
		index = 0;
		root = null;
	}

	private int index;
	private TreeNode<E> root; /* The absolute root of the tree. */

	/*
	 * ------------------------------------------------------------------
	 * Recursively calculates the size of the tree; i.e., the number of elements in
	 * the binary tree.
	 */
	public int sizeRecursive() {
		return size_p(root);
	}
	
	public int sizeIterative() {
		TreeNode<E> temp = root;
		int size = 0;
		while(temp.left != null) {
			TreeNode<E> temp1 = temp;
			while(temp1.right != null) {
				temp1 = temp1.right;
				++size;
			}
			temp = temp.left;
			++size;
		}
		temp = root;
		
		while(temp.right != null) {
			TreeNode<E> temp1 = temp;
			while(temp1.left != null) {
				temp1 = temp1.left;
				++size;
			}
			temp = temp.right;
			++size;
		}
		
		return size-3;
	}

	
	/*
	 * Complete the following method to calculate size.
	 */
	private int size_p(TreeNode<E> t) {
		int num_nodes = 0;
		if (t.left != null) {
			num_nodes = num_nodes + size_p(t.left);
		}
		if (t.right != null) {
			num_nodes = num_nodes + size_p(t.right);
		}
		return ++num_nodes;
	}

	/*
	 * -------------------------------------------------------------------
	 * Recursively does an inorder traversal of the tree
	 */
	public void inorder() {
		inorder_p(root);
	}

	/*
	 * Complete the following method to do an inorder traversal.
	 */
	private void inorder_p(TreeNode<E> t) {
		/*
		 * ADD YOUR CODE HERE ADD YOUR CODE HERE
		 *
		 * Note: t.get_left() gives you the entire left subtree and t.get_right() gives
		 * you the right tree.
		 */
		if (t.left != null) {
			inorder_p(t.get_left());
		}
		System.out.print(t.info + " ");
		if (t.right != null) {
			inorder_p(t.get_right());
		}
		return;
	}

	public void preorder() {
		preorder_p(root);
	}

	private void preorder_p(TreeNode<E> t) {

		System.out.print(t.info + " ");
		if (t.left != null) {
			preorder_p(t.get_left());
		}
		if (t.right != null) {
			preorder_p(t.get_right());
		}
		return;
	}

	public void postorder() {
		postorder_p(root);
	}

	private void postorder_p(TreeNode<E> t) {
		if (t.left != null) {
			postorder_p(t.get_left());
		}
		if (t.right != null) {
			postorder_p(t.get_right());
		}
		System.out.print(t.info + " ");
		return;
	}

	public void add(E info) {
		index++;
		TreeNode<E> node = new TreeNode<>(info);

		if (root == null) {
			root = node;
			return;
		}
		addRecursive(root, node);
	}

	public void addRecursive(TreeNode<E> node, TreeNode<E> add) {
		int i2 = (int) node.info;
		int i1 = (int) add.info;
		if (i1 <= i2) {
			if (node.left != null) {
				addRecursive(node.left, add);
			} else {
				node.left = add;
			}
		} else {
			if (node.right != null) {
				addRecursive(node.right, add);
			} else {
				node.right = add;
			}
		}
	}

	protected static class TreeNode<E extends Comparable<E>> {
		private TreeNode<E> left, right;
		private E info;

		public TreeNode(E info) {
			left = right = null;
			this.info = info;
		}

		public TreeNode<E> get_left() {
			return left;
		}

		public TreeNode<E> get_right() {
			return right;
		}
	}

	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		// 25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90,
		bt.add(25);
		bt.add(15);
		bt.add(10);
		bt.add(4);
		bt.add(12);
		bt.add(22);
		bt.add(18);

		bt.add(24);
		bt.add(50);
		bt.add(35);
		bt.add(31);
		bt.add(44);
		bt.add(70);

		bt.add(66);
		bt.add(90);
		
		System.out.println(bt.sizeIterative());

		System.out.println("The tree has " + bt.sizeRecursive() + " nodes in Recursive way.");
		System.out.println("The tree has "+bt.sizeIterative() + " nodes in iterative way.");
		System.out.println("Preorder: "); // 32 40 9 8 60 15
		bt.preorder();
		System.out.println();
		System.out.println("Inorder: "); // 9 40 8 32 15 60
		bt.inorder();
		System.out.println();
		System.out.println("Postorder: "); // 9 8 40 15 60 32
		bt.postorder();
		System.out.println();
		System.out.println("--------------------------------------------------------------");
		System.out.println("The Inorder is in Ascending Order.");
		return;
	}
}
