package arrayprocessing;

public class Test {

	public static void main(String[] args) {
		DynamicDouble array1 = new DynamicDouble(3);

		System.out.println(array1);
		array1.addElement(4);
		System.out.println(array1);
		
		double [] array = {2, 4, 5};
		array1.addArray(array);
		System.out.println(array1);
		
		array1.addElement(7);
		array1.size();
		System.out.println(array1.toString());
		array1.removQuick(5);
		System.out.println(array1.toString());
		
		array1.removSlow(1);
		System.out.println(array1.toString());

	}

}
