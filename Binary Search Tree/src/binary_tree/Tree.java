package binary_tree;

public class Tree {

	private Node root;

	/**
	 * 
	 */
	public Tree() {
		root = null;
	}
	
	public boolean isEmpty() {
		if(root==null) {
			return true;
		}else {
			return false;
		}
	}
	
	// Code to add a node
	public void insertNode(int value) {
		root = addNode(root,value);
	}
	
	private Node addNode(Node n, int value) {
		// Test all cases and add nodes recursively
		if(n==null) {
			return new Node(value);
		}
		// test if value is greater or smaller than node being inspected
		// if value of inspected node is greater than our value then traverse left (smaller) 
		if(n.getValue()>value) {
			n.setLeft(addNode(n.getLeft(),value));
		}
		// if value of inspected node is less than our value then traverse right (larger)
		else if (n.getValue()<value) {
			n.setRight(addNode(n.getRight(),value));
		}
		// value already exists in the tree
		else {
			return n;
		}
		return n;	
	}
	
	// method to delete a node
	public void deleteNode(int value) {
		root = removeNode(root, value);
	}
	
	private Node removeNode(Node n, int value) {
		if(n == null) {
			return null;
		}
		if(n.getValue()>value) {
			n.setLeft(removeNode(n.getLeft(),value));
			return n;
		}else if(n.getValue()<value) {
			n.setRight(removeNode(n.getRight(),value));
			return n;
		}else {
			// if node has no children
			if(n.getLeft()==null&&n.getRight()==null) {
				return null;
			}else if(n.getRight()==null) {
				return n.getLeft();
			}else if(n.getLeft()==null) {
				return n.getRight();
			}
			else {
				int smallestValue = findSmallestValue(n.getRight());
				n.setValue(smallestValue);
				n.setRight(removeNode(n.getRight(), smallestValue));
				return n;
			}
		}
	}
	
	private int findSmallestValue(Node root) {
	    return root.getLeft() == null ? root.getValue() : findSmallestValue(root.getLeft());
	}
	
	// method to search for a node
	public boolean treeContains(int value) {
		return treeSearch(root,value);
	}

	private boolean treeSearch(Node n, int value) {
		if(n==null) {
			return false;
		}
		if(n.getValue()>value) {
			return treeSearch(n.getLeft(),value);
		}else if(n.getValue()<value) {
			return treeSearch(n.getRight(),value);
		}
		else {
			return true;
		}
	}
	
	public void getTree() {
		printNode(root);
	}
	
	private void printNode(Node n) {
	    if (n == null) {
	      return;
	    } 
	    printNode(n.getLeft());
	    System.out.println(n.getValue());
	    printNode(n.getRight());
	}
	
}
