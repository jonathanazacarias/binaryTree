package binary_tree;

public class BinarySearchTree {

	public static void main(String[] args) {
		// test our binary search tree using assertions
		//first we will test our "isEmpty" method
		assert true; // precondition of an empty binary tree is simple
		Tree t1 = new Tree();
		assert t1.isEmpty():"Failure, tree is not empty"; 
		
		// next we will test that our insert method is working
		t1.insertNode(5);
		assert !t1.isEmpty():"Failure, did not insert a node";
		
		// next we will test our tree search method
		assert t1.treeContains(5):"Failure, did not find node";
		
		// next we will test we can delete a single node
		t1.deleteNode(5);
		assert t1.isEmpty(): "Failure, did not delete node";
		
		// test if the printTree method is printing the tree properly
		
		
		System.out.println("Basic testing success");
		
		// next we will test the ability for our binary tree to 
		// properly input a random set of numbers
		int [] randomTen = generateRandomNumberList(); // generate random list of 10 ints
		// input the numbers into our tree
		for (int i = 0; i<randomTen.length; i++) {
			t1.insertNode(randomTen[i]);
		}
		t1.getTree();
		
		
		
		System.out.println("Success");
	}
	
	// method to generate a random set of 10 numbers between 1-100
	public static int[] generateRandomNumberList() {
		int[] numList = new int[10];
		for(int i = 0; i<10; i++) {
			numList[i] = (int) (Math.random() * (100 - 1)) + 1;
		}
		return numList;
	}
	

}
