// CSE 110     : 86854 / iCourse
// Assignment  : 8
// Author      : Ariel G. Gutierrez 1218982505
// Description : This class creates a player object with their name, attack stat, and block stat

class Player
{
	private String name;	   // Name of the player
	private double attackStat; // Attack stat of the player
	private double blockStat;  // Block stat of the player
	
	/**
	 * Creates a new player with the name and stat parameters passed
	 * @param name String The name of the player
	 * @param attackStat double The attack stat of the player
	 * @param blockStat doubel The block stat of the player
	 */
	public Player(String name, double attackStat, double blockStat)
	{
		this.name = name;
		this.attackStat = attackStat;
		this.blockStat = blockStat;
	}
	
	/**
	 * Gets the name of the player object
	 * @return String Name of the player
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Gets the attack stat of the player
	 * @return double Attack stat
	 */
	public double getAttackStat()
	{
		return this.attackStat;
	}
	
	/**
	 * Gets the block stat of the player
	 * @return double Block stat
	 */
	public double getBlockStat()
	{
		return this.blockStat;
	}
	
	/**
	 * Sets the attack stat of the player
	 * @param attackStat double Attack stat to set
	 */
	public void setAttackStat(double attackStat)
	{
		this.attackStat = attackStat;
	}
	
	/**
	 * Sets the block stat of the player
	 * @param blockStat double Block stat to set
	 */
	public void setBlockStat(double blockStat)
	{
		this.blockStat = blockStat;
	}
	
	/**
	 * Prints the player's name, attack stat, and block stat
	 */
	public void printPlayerInfo()
	{
		System.out.printf(name + " (attack = %.2f, block = %.2f)%n",  attackStat, blockStat);
	}
}