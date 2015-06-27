package ba.bitcamp.task234;

public class Main {

	public static void main(String[] args) {
		Autor a = new Autor("Charles Bukowski", "Male" , "bukowski@gmail.com");
		
		Book b = new Book ("Charles Bukowski", "Male" , "bukowski@gmail.com","Womens" , 100);
		Book b1 = new Book ("Charles Bukowski", "Male" , "bukowski@gmail.com"," Notes of a Dirty Old Man" , 100);
		Book b2 = new Book ("Charles Bukowski", "Male" , "bukowski@gmail.com"," Shakespeare Never Did This " , 100);
	
		Book[] books = {b, b1};
		Book[] books1 = {b2};
		
		BookStore bs = new BookStore ("Charles Bukowski", "Male" , "bukowski@gmail.com","Womens" , 100 , "Knjizara", books);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(bs);
		
		System.out.println(bs.getBook(b));
		
		bs.setBook(books1);
		
		System.out.println(bs);
		
	

	}

}