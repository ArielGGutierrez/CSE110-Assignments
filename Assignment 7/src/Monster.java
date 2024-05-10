// CSE 110     : 86854 / iCourse
// Assignment  : #7
// Author      : Ariel G. Gutierrez 1218982505
// Description : This program creates a monster class for a monster fight simulation

class Monster
{
	private String name;     // Name of the monster
	private int healthScore; // Current health of the monster
	private Weapon weapon;   // Weapon that the monster uses
	
	/**
	 * This constructor sets the name, health and weapon that the new monster has
	 * @param name String the name of the monster
	 * @param healthScore int the health of the monster
	 * @param weapon Weapon the weapon that the monster carries
	 */
	public Monster(String name, int healthScore, Weapon weapon)
	{
		this.name = name;
		this.healthScore = healthScore;
		this.weapon = weapon;
	}
	
	/**
	 * This method returns the name of the monster
	 * @return String the name of the monster
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * This method returns the current health of the monster
	 * @return int the current health of the monster
	 */
	public int getHealthScore()
	{
		return this.healthScore;
	}
	
	/**
	 * This method returns the name of the weapon that the monster is carrying
	 * @return String the name of the weapon the monster is carrying
	 */
	public String getWeaponName()
	{
		return weapon.getName();
	}
	
	/**
	 * This method simulates the current monster attacking the monster object that was passed
	 * @param target Monster the target that the current monster is attacking
	 * @return int the amount of damage the current monster does
	 */
	public int attack(Monster target)
	{
		/* Gets the damage the weapon does as a fraction of its maximum damage */
		int damage = (int) (Math.random() * weapon.getMaxDamage());
		
		target.healthScore -= damage; // Lowers the health of the target monster
		
		return damage;
	}
}
