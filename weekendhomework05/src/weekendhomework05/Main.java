package weekendhomework05;


public class Main {

	public static void main(String[] args) {
		
		Event e = new Event (0);
		Character wolf = new Character ("vuk", "male", true, true);
		Goal g = new Goal (3, e, wolf);
		Protagonist p = new Protagonist ("crvenkapa", "female", true, false, g);
		p.setIsFit(true);
		Character lovac = new Character ("Lovac", "male", true, true);
		Character baka = new Character ("baka", "female", true, true);
		Character medo = new Character ("medo", "male", true, true);
		Character mama = new Character ("mama", "female", true, true);
		Character[] asisents = {lovac, baka};
		p.setAsistents(asisents);
		p.addAsistant(mama);
		p.addAsistant(medo);
		g.name = "win";
		p.attainGoal();
		
//		Character wolf = new Character ("vuk", "male", true, true);
//		Character lovac = new Character ("Lovac", "male", true, true);
//		Character baka = new Character ("baka", "female", true, true);
//		
//		Event e1 = new Event(3);
//		
//		Goal g1 = new Goal(2, e1, wolf);
//		
//		wolf.setIsFit(true);
//		lovac.setIsAlive(false);
//		Character[] asisents = {lovac, baka};
//		
//		
//		wolf.killCharacter();
//		
//		
//		System.out.println(g1.getHeaviness());

	}

}