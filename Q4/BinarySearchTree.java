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
     * <p>
     * Calculates the number of elements in the tree that are greater than or equal
     * to <code>low</code> and smaller than or equal to <code>high</code>.
     * </p>
     * 
     * <p>
     * In order to do this, this method first calculates the distance from the
     * {@link #root} element to each of <code>low</code> and <code>high</code>. Then
     * it will find the lowest common ancestor, in this binary tree, of these two
     * elements. Finally, to get the number of elements between <code>low</code> and
     * <code>high</code>, the following formula is applied: </br>
     * </br>
     * <code>distance = count(root, low) + count(root, high) - (2 * count(root,
     * lowestCommonAncestor) - 1)</code>
     * </p>
     * 
     * @param low
     *            The smaller element/lower bound to start counting from.
     * @param high
     *            The larger element/upper bound to stop counting at.
     * @return The number elements between <code>low</code> and <code>high</code>,
     *         inclusively.
     * @see #count(Node, Comparable)
     */
    public int count(E low, E high) {

	if (low == null || high == null) {
	    return 0;
	}

	return count(root, low, high);

    }

    /**
     * This is the helper method that does all the work.
     * 
     * @param node
     *            The {@link Node} to start counting from.
     * @param low
     *            The lower value.
     * @param high
     *            The higher value.
     * @return
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
