package ba.bitcamp.task5;
/**
 * 
 * @author KrisTina
 *
 */
public class Date {
	private int month;
	private int day;
	private int year;

	/**
	 * @param month
	 * @param date
	 * @param year
	 */
	public Date(int date) {
		this.month = 1;
		this.day = date;
		this.year = 1;
	}

	/**
	 * @param month
	 * @param date
	 * @param year
	 */
	public Date(int month, int date) {
		this.month = month;
		this.day = date;
		this.year = 1;
	}

	/**
	 * @param month
	 * @param date
	 * @param year
	 */
	public Date(int month, int date, int year) {
		this.month = month;
		this.day = date;
		this.year = year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 * @throws IndexOutOfBoundsException
	 *             ("Month is between 1 and 12!")
	 */
	public void setMonth(int month) {
		if (month >= 1 && month <= 12) {
			this.month = month;
		} else {
			throw new IndexOutOfBoundsException("Month is between 1 and 12!");
		}

	}

	/**
	 * @return the date
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDay(int date) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12 && date >= 1 && date <= 31) {
			this.day = date;
		} else if (month == 4 || month == 6 || month == 9 || month == 11
				&& date >= 1 && date <= 30) {
			this.day = date;
		} else if (month == 2 && year % 4 == 0 && date >= 1 && date <= 28) {
			this.day = date;
		} else if (month == 2 && date >= 1 && date <= 29) {
			this.day = date;
		} else {
			throw new IndexOutOfBoundsException("Wrong date!");
		}

	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		if (year > 0) {
			this.year = year;
		} else {
			throw new IndexOutOfBoundsException("Year can't bee nagativ!");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	/**
	 * 
	 */
	public String toString() {
		return month + "." + day + "." + year + ".";
	}
     
	/**
	 * 
	 * @param month
	 * @param date
	 * @param year
	 * @return
	 */
	public void DayPassed () {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10) {
			day = day + 1;
			if (day > 31) {
				day = 1;
				month++;
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			day = day + 1;
			if (day > 30) {
				day = 1;
				month++;
			}
		} else if (month == 2) {
			day = day + 1;
			if (day > 28) {
				day = 1;
				month++;
			}
		} else if (month == 12 && day == 31) {
			day = 1;
			month = 1;
			year++;
		}

	}
	
	/**
	 * 
	 */
	public void MonthPassed () {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10) {

			if (day > 31) {
				day = 1;
				month++;
			} else if (month == 12) {
				month = 1;
				year++;
			} else {
				month++;
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {

			if (day > 30) {
				day = 1;
				month++;
			} else {
				month++;
			}
		} else if (month == 2) {

			if (day > 28) {
				day = 1;
				month++;
			} else {
				month++;
			}
		}

		if (month == 12 && day == 31) {
			month = 1;
			day = 1;
			year++;
		} else if (month == 1 && day == 1) {
			month++;
		} else if (month == 12 && day < 31) {

			month = 1;
			year++;
		}
		
	}

}