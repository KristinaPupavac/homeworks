package ba.bitcamp.task5;

public class Main {

	public static void main(String[] args) {
		Date d1 = new Date(4);

		Date d2 = new Date(5, 100);
		
		Date d = new Date(6, 20, 2015);

		System.out.println(d1);
		System.out.println(d2);

		d.MonthPassed();

		d.DayPassed();
		System.out.println(d);

	}

}
