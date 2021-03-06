package weekendhomework05;


public class Protagonist extends Character {

	Goal goal;
	Character[] asistents;
	Character enemy;

	/**
	 * @param name
	 * @param gener
	 * @param isAlive
	 * @param isCapable
	 * @param goal
	 * @param characters
	 * @param character
	 */
	public Protagonist(String name, String gener, Boolean isAlive,
			Boolean isFit, Goal goal) {
		super(name, gener, isAlive, isFit);
		this.goal = goal;
	}
     
	/**
	 * @return the goal
	 */
	public Goal getGoal() {
		return goal;
	}

	/**
	 * @param goal the goal to set
	 */
	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	/**
	 * @return the asistents
	 */
	public Character[] getAsistents() {
		return asistents;
	}

	/**
	 * @param asistents the asistents to set
	 */
	public void setAsistents(Character[] asistents) {
		this.asistents = asistents;
	}

	/**
	 * @return the enimy
	 */
	public Character getEnemy() {
		return enemy;
	}

	/**
	 * @param enimy the enimy to set
	 */
	public void setEnemy(Character enemy) {
		this.enemy = enemy;
	}

	/**
	 * 
	 * @param character
	 */
	public void addAsistant(Character asistent) {
		if (asistents.length >= 4) {
			throw new IndexOutOfBoundsException();
		} else {
			for (int i = 0; i < asistents.length; i++) {
				if (asistents[i] == null) {
					asistents[i] = asistent;
					break;
				}
			}
		}
	}
	
	public void attainGoal() {
		int chance = 0;
		if(getIsAlive()) {
			
			if(getIsFit()){
				if (chance + 40 < 100) {
					chance += 40;
				} else {
					chance = 100;
				}
			}
			for (int i = 0; i < asistents.length; i++) {
				if(asistents[i].isFit){
					if (chance + 20 < 100) {
						chance += 20;
					} else {
						chance = 100;
					}
				}
			}
			if(enemy != null && enemy.getIsFit()){
				if (chance - 30 > 0) {
					chance -= 30;
				} else {
					chance = 0;
				}
			}
			if(goal.getHeaviness() == Goal.DIFFICULT){
				if (chance - 20 > 0) {
					chance -= 20;
				} else {
					chance = 0;
				}
			} else if (goal.getHeaviness() == Goal.IMPOSSIBLE) {
				// if goal is impossible chances will be decreased by 100%,
				// but it cannot go under 0 %, so we will set it to zero, immediately
				chance = 0;
			}
		} else {
			System.out.println("Your protagonist is already dead :(");
		}
		
		if (chance >= 50) {
			System.out.println("Protagonist has succeed at his goal: "
					+ this.goal.getName());
		
		} else if (chance < 50) {
			System.out.println("Protagonist not achieve the goal: "
					+ this.goal.getName());
			enemy.killCharacter();
			enemy.makeFit();
		}
	}
}
