package stackandqueues;

import java.util.Arrays;

public class QueueArrayDouble {
	Double[] array;

	public QueueArrayDouble() {
		array = new Double[0];
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public boolean add(Double value) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = value;
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	public Double poll () {
		if (array.length > 0) {
			Double temp = array[0];
			array = Arrays.copyOfRange(array, 1, array.length);
			return temp;
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public Double peek () {
		return array[array.length - 1];
	}
	
	/**
	 * 
	 * @return
	 */
	public Double element () {
		return array[0];
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public boolean offer (Double value) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = value;
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	public Double remove () {
			Double temp = array[0];
			array = Arrays.copyOfRange(array, 1, array.length);
			return temp;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueueArrayDouble " + Arrays.toString(array);
	}

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		
		QueueArrayDouble queue = new QueueArrayDouble ();
		System.out.println(queue.poll());
		
		System.out.println(queue.add(4.0));
		System.out.println(queue.add(5.0));
		System.out.println(queue.add(3.0));
		System.out.println(queue.add(3.0));
		System.out.println(queue.add(3.0));
		System.out.println(queue.add(3.0));
		System.out.println(queue.add(3.0));
		System.out.println(queue.add(3.0));
		System.out.println(queue.add(4.0));
		System.out.println(queue.add(4.0));
		System.out.println(queue.add(4.0));
		System.out.println(queue.add(4.0));
		System.out.println(queue.add(4.0));
		System.out.println(queue.add(4.0));
		System.out.println(queue);
		
		System.out.println(queue.peek());
		
		System.out.println(queue.element());
		System.out.println(queue.offer(6.7));
		System.out.println(queue.remove());
		System.out.println(System.currentTimeMillis() - t1);

	}

}
