/*
 * Authors: Cassie Noble
 * Date: 8/1/18
 * Overview: Build a binary search tree(BST) data structure and implement some of its functionality. Allow user to choose between:
 * adding to tree, removing from tree, searching for element in tree, displaying tree in in-oder, pre-order, or post-order.
 */

public class Node <G> {
	private G key;
	private Node <G> parent;
	private Node <G> leftChild;
	private Node <G> rightChild;
	
	// constructor for node
	Node(G k){
		key = k;
	}
	
	// method to get node key
	public G getKey() {
		return key;
	}
	
	// method to get parent node
	public Node <G> getParent() {
		return parent;
	}
	
	// method to get left child
	public Node <G> getLeft() {
		return leftChild;
	}
	
	// method to get right child
	public Node <G> getRight() {
		return rightChild;
	}
	
	// method to set key
	public void setKey(G k) {
		key = k;
	}
	
	// method to set parent node
	public void setParent(Node <G> p) {
		parent = p;
	}
	
	public void setLeft(Node <G> l) {
		leftChild = l;
	}
	
	public void setRight(Node <G> r) {
		rightChild = r;
	}

}
