package stackandqueues;

public class QueueListDouble {

	private Node start;
	private Node finish;

	public QueueListDouble() {
		start = null;
		finish = null;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public boolean add(Double value) {
		Node n = new Node(value);

		if (start == null) {
			start = n;
			finish = n;
		} else if (start == finish) {
			n.prev = start;
			finish = n;
			start.next = n;
		} else {
			finish.next = n;
			n.prev = finish;
			finish = n;
		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public Double poll() {
		try {
			Double tmp = start.value;
			start = start.next;
			start.prev = null;
			return tmp;
		} catch (NullPointerException ex) {
			return null;
		}
	}

	/**
	 * s
	 * 
	 * @return
	 */
	public Double peek() {
		if (start == null) {
			return null;
		}

		return start.value;
	}

	/**
	 * 
	 * @return
	 */
	public Double peekLast() {
		if (finish == null) {
			return null;
		}

		return finish.value;
	}

	/**
	 * 
	 * @author KrisTina
	 *
	 */
	private class Node {
		Double value;
		Node prev;
		Node next;

		public Node(Double value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		QueueListDouble q = new QueueListDouble();
		System.out.println(q.peek());
		System.out.println(q.add(2.4));
		System.out.println(q.add(5.3));
		System.out.println(q.add(7.1));
		System.out.println(q.add(7.1));
		System.out.println(q.add(7.1));
		System.out.println(q.add(7.1));
		System.out.println(q.add(7.1));
		System.out.println(q.add(7.1));
		System.out.println(q.add(5.3));
		System.out.println(q.add(5.3));
		System.out.println(q.add(5.3));
		System.out.println(q.add(5.3));
		System.out.println(q.peek());
		System.out.println(q.peekLast());
		System.out.println(System.currentTimeMillis() - t1);
	}

}
