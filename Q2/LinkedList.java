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

    private class LinkedListIterator implements Iterator<E> {

	private Node<E> current = head;
	private int nextIndex;

	private LinkedListIterator(int nextIndex) {
	    this.nextIndex = nextIndex;

	    for (int i = 0; i < nextIndex; i++) {
		current = current.next;
	    }

	}

	private LinkedListIterator() {
	    nextIndex = 0;
	}

	@Override
	public boolean hasNext() {
	    return (current.next != head);
	}

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
