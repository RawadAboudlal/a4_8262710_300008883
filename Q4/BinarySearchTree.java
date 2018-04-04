// Student name: Rawad Aboudlal
// Student number: 8262710
// Course code: ITI 1121-C

// Assignment: #4

/**
 * @author Marcel Turcotte
 */

/**
 * 
 * @author Rawad Aboudlal (rabou017@uottawa.ca)
 *
 * @param <E>
 */
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

    public int count(E low, E high) {

	if (low == null || high == null) {
	    return 0;
	}

	Node<E> lowestCommonAncestor = findLowestCommonAncestor(root, low, high);

	return count(root, low) + count(root, high) - (2 * (count(root, lowestCommonAncestor.value)) - 1);

    }

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
