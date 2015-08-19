package ba.bitcamp.task234;

/**
 * 
 * @author KrisTina
 *
 */
public class Book extends Autor {
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int TREE = 3;

	private String tittle;
	private Integer price;

	/**
	 * 
	 * @param name
	 * @param gener
	 * @param mail
	 * @param tittle
	 * @param price
	 */
	public Book(String name, String gener, String mail, String tittle,
			Integer price) {
		super(name, gener, mail);
		this.tittle = tittle;
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return tittle;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String tittle) {
		this.tittle = tittle;
	}

	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @return the one
	 */
	public static int getOne() {
		return ONE;
	}

	/**
	 * @return the two
	 */
	public static int getTwo() {
		return TWO;
	}

	/**
	 * @return the tree
	 */
	public static int getTree() {
		return TREE;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Book other = (Book) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (tittle == null) {
			if (other.tittle != null)
				return false;
		} else if (!tittle.equals(other.tittle))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book tittle: " + tittle + ", price: " + price + " ";
	}


}