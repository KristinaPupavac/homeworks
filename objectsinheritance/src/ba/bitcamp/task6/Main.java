package ba.bitcamp.task6;

public class Main {

	public static void main(String[] args) {
		Pet p = new Pet ("Dog", 6, Pet.DOG ); 
		
		System.out.println(p);
		
		Dog d = new Dog ("Dog1", 5, "beagle");
		
		Cat c = new Cat ("Cat" , 3);
		
		System.out.println(d);
		System.out.println(c);

	}
}
