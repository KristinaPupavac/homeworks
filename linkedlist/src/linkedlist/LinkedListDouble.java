package linkedlist;

import java.util.NoSuchElementException;

public class LinkedListDouble {
	private Node start;
	private int size;

	/**
	 * Empty constructor, empty list
	 */
	public LinkedListDouble() {
		this.start = null;
		this.size = 0;
	}

	/**
	 * Constructor accepts LinkedListDouble object and copies all the elements
	 * in the list.
	 * 
	 * @param l
	 *            - LinkedListDouble object
	 */
	public LinkedListDouble(LinkedListDouble l) {
		for (int i = 0; i < l.size; i++) {
			add(l.get(i));
		}
	}

	/**
	 * Method adds elments to list
	 * 
	 * @param element
	 *            - adding element
	 */
	public void add(Double element) {
		if (start == null) {
			start = new Node(element);
		} else {
			Node last = getLastNode();

			last.setNext(new Node(element));
		}
		size++;
	}

	/**
	 * Metod returns last node in list
	 * 
	 * @return - last node
	 */
	private Node getLastNode() {
		if (start == null) {
			return null;
		}

		Node temp = start;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		return temp;
	}

	/**
	 * Removing node form list
	 * 
	 * @param index
	 *            - index of node which we want to remove
	 */
	public void remove(int index) {
		Node previous = start;

		for (int i = 0; i < index; i++) {
			if (previous == null) {
				throw new NoSuchElementException();
			}
			previous = previous.getNext();
		}

		if (previous.getNext() == null) {
			throw new NoSuchElementException();
		}
		Node temp = previous.getNext();

		previous.setNext(temp.getNext());
		size--;
	}

	/**
	 * Returns the node located at the given index
	 * 
	 * @param index
	 * @return
	 * @throws NoSuchElementException
	 */
	public double get(int index) throws NoSuchElementException {
		Node temp = start;
		for (int i = 0; i < index; i++) {
			if (temp == null) {
				throw new NoSuchElementException();
			}
			temp = temp.getNext();
		}
		return temp.getValue();
	}

	/**
	 * Returns previous node
	 * 
	 * @param n
	 * @return
	 */
	public Node getPreviousNode(Node n) {
		if (n == start) {
			return null;
		}

		Node temp = start;
		while (temp.getNext() != n) {
			temp = temp.getNext();
		}

		return temp;
	}

	/**
	 * Returns list size
	 * 
	 * @return - size
	 */
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		if (start == null) {
			return "The list is empty";
		}

		return start.toString();
	}

	/**
	 * Returns middle list node value
	 * 
	 * @return
	 */
	public double getMiddlle() {
		return get((size - 1) / 2);
	}

	/**
	 * Returns first list node value
	 * 
	 * @return
	 */
	public double getFirst() {
		return start.getValue();
	}

	/**
	 * Returns last node value
	 * 
	 * @return
	 */
	public double getLast() {
		return get(size - 1);
	}

	/**
	 * Delete first node in list
	 */
	public void deleteFirst() {
		start = start.getNext();
		size--;
	}

	/**
	 * Delete last node in list
	 */
	public void deleteLast() {
		// Node last = getLastNode();
		remove(size - 2);
		size--;
	}

	/**
	 * Adding node on index, and setting value
	 * 
	 * @param d
	 * @param index
	 */
	public void add(Double d, int index) {
		Node previous = start;
		for (int i = 0; i < index - 1; i++) {
			previous = previous.getNext();
		}
		Node temp = new Node(d);
		temp.setNext(previous.getNext());
		previous.setNext(temp);
	}

	/**
	 * 
	 * @author KrisTina
	 *
	 */
	public class Node {
		private double value;
		private Node next;

		/**
		 * Default constructor
		 * 
		 * @param value
		 */
		public Node(double value) {
			this.value = value;
		}

		/**
		 * @return the value
		 */
		public double getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(double value) {
			this.value = value;
		}

		/**
		 * @return the next
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * @param next
		 *            the next to set
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			if (next == null) {
				return value + "";
			}

			return value + " " + next.toString();
		}
	}
}
