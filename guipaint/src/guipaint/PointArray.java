package guipaint;


public class PointArray {
	
	private Point[] ponits;
	private int length;
	
	public PointArray () {
		this.ponits= new Point[10];
		this.length = 0;
		
	}
	
	public void addPoint (Point p) {
		if (length == ponits.length) {
			resize();
		}
		this.ponits[length++] = p;
	}
	
	public int getLength(){
		return length;
	}
	
	/**
	 * vraca tacku na odredjenom indeksu
	 * @param index
	 * @return
	 */
	public Point elementAt(int index){
		return ponits[index];
	}
	
	/**
	 * prosirujemo niz
	 */
	public void resize () {
		Point[] temp = new Point[ponits.length * 2];
		for (int i = 0; i < ponits.length; i++) {
			temp[i] = ponits[i];
			
		}
		ponits = temp;
	}

}
