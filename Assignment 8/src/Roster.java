// CSE 110     : 86854 / iCourse
// Assignment  : 8
// Author      : Ariel G. Gutierrez 1218982505
// Description : This class creates a roster or collection of players along with their stats

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

class Roster
{
	private ArrayList<Player> players; // Array list of with all the player
	
	/**
	 * Default constructor that instantiates a new array list object
	 */
	public Roster()
	{
		players = new ArrayList<Player>();
	}
	
	/**
	 * Instantiates an array list of players and assigns them based on a file input
	 * @param rosterFile String name of the file that contains the player roster
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Roster(String rosterFile) throws FileNotFoundException, IOException
	{
		players = new ArrayList<Player>(); // Array list of with all the player
		
		/* File object to read inputs from */
		File inputFile = new File(rosterFile);
		
		/* Scanner to scan a line from the input file */
		Scanner fileScanner = new Scanner(inputFile);
		String line = "";
		
		/* Runs until reaching the end of the file */
		while (fileScanner.hasNextLine())
		{
			line = fileScanner.nextLine(); // Current line to read
			
			String[] playerStats = line.split(" "); // Array with tokens of the line
			
			String playerName = playerStats[0] + " " + playerStats[1]; // First 2 tokens are strings corresponding to the player name
			double attackStat = Double.parseDouble(playerStats[2]);    // Next token corresponds to the attack stat
			double blockStat = Double.parseDouble(playerStats[3]);     // Last component corresponds to the block stat
			
			/* Adds this player to the array list */
			addPlayer(playerName, attackStat, blockStat);
			
		}
		
		fileScanner.close(); // Closes the file scanner
		
	}
	
	/**
	 * Adds a player to the roster
	 * @param name String The name of the player
	 * @param attackStat double The attack stat of the player
	 * @param blockStat double The block stat of the player
	 */
	public void addPlayer(String name, double attackStat, double blockStat)
	{
		
		/* Creates a new player object with the passed parameters */
		Player newPlayer = new Player(name, attackStat, blockStat);
		
		players.add(newPlayer); // Adds the new player object to the array list
		
	}
	
	/**
	 * Returns the size of the player roster
	 * @return int The size of the  player roster
	 */
	public int countPlayers()
	{
		return players.size();
	}
	
	/**
	 * Gets a reference to a player object by matching the names
	 * @param playerName String The name of the player to find
	 * @return Player Object reference
	 */
	public Player getPlayerByName(String playerName)
	{
		/* Cycles through players array list to find a player object with the same name */
		for (int i = 0; i < players.size(); i++)
		{
			if (playerName.equals(players.get(i).getName()))
			{
				return players.get(i); // Return object reference
			}
		}
		
		return null; // No match was found
		
	}
	
	/**
	 * Prints the stats of the 2 players with the highest attack stats
	 */
	public void printTopAttackers()
	{
		int bestAttackerIndex = 0;        // Index of the player with the highest attack stat in the players array list
		int secondBestAttackerIndex = 0;  // Index of the player with the second highest attack stat in the players array list
		
		double CurrentBestAttackStat = 0; // The current best measured attack stat
		
		/* Cycles through the players array list to find the player with the best attack stat */
		for (int i = 0; i < players.size(); i++)
		{
			if(players.get(i).getAttackStat() >= CurrentBestAttackStat)
			{
				bestAttackerIndex = i;
				CurrentBestAttackStat = players.get(i).getAttackStat();
			}
		}
		
		CurrentBestAttackStat = 0;        // Resets the current best attack stat
		
		/* Cycles through the players array list to find the player with the second best attack stat */
		for (int j = 0; j < players.size(); j++)
		{
			if(players.get(j).getAttackStat() >= CurrentBestAttackStat && j != bestAttackerIndex)
			{
				secondBestAttackerIndex = j;
				CurrentBestAttackStat = players.get(j).getAttackStat();
			}
		}
		
		players.get(bestAttackerIndex).printPlayerInfo();       // Prints the stats of the player with the best attack stat
		players.get(secondBestAttackerIndex).printPlayerInfo(); // Prints the stats of the player with the second best attack stat
		
	}
	
	/**
	 * Prints the stats of the 2 players with the highest block stats
	 */
	public void printTopBlockers()
	{
		int bestBlockerIndex = 0;        // Index of the player with the highest block stat in the players array list
		int secondBestBlockerIndex = 0;  // Index of the player with the second highest block stat in the players array list
		
		double CurrentBestBlockStat = 0; // The current best measured block stat
		
		/* Cycles through the players array list to find the player with the best block stat */
		for (int i = 0; i < players.size(); i++)
		{
			if(players.get(i).getBlockStat() >= CurrentBestBlockStat)
			{
				bestBlockerIndex = i;
				CurrentBestBlockStat = players.get(i).getBlockStat();
			}
		}
		
		CurrentBestBlockStat = 0;        // Resets the current best attack stat
		
		/* Cycles through the players array list to find the player with the second best block stat */
		for (int j = 0; j < players.size(); j++)
		{
			if(players.get(j).getBlockStat() >= CurrentBestBlockStat && j != bestBlockerIndex)
			{
				secondBestBlockerIndex = j;
				CurrentBestBlockStat = players.get(j).getBlockStat();
			}
		}
		
		players.get(bestBlockerIndex).printPlayerInfo();       // Prints the stats of the player with the  best block stat
		players.get(secondBestBlockerIndex).printPlayerInfo(); // Prints the stats of the player with the second best block stat
		
	}
	
	/**
	 * Prints the stats of all the players in the roster
	 */
	public void printAllPlayers()
	{
		/* Goes through all the player objects in the players array list and prints their stats */
		for (int i = 0; i < players.size(); i++)
		{
			players.get(i).printPlayerInfo();
		}
	}
}