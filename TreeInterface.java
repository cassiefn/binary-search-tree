/*
 * Authors: Cassie Noble
 * Date: 8/1/18
 * Overview: Build a binary search tree(BST) data structure and implement some of its functionality. Allow user to choose between:
 * adding to tree, removing from tree, searching for element in tree, displaying tree in in-oder, pre-order, or post-order.
 */

// use interface for tree
public interface TreeInterface <G> {
	
	// methods to implement
	public boolean search(G s);
	public void add(G a);
	public boolean remove(G r);
	public void inOrder();
	public void preOrder();
	public void postOrder();

}
