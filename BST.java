/*
 * Authors: Cassie Noble
 * Date: 8/1/18
 * Overview: Build a binary search tree(BST) data structure and implement some of its functionality. Allow user to choose between:
 * adding to tree, removing from tree, searching for element in tree, displaying tree in in-oder, pre-order, or post-order.
 */

// BST uses interface
public class BST <G extends Comparable<G>> implements TreeInterface <G> {
	Node <G> root;
	
	// search method used by others needs to return boolean indicating if node was found
	public boolean search(G s){
		
		// start recursive call with root
		Node <G> foundNode = recursiveSearch(s, root);
		
		// check if node was found
		if (foundNode != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// search method within class needs to return the node that was found
	private Node <G> recursiveSearch(G s, Node <G> current) {
		
		// base cases -- if current is null or current is node to search for
		if (current == null) {
			return null;
		}
		
		// base cases -- if current is null or current is node to search for
		else if (s == current.getKey()) {
			return current;
		}
		
		else {
			// compare node to search for with current
			int compare = s.compareTo(current.getKey());

			// if node to search for is less than current then go left
			if (compare < 0) {
				return recursiveSearch(s, current.getLeft());
			}
			// if node to search for is greater than current then go right
			else {
				return recursiveSearch(s, current.getRight());
			}	
		}
	}
	
	public void add(G a){
		
		// start recursive call with root
		recursiveAdd(a, root);	
		System.out.println("Node has been added to the tree." + "\n");
	}
	
	private void recursiveAdd(G a, Node <G> current) {

		// base case -- root is null, set new node to root
		if (current == null) {
			root = new Node <G> (a);
		}
		
		// if root is not null
		else {
			// compare current to new
			int compare = a.compareTo(current.getKey());
			
			// if new is less than current
			if (compare < 0) {
				// if not null, keep going down the tree
				if (current.getLeft() != null) {
					recursiveAdd(a, current.getLeft());
				}
				// if null, then set left child of current to new node
				else {
					current.setLeft(new Node <G> (a));
					// set parent of new node to current node
					current.getLeft().setParent(current);
				}
			}
			
			// if new is greater than current
			else {
				// if not null, keep going down the tree
				if (current.getRight() != null) {
					recursiveAdd(a, current.getRight());
				}
				// if null, then set right child of current to new node
				else {
					current.setRight(new Node <G> (a));
					// set parent of new node to current node
					current.getRight().setParent(current);
				}
			}
		}
	}
	
	public boolean remove(G r){
		boolean foundIt = false;
		
		// search to make sure the node is in the tree
		Node <G> remNode = recursiveSearch(r, root);

		// if node is in tree
		if (remNode != null) {
			foundIt = true;
			
			// has no children
			if (remNode.getLeft() == null && remNode.getRight() == null) {
				
				// if node to remove is root
				if(remNode == root) {
					root = null;	// remove root
				}
				
				// if not root
				else {
					
					// if node to remove is left child of parent
					if (remNode.getParent().getLeft() == remNode) {
						remNode.getParent().setLeft(null);
					}
					
					// if node to remove is right child of parent
					else {
						remNode.getParent().setRight(null);
					}
				}
			}
			
			// has one child (right)
			else if (remNode.getLeft() == null) {
				
				// if node to remove is root
				if (remNode == root) {
					// set right child to be root and remove parent
					root = remNode.getRight();
					remNode.getRight().setParent(null);
				}
				
				// if not root
				else {
					// if node to remove is left child of parent
					if (remNode.getParent().getLeft() == remNode) {
						remNode.getParent().setLeft(remNode.getRight());
					}
					// if node to remove is right child of parent
					else {
						remNode.getParent().setRight(remNode.getRight());
					}
				}
			}
			
			// has one child (left)
			else if (remNode.getRight() == null) {
				
				// if node to remove is root
				if (remNode == root) {
					// set left child to be root and remove parent
					root = remNode.getLeft();
					remNode.getLeft().setParent(null);
				}
				
				// if not root
				else {
					// if node to remove is left child of parent
					if (remNode.getParent().getLeft() == remNode) {
						remNode.getParent().setLeft(remNode.getLeft());
					}
					// if node to remove is right child of parent
					else {
						remNode.getParent().setRight(remNode.getLeft());
					}
				}
			}
			
			// has two children
			else {
				
				// go to left child
				Node <G> swapNode = remNode.getLeft();
				
				// go to rightmost child of left child
				while (swapNode.getRight() != null) {
					swapNode = swapNode.getRight();
				}
				
				// store swapped nodes data
				G storage = swapNode.getKey();
				// remove node to swap
				remove(swapNode.getKey());
				// set node to remove as swapped nodes data
				remNode.setKey(storage);
			}
		}

		// return if element was found and removed
		return foundIt;
	}
	
	public void inOrder() {
		
		// start recursive call with root
		recursiveInOrder(root);
	}
	
	private void recursiveInOrder(Node <G> current) {
		
		// keep looping until current is null
		if (current != null) {
			recursiveInOrder(current.getLeft());
			System.out.print(current.getKey());
			System.out.print(" ");
			recursiveInOrder(current.getRight());
		}
	}
	
	public void preOrder() {
		
		// start recursive call with root
		recursivePreOrder(root);
	}
	
	private void recursivePreOrder(Node <G> current) {
		
		// keep looping until current is null
		if (current != null) {
			System.out.print(current.getKey());
			System.out.print(" ");
			recursivePreOrder(current.getLeft());
			recursivePreOrder(current.getRight());
		}
	}
	
	public void postOrder() {
		
		// start recursive call with root
		recursivePostOrder(root);
	}
	
	private void recursivePostOrder(Node <G> current) {
		
		// keep looping until current is null
		if (current != null) {
			recursivePostOrder(current.getLeft());
			recursivePostOrder(current.getRight());
			System.out.print(current.getKey());
			System.out.print(" ");
		}
	}
}
