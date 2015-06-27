package ba.bitcamp.task234;


import java.util.Arrays;

public class BookStore extends Book {
	private String bookStore;
	private Book[] books;

	/**
	 * 
	 * @param name
	 * @param gener
	 * @param mail
	 * @param tittle
	 * @param price
	 * @param bookStore
	 * @param books
	 */
	public BookStore(String name, String gener, String mail, String tittle,
			Integer price, String bookStore, Book[] books) {
		super(name, gener, mail, tittle, price);
		this.bookStore = bookStore;
		this.books = books;
	}

	/**
	 * @return the bookStore
	 */
	public String getBookStore() {
		return bookStore;
	}

	/**
	 * @param bookStore
	 *            the bookStore to set
	 */
	public void setBookStore(String bookStore) {
		this.bookStore = bookStore;
	}

	/**
	 * @return the book
	 */
	public Book getBook(Book b) {
		return b;
	}

	/**
	 * @param book
	 *            the book to set
	 */
	public void setBook(Book[] book) {
		this.books = book;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookStore other = (BookStore) obj;
		if (!Arrays.equals(books, other.books))
			return false;
		if (bookStore == null) {
			if (other.bookStore != null)
				return false;
		} else if (!bookStore.equals(other.bookStore))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookStore: " + bookStore + ", books: "
				+ Arrays.toString(books);
	}

}