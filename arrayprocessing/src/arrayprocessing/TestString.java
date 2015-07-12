package arrayprocessing;

public class TestString {

	public static void main(String[] args) {
		
		DynamicString str = new DynamicString(3);
		
		System.out.println(str);
		
		str.addElement("abc");
		System.out.println(str);
		
		String s = "String for testing dinamicstring class";
		String[] s1 = s.split(" ");
		str.addArray(s1);
		System.out.println(str);
	
		str.addElement("ghi");
		System.out.println(str);
		
		str.removeQuick(4);
		System.out.println(str);
		
		str.removeSlow(5);
		System.out.println(str);

	}

}
