// CSE 110     : 86854 / iCourse
// Assignment  : #7
// Author      : Ariel G. Gutierrez 1218982505
// Description : This program creates a weapon class for a monster fight simulation

class Weapon
{
	private String name;   // Name of the weapon
	private int maxDamage; // Maximum damage the weapon does
	
	
	/**
	 * Default constructor that sets the name of the weapon to "Pointy Stick" and the maximum damage of the weapon to 1.
	 */
	public Weapon()
	{
		name = "Pointy Stick";
		maxDamage = 1;
	}
	
	/**
	 * This constructor sets the name and maximum damage of a weapon to the arguments passed
	 * @param name String name of the weapon
	 * @param maxDamage int maximum damage the weapon does
	 */
	public Weapon(String name, int maxDamage)
	{
		this.name = name;
		this.maxDamage = maxDamage;
	}
	
	/**
	 * This method returns the name of the weapon object
	 * @return string name of the weapon
	 */
	public String getName() 
	{
		return this.name;
	}
	
	/**
	 * This method returns the maximum damage that the weapon object does
	 * @return int maximum damage the weapon does
	 */
	public int getMaxDamage()
	{
		return this.maxDamage;
	}
	
	/**
	 * This method sets the name of the weapon object
	 * @param name String the new name of the weapon
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * This method sets the name maximum damage that the weapon object does
	 * @param maxDamage int the new maximum damage that the weapon does
	 */
	public void setMaxDamage(int maxDamage)
	{
		this.maxDamage = maxDamage;
	}
}
