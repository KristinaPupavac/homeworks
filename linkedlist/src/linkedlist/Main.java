package linkedlist;

public class Main {

	public static void main(String[] args) {
		LinkedListDouble list = new LinkedListDouble();
		System.out.println(list.toString());
		
		list.add(3.5);
		list.add(4.5);
		list.add(3.4);
		
		System.out.println(list);
		
		System.out.println(list.size());
		
		list.remove(1);
		System.out.println(list);
		System.out.println(list.get(0));
		
		LinkedListDouble list1 = new LinkedListDouble (list);
		
		System.out.println(list1);
		
		list1.add(74.5);
		list1.add(54.3);
		list1.add(67.89);
		
		System.out.println(list1);
		System.out.println(list1.getMiddlle());
		System.out.println(list1.getLast());
		list1.deleteLast();
		System.out.println(list1);
	
		list1.deleteFirst();
		System.out.println(list1);
		
		list1.add(1.2, 2);
		System.out.println(list1);
	}

}
