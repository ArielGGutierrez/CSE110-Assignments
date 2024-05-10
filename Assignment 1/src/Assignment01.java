// CSE 110     : 86854 / iCourse
// Assignment  : #1
// Author      : Ariel G. Gutierrez 1218982505
// Description : This program attempts to distribute pizza among adults and children in a party

import java.util.Scanner;

public class Assignment01 {
    public static void main(String[] args) {  
        
    	// declare and instantiate a Scanner
    	
    	Scanner scan = new Scanner(System.in);
        
        // declare and initialize variables
       
    	int pizzaPurchase = 0;      // number of boxes of pizza purchased
    	int pizzaSlices = 0;        // number of slices per box
    	int numAdults = 0;          // number of adults getting pizza
    	int numChildren = 0;        // number of children getting pizza
    	final int ADULT_SLICES = 2; // number of pizza slices per adult
        
        // prompt for and collect inputs
        
    	System.out.println("How many pizzas were purchased? ");
    	pizzaPurchase = scan.nextInt();
        
    	System.out.println("How many slices per pizza?      ");
    	pizzaSlices = scan.nextInt();
    	
    	System.out.println("How many adults are there?      ");
    	numAdults = scan.nextInt();
    	
    	System.out.println("How many children are there?    ");
    	numChildren = scan.nextInt();
    	
        // compute required values
    	
    	int totalSlices = pizzaPurchase * pizzaSlices;  // total number of pizza slices
    	int pizzaAdults = numAdults * ADULT_SLICES;     // number of pizza slices for the adults
    	int pizzaChild = totalSlices - pizzaAdults;     // number of pizza slices left for the children
    	int sliceChild = pizzaChild / numChildren;      // number of pizza slices per child
    	int leftOver = pizzaChild % numChildren;        // number of pizza slices left after distribution
    	

        // display required outputs
    	
    	System.out.println("Total number of slices of pizza               : " + totalSlices);
    	System.out.println("Total number of slices given to adults        : " + pizzaAdults);
    	System.out.println("Total number of slices available for children : " + pizzaChild);
    	System.out.println("Number of slices each child will get          : " + sliceChild);
    	System.out.print(  "Number of slices left over                    : " + leftOver);
    	
    	scan.close();
    }
}
