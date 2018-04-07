// Student name: Rawad Aboudlal
// Student number: 8262710
// Course code: ITI 1121-C

// Assignment: #4

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    private static class Node<T> {

	private T value;
	private Node<T> prev;
	private Node<T> next;

	private Node(T value, Node<T> prev, Node<T> next) {
	    this.value = value;
	    this.prev = prev;
	    this.next = next;
	}
    }

    private Node<E> head;
    private int size;

    public LinkedList() {
	head = new Node<E>(null, null, null); // dummy node!
	head.prev = head.next = head;
	size = 0;
    }

    /**
     * An {@link Iterator} that is made specifically to iterate through this
     * {@link LinkedList}.
     * 
     * @author Rawad Aboudlal (rabou017@uottawa.ca)
     * 
     * @see LinkedList
     * 
     */
    private class LinkedListIterator implements Iterator<E> {

	private Node<E> current = head;
	private int nextIndex;

	/**
	 * Initializes this {@link LinkedListIterator} with the given
	 * <code>nextIndex</code>.
	 * 
	 * @param nextIndex
	 *            The index returned by calling this iterator's {@link #nextIndex}
	 *            method.
	 */
	private LinkedListIterator(int nextIndex) {
	    this.nextIndex = nextIndex;

	    for (int i = 0; i < nextIndex; i++) {
		current = current.next;
	    }

	}

	/**
	 * Base constructor, initializing {@link nextIndex} to a value of 0.
	 */
	private LinkedListIterator() {
	    nextIndex = 0;
	}

	/**
	 * Returns <code>true</code> if this iterator has more elements to iterate over
	 * from this {@link LinkedList}.
	 * 
	 * @return <code>true</code> if the <code>Node</code> after {@link #current} is
	 *         not the {@link LinkedList#head} <code>Node</code>.
	 * 
	 * @see Iterator#hasNext()
	 * 
	 */
	@Override
	public boolean hasNext() {
	    return (current.next != head);
	}

	/**
	 * Gets the next element in this {@link LinkedList} at the position of
	 * {@link #nextIndex}.
	 * 
	 * @return The next element according to this iterator.
	 * 
	 * @see Iterator#next()
	 * 
	 */
	@Override
	public E next() {

	    if (!hasNext()) {
		throw new NoSuchElementException();
	    }

	    current = current.next;

	    nextIndex++;

	    return current.value;
	}

	/**
	 * @see Iterator#nextIndex()
	 */
	@Override
	public int nextIndex() {
	    return nextIndex;
	}

    }

    @Override
    public Iterator<E> iterator() {
	return new LinkedListIterator();
    }

    @Override
    public int size() {
	return size;
    }

    @Override
    public E get(int index) {

	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException(Integer.toString(index));
	}

	Node<E> p = head.next;

	for (int i = 0; i < index; i++) {
	    p = p.next;
	}

	return p.value;
    }

    @Override
    public void addFirst(E elem) {

	if (elem == null) {
	    throw new NullPointerException();
	}

	Node<E> second = head.next;

	head.next = new Node<E>(elem, head, second);
	second.prev = head.next;

	size++;
    }

    public void add(E elem) {

	if (elem == null) {
	    throw new NullPointerException();
	}

	Node<E> before = head.prev, after = head;

	before.next = new Node<E>(elem, before, after);
	after.prev = before.next;

	size++;
    }

}
