// Student name: Rawad Aboudlal
// Student number: 8262710
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

	Node<E> lowestCommonAncestor = findLowestCommonAncestor(root, low, high);

	return count(root, low) + count(root, high) - (2 * (count(root, lowestCommonAncestor.value)) - 1);

    }

    /**
     * This is the helper method that does all the work in terms of counting the
     * number of elements from a {@link Node} to a {@link Node}, with element as its
     * value, in the tree.
     * 
     * @param node
     *            The {@link Node} to start counting from.
     * @param value
     *            The element whose {@link Node} we count to.
     * @return The number of nodes from <code>node</code> to <code>value</code>,
     *         inclusively.
     * @see #findLowestCommonAncestor(Node, Comparable, Comparable)
     */
    private int count(Node<E> node, E value) {

	if (node == null) {
	    return 0;
	}

	int valueCompareNode = value.compareTo(node.value);

	if (valueCompareNode > 0) {
	    return 1 + count(node.right, value);
	} else if (valueCompareNode < 0) {
	    return 1 + count(node.left, value);
	} else {
	    return 1;
	}

    }

    /**
     * This is a helper method that find the lowest common ancestor between two
     * elements in the tree. A {@link Node} is considered a "lowest common ancestor"
     * (LCA) between two other nodes further down in the tree if:
     * <ol>
     * <li>This LCA has one node in its left subtree <b>and</b> the other node in
     * its right subtree; or</li>
     * <li>This LCA has both nodes in its left subtree; or</li>
     * <li>This LCA has both nodes in its right subtree</li>
     * </ol>
     * </br>
     * Note that this implementation uses two {@link Comparable} values that are in
     * this tree to find the LCA.
     * 
     * @param node
     *            The current {@link Node} used to check whether it matches the
     *            criteria of a LCA node.
     * @param value1
     *            The value of the first node.
     * @param value2
     *            The value of the second node.
     * @return The lowest common ancestor node of <code>value1</code> and
     *         <code>value2</code> in this tree.
     */
    private Node<E> findLowestCommonAncestor(Node<E> node, E value1, E value2) {

	if (node == null) {
	    return null;
	}

	if (node.value.compareTo(value1) == 0 || node.value.compareTo(value2) == 0) {
	    return node;
	}

	Node<E> left = findLowestCommonAncestor(node.left, value1, value2);
	Node<E> right = findLowestCommonAncestor(node.right, value1, value2);

	if (left != null && right != null) {
	    return node;
	}

	if (left != null) {
	    return left;
	} else {
	    return right;
	}

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
