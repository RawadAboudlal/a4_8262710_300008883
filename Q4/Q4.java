// Student name: Rawad Aboudlal, Ismail Ali 
// Student number: 8262710, 300008883
// Course code: ITI 1121-C

// Assignment: #4

public class Q4 {

    public static void main(String[] args) {

	StudentInfo.display();

	BinarySearchTree<Integer> bTree;
	bTree = new BinarySearchTree<Integer>();

	bTree.add(4);
	bTree.add(2);
	bTree.add(3);
	bTree.add(1);
	bTree.add(5);
	bTree.add(6);
	bTree.add(8);
	bTree.add(9);
	bTree.add(7);

	System.out.println(bTree.count(3, 6));

	bTree = new BinarySearchTree<Integer>();

	bTree.add(8);
	bTree.add(3);
	bTree.add(10);
	bTree.add(1);
	bTree.add(6);
	bTree.add(14);
	bTree.add(4);
	bTree.add(7);
	bTree.add(13);

	System.out.println(bTree.count(3, 6));

	// Should output 8.
	System.out.println(bTree.count(1, 13));

    }
}
