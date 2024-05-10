// CSE 110     : 86854 / iCourse
// Assignment  : #2
// Author      : Ariel G. Gutierrez 1218982505
// Description : This program takes characteristics of a road as user input and outputs
// estimates of how many materials will be necessary and how much it all costs

import java.util.Scanner;


public class Assignment02
{
    
	public static void main(String[] args)
	{
		// declare and instantiate a Scanner
		Scanner scan = new Scanner(System.in);

        // declare and initialize variables
		
		// input variables
		double lengthMiles = 0; // Miles
		int numLane = 0; // Number of lanes
		int depthInch = 0; // Inches
		int totalDays = 0; // Days
		
		// conversions
		final double INCHTOFOOT = 1.0 / 12; // converts inches to feet
		final double MILETOFOOT = 5280; // converts miles to feet
		
		// given variables
		final double LANE_WIDTH = 12; // Feet
		final int ASPHALT_WEIGHT = 150; // Pounds per Cubic Feet
		final int ASPHALT_COST = 200; // Dollars per ton
		final int TONS_PER_TRUCK = 5; // Tons
		final int POUNDS_PER_TRUCK = 10000; // Pounds
		
		final int LIGHTS_PER_SECTION = 2; // Lights in an intersection (not counting lanes)
		final double COST_PER_LIGHT = 25000; // Dollars per light
		
		final int CONDUIT_LENGTH = 24; // Feet per pipe
		final double COST_PER_CONDUIT = 500; // Dollars per pipe
		
		final int WORK_DAY = 8; // hours worked in a day
		final double CREW_PAY = 25; // Dollars per hour
		
		int i = 0; // this is a control variable for the following loop
		
        // collect inputs
		while (i < 4) // this loop is to obtain all of the variables in a valid form
		{
			switch (i)
			{
				case 0: // this tells the user to input the length in miles of the road
					System.out.println("Length of road project (miles) : ");
					lengthMiles = scan.nextDouble();
					
					if (lengthMiles < 0) // if the value is less than 0, prompt the user to type it again
					{
						System.out.println("[ERROR] Length must be positive");
					}
					
					else
					{
						i++;
					}
					
					break;
				
				case 1: // this tells the user to input the number of lanes to be constructed
					System.out.println("Number of lanes                : ");
					numLane = scan.nextInt();
					
					if (numLane < 0) // if the value is less than 0, prompt the user to type it again
					{
						System.out.println("[ERROR] Number of lanes must be positive");
					}
					
					else // this lets the loop move on to the next question
					{
						i++;
					}
					
					break;
				
				case 2: // this tells the user to input the depth of the road
					System.out.println("Depth of asphalt (inches)      : ");
					depthInch = scan.nextInt();
					
					if (depthInch < 0) // if the value is less than 0, prompt the user to type it again
					{
						System.out.println("[ERROR] Depth must be positive");
					}
					
					else // this lets the loop move on to the next question
					{
						i++;
					}
					
					break;
					
				case 3: // this tells the user to input the number of days to complete the project
					System.out.println("Days to complete project       : ");
					totalDays = scan.nextInt();
					
					if (totalDays < 0) // if the value is less than 0, prompt the user to type it again
					{
						System.out.println("[ERROR] Number of days must be positive");
					}
					
					else // this lets the loop move on to the next question
					{
						i++;
					}
					
					break;
			}
		}
		
        // compute required values
		
		// in order to find the number of trucks needed, we must first compute how much asphalt we are using
		// for this problem, i'll convert everything to feet so that it's easier to find the weight of the
		// asphalt
		double lengthFeet = lengthMiles * MILETOFOOT;
		double depthFeet = depthInch * INCHTOFOOT;
		double widthTotal = LANE_WIDTH * numLane;
		
		// with the dimensions in feet, we compute the volume in feet by multiplying the dimensions together
		double roadVol = lengthFeet * depthFeet * widthTotal;
		
		// lastly, we compute the total weight by multiplying the volume by the weight of a unit asphalt
		double roadWeight = ASPHALT_WEIGHT * roadVol;
		
		// to find the number of trucks, we divide the total weight of the asphalt by how much a truck can
		// carry and round it up
		int numTruck = (int) Math.ceil(roadWeight / POUNDS_PER_TRUCK);
		
		// since we're getting the asphalt in full truck loads, we multiply the number of trucks by the cost
		// of asphalt and by how much a truck can carry in tons
		double roadCost = ASPHALT_COST * numTruck * TONS_PER_TRUCK;
		
		// every mile there is 2 stop lights plus additional ones depending on the number of lanes
		// to find the total number of stop lights, you multiply the number of miles by the number of lights
		// in each section and round it down
		int numStoplights = (int) lengthMiles * (LIGHTS_PER_SECTION + numLane);
		
		// every stop light costs a certain amount, so the total cost is just that amount times the number
		// of stop lights
		double stoplightCost = numStoplights * COST_PER_LIGHT;
		
		// conduit pipes run all throughout the road, so to find the number of pipes needed we round up
		// the division of the total length of the road in feet by the length of each pipe
        int numConduit = (int) Math.ceil(lengthFeet / CONDUIT_LENGTH);
        
        // to find the total cost of the pipes, we multiply the number of pipes by the cost of each one
        double conduitCost = numConduit * COST_PER_CONDUIT;
		
        // the number of crew members needed is determined by a specific formula, so here it is:
        int numCrew = (int) Math.ceil((50 * lengthMiles * numLane) / totalDays);
        
        // to find the total cost of keeping the crew members, we multiply their salaries by the total
        // hours they work
        double crewCost = numCrew * WORK_DAY * CREW_PAY * totalDays;
        
        // we find the total cost by adding all the costs together
        double totalCost = roadCost + stoplightCost + conduitCost + crewCost;
        
        // display results
		System.out.println("=== Amount of materials needed ===");
		System.out.println("Truckloads of Asphalt : " + numTruck);
		System.out.println("Stoplights            : " + numStoplights);
		System.out.println("Conduit pipes         : " + numConduit);
		System.out.println("Crew members needed   : " + numCrew);
		System.out.println("=== Cost of Materials ============");
		System.out.printf("Cost of Asphalt       : $%.2f%n", roadCost);
		System.out.printf("Cost of Stoplights    : $%.2f%n", stoplightCost);
		System.out.printf("Cost of Conduit pipes : $%.2f%n", conduitCost);
		System.out.printf("Cost of Labor         : $%.2f%n", crewCost);
		System.out.println("=== Total Cost of Project ========");
		System.out.printf("Total cost of project : $%.2f%n", totalCost);
		scan.close();
    }

}
