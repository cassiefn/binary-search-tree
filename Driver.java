import java.util.Scanner;

/*
 * Authors: Cassie Noble
 * Date: 8/1/18
 * Overview: Build a binary search tree(BST) data structure and implement some of its functionality. Allow user to choose between:
 * adding to tree, removing from tree, searching for element in tree, displaying tree in in-oder, pre-order, or post-order.
 */

public class Driver {

	public static void main(String[] args) {
		int choice;
		boolean exit = false;					// boolean to check if user wants to exit program
		Scanner sc = new Scanner(System.in);	// open scanner
		
		// create tree
		BST <Integer> tree = new BST<Integer>();
		
		/*
		// test data
		tree.add(4);
		tree.add(2);
		tree.add(3);
		tree.add(7);
		tree.add(8);
		tree.add(1);
		tree.add(5);
		tree.add(6);
		 */
		
		// stay in loop as long as user does not quit
		while (! exit) {
			printMenu();				// print menu options
			choice = sc.nextInt();		// get user input for menu option
			System.out.println();
						
			// Choice 1. Add an element to the tree.
			if (choice == 1) {
				System.out.print("Please enter an integer to add to the tree > ");
				int inputInt = sc.nextInt();		// get user input for what to add
				tree.add(inputInt);					// add input to tree
			}
			
			// Choice 2. Remove an element from the tree.
			else if (choice == 2) {
				System.out.print("Please enter which integer you would like to remove from the tree > ");
				int inputInt = sc.nextInt();				// get user input for what to remove
				boolean removedIt = tree.remove(inputInt);	// remove input from tree
				
				// let user know if element was found and removed
				if (removedIt) {
					System.out.println(inputInt + " was removed from the tree.");
				}
				else {
					System.out.println("Cannot remove an element that is not in the tree.");
				}
				System.out.println();
			}
			
			// Choice 3. Search for an element in the tree.
			else if (choice == 3) {
				System.out.print("Please enter an integer you would like to search for > ");
				int inputInt = sc.nextInt();		// get user input for what to search for
				boolean foundIt = tree.search(inputInt);	// search for input in tree
				
				// let user know if element was found
				if (foundIt) {
					System.out.println(inputInt + " was found in the tree.");
				}
				else {
					System.out.println(inputInt + " was NOT found in the tree.");
				}
				System.out.println();
			}
			
			// Choice 4. Show the tree in in-order.
			else if (choice == 4) {
				System.out.println("Tree in in-order:");
				tree.inOrder();
				System.out.println("\n");
			}
			
			// Choice 5. Show the tree in pre-order.
			else if (choice == 5) {
				System.out.println("Tree in pre-order:");
				tree.preOrder();
				System.out.println("\n");
			}
			
			// Choice 6. Show the tree in post-order.
			else if (choice == 6) {
				System.out.println("Tree in post-order:");
				tree.postOrder();	
				System.out.println("\n");
			}
			
			// Choice 7. Exit.
			else if (choice == 7) {
				System.out.println("Goodbye!");
				exit = true;
			}
						
			// if choice is out of bounds display this
			else {
				System.out.println("Invalid Choice. Please enter integers between 1 and 7.");
				System.out.println();
			}
		}
		sc.close();	// close scanner
	}
	
	// function to print menu
	public static void printMenu() {
		System.out.println("Please enter a number for which option you would like to choose:");
		System.out.println("1. Add an element to the tree.");
		System.out.println("2. Remove an element from the tree.");
		System.out.println("3. Search for an element in the tree.");
		System.out.println("4. Show the tree in in-order.");
		System.out.println("5. Show the tree in pre-order.");
		System.out.println("6. Show the tree in post-order.");
		System.out.println("7. Exit.");
		System.out.println();
		System.out.print("Menu choice > ");
	}
}
