// CSE 110     : 86854 / iCourse
// Assignment  : #4
// Author      : Ariel G. Gutierrez 1218982505
// Description : This program plays "Master Mind" with the user.  The program thinks of a random 4 digit number and the user has to guess the number.

import java.util.Scanner;

public class Assignment04
{

    public static void main(String[] args)
    {
    	
    	Scanner scan = new Scanner(System.in);
    	
    	/* Variables and their purpose */
    	final int BASE = 10;	   // Base of the numbers we will work with
    	final int DIGITS = 4;      // Number of digits in guess
    	final int MAXNUM = 9999;   // The max random number generated
    	final int MINNUM = 1000;   // The minimum random number generated
    	int secretNum;			   // The secret number the user has to guess
    	int secretNumArithmetic;   // Copy of the secret number to perform arithmetic on
    	int userGuess;			   // The user's guess of the secret number
    	int userGuessArithmetic;   // Copy of the user's guess to perform arithmetic on
    	int numGuess = 0;		   // Number of guesses the user has made
    	int numCorrect = 0;		   // Number of digits that are correct in the user's guess
    	boolean isCorrect = false; // Whether or not the user is correct
    	boolean replay = true;	   // Whether or not to replay the game
    	String userReplay = "";	   // Whether or not the user wants to replay
    	
    	/* Main loop for when the user is playing the game*/
    	while (replay)
    	{
    		/* Prints the title of the game */
    		System.out.println("- - - - - MASTERMIND - - - - -");
    		System.out.println("Guess the 4 digit number!");
    		System.out.println();
    		
    		/* Sets the secret number to a random number between 1000 and 9999 */
    		secretNum = (int) (Math.random() * (MAXNUM - MINNUM) + MINNUM);
    		
    		/* Resets whether or not the user is correct back to false when the game is replayed */
    		isCorrect = false;
    		
    		/* Resets the number of guesses back to 0 when the game is replayed */
    		numGuess = 0;
    		
    		/* This loop runs until the user reaches a correct guess */
    		do
    		{
    			/* Resets the number of correct digits that the user got correct back to 0 when making multiple guesses */
    			numCorrect = 0;
    			
    			/* Increments the guess counter and asks the user for a guess */
    			numGuess++;
    			System.out.println("Guess " + numGuess + ": ");
        		userGuess = scan.nextInt();
        		
        		/* Resets the the arithmetic variables back to being equal to the guesses */
        		userGuessArithmetic = userGuess;
        		secretNumArithmetic = secretNum;
        		
        		/** This loop checks if each digit of the user's guess corresponds to one in the actual number.
        		 *  It checks the leftmost digit of the user's guess and the actual number.
        		 *  Next, it subtracts these numbers by their leftmost number to reduce the number of digits
        		 *  Example:
        		 *  9834 - 9000 = 834
        		 *  834 - 800 = 34
        		 *  34 - 10 = 4
        		 *  The loop repeats this process until all numbers have been checked. */
        		for (int i = DIGITS - 1; i >= 0; i--)
        		{
        			int userPlace = (int) (userGuessArithmetic / Math.pow(BASE, i));   // Leftmost digit in the user's guess
        			int secretPlace = (int) (secretNumArithmetic / Math.pow(BASE, i)); // Leftmost digit in the actual number
        			
        			/* If the digit in the corresponding place is the same, then add to the number of correct digits */
        			if (userPlace == secretPlace)
        			{
        				numCorrect++;
        			}
        			
        			/* Reduces the numbers by 1 decimal place */
        			userGuessArithmetic -=  (int) (userGuessArithmetic / Math.pow(BASE, i)) * (int) Math.pow(BASE, i);
        			secretNumArithmetic -= (int) (secretNumArithmetic / Math.pow(BASE, i)) * (int) Math.pow(BASE, i);
        		}
        		
        		/* Tells the user how many digits they matched */
        		System.out.println("You matched: " + numCorrect);
        		System.out.println();
        		
        		/* If the user matched all 4 numbers, they guessed right */
        		if (numCorrect == DIGITS)
        		{
        			isCorrect = true;
        		}
        		
    		} while (!isCorrect); // End of do-while loop
    		
    		/* Congratulates the user for having guessed correctly and tells them how many guesses they had */
    		System.out.println("Congratulations! You guessed the right number in " + numGuess + " guesses.");
    		
    		/* Asks the user if they want to play again */
    		System.out.println("Would you like to play again (yes/no)?");
    		userReplay = scan.next();
    		
    		/* If the user answers 'yes', they can play again  */
    		if (userReplay.equals("yes"))
    		{
    			continue; // Since replay is true by default, nothing needs to be done
    		}
    		
    		/* If the user answers with anything else, they don't get to replay */
    		else
    		{
    			replay = false;
    		}
    		
    	} // End of replay loop
    	
    	scan.close(); // Closes the scanner
    	
    } // End of main method
    
} // End of class
