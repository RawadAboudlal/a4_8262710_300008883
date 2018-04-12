// Student name: Rawad Aboudlal, Ismail Ali
// Student number: 8262710, 300008883
// Course code: ITI 1121-C

// Assignment: #4

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<T> {
	private T value;
	private Node<T> left;
	private Node<T> right;

	private Node(T value) {
	    this.value = value;
	    left = null;
	    right = null;
	}
    }

    private Node<E> root = null;

    /**
     * Calculates the number of elements in the tree that are greater than or equal
     * to <code>low</code> and smaller than or equal to <code>high</code>.
     * 
     * @param low
     *            The smaller element/lower bound to start counting from.
     * @param high
     *            The larger element/upper bound to stop counting at.
     * @return The number elements that are greater than or equal to
     *         <code>low</code> and less than or equal to <code>high</code>,
     *         inclusively.
     * @see #count(Node, Comparable, Comparable)
     */
    public int count(E low, E high) {

	if (low == null || high == null) {
	    return 0;
	}

	return count(root, low, high);

    }

    /**
     * <p>
     * This is the helper method that does all the work for
     * {@link #count(Comparable, Comparable)}.
     * </p>
     * 
     * <p>
     * This method will compare the value stored in <code>node</code> with that of
     * <code>low</code> and <code>high</code>. If the value of <code>node</code> is
     * both greater than or equal to that of <code>low</code> <b>and</b> less than
     * or equal to <code>high</code> then we will count this node <i>and</i> count
     * the number of nodes in both subtrees of this <code>node</code>, until
     * <code>low</code> and <code>high</code> are found. Once <code>low</code> is
     * found, we will check the right subtree of <code>node</code> until
     * <code>high</code> is found. The same goes for
     * <code>high<code>; once it is found, the function will continue to call itself until <code>low</code>
     * is found. Once both are found, 0 is returned.
     * </p>
     * 
     * @param node
     *            The {@link Node} to start counting from.
     * @param low
     *            The lower value.
     * @param high
     *            The higher value.
     * @return The number of elements, in this {@link BinarySearchTree}, greater
     *         than or equal to <code>low</code> and less than or equal to
     *         <code>high</code>.
     */
    private int count(Node<E> node, E low, E high) {

	if (node == null) {
	    return 0;
	}

	int nodeCompareLow = node.value.compareTo(low);
	int nodeCompareHigh = node.value.compareTo(high);

	if (nodeCompareLow >= 0 && nodeCompareHigh <= 0) {
	    return 1 + count(node.left, low, high) + count(node.right, low, high);
	}

	if (nodeCompareLow >= 0) {
	    return 1 + count(node.right, low, high);
	}

	if (nodeCompareHigh <= 0) {
	    return 1 + count(node.left, low, high);
	}

	return 0;

    }

    /**
     * Inserts an object into this BinarySearchTree.
     *
     * @param elem
     *            item to be added
     * @return true if the object has been added and false otherwise
     */

    public boolean add(E elem) {

	// pre-condtion:

	if (elem == null) {
	    throw new NullPointerException();
	}

	// special case:

	if (root == null) {
	    root = new Node<E>(elem);
	    return true;
	}

	// general case:

	return add(elem, root);
    }

    // Helper method

    private boolean add(E elem, Node<E> current) {

	boolean result;
	int test = elem.compareTo(current.value);

	if (test == 0) {
	    result = false; // already exists, not added
	} else if (test < 0) {
	    if (current.left == null) {
		current.left = new Node<E>(elem);
		result = true;
	    } else {
		result = add(elem, current.left);
	    }
	} else {
	    if (current.right == null) {
		current.right = new Node<E>(elem);
		result = true;
	    } else {
		result = add(elem, current.right);
	    }
	}
	return result;
    }

    @Override
    public String toString() {
	return toString(root);
    }

    private String toString(Node<E> current) {

	if (current == null) {
	    return "()";
	}

	return "(" + toString(current.left) + current.value + toString(current.right) + ")";
    }

}
