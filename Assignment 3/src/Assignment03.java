// CSE 110     : 86854 / iCourse
// Assignment  : #3
// Author      : Ariel G. Gutierrez 1218982505
// Description : This program takes user input regarding certain attributes of their stocks and calculates if they should 
//               buy, sell or hold them.

import java.util.Scanner;

public class Assignment03 {

    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in); // Scanner for user input
        
    	final double TRANSACTIONFEE = 10; // $10 transaction free for every purchase or sale
    	
    	double currentShares;   // Number of shares of this stock currently held in the account
    	double purchasePrice;   // Price paid (per share)
    	double marketPrice; 	// Current price (per share) to buy or sell this stock
    	double availableFunds;  // Amount of money the client is willing to spend on a transaction
    	
    	// Other variables needed
    	double numberOfSharesToBuy, perShareBuyValue, totalBuyValue;
    	double perShareSellValue, totalSellValue;
    	
    	// Asks the client to input their current shares, purchase price for said shares, current 
    	// market price for those shares and the amount of money they're willing to spend
    	System.out.println("Current Shares  : ");
    	currentShares = scan.nextDouble();
    	System.out.println("Purchase Price  : ");
    	purchasePrice = scan.nextDouble();
    	System.out.println("Market Price    : ");
    	marketPrice = scan.nextDouble();
    	System.out.println("Available Funds : ");
    	availableFunds = scan.nextDouble();
    	
    	// Computes the number of shares that the client can buy
    	numberOfSharesToBuy = Math.floor((availableFunds - TRANSACTIONFEE) / marketPrice);
    	
    	// Computes the value of 1 share bought
    	perShareBuyValue = purchasePrice - marketPrice;
    	
    	// Computes the total value of the shares that were bought
    	totalBuyValue = perShareBuyValue * numberOfSharesToBuy;
    	
    	// Computes the value of 1 share sold
    	perShareSellValue = marketPrice - purchasePrice;
    	
    	// Computes the total value of the shares sold
    	totalSellValue = perShareSellValue * currentShares;
    	
    	// A person should only buy shares if the current market price is lower than the price they
    	// originally paid the stocks with and if the value of the stocks purchased is bigger than the
    	// transaction fee
    	if (marketPrice < purchasePrice && totalBuyValue > TRANSACTIONFEE) // buy
    	{
    		System.out.println("Buy " + (int) numberOfSharesToBuy + " shares");
    	}
    	
    	// A person should sell if the current price to sell the stocks is higher than the price they
    	// paid for the stocks and if they gain more value in selling their stocks than the transaction fee
    	else if (marketPrice > purchasePrice && totalSellValue > TRANSACTIONFEE) // sell
    	{
    		System.out.println("Sell " + (int) currentShares + " shares");
    	}
    	
    	// If you can't make a profit buying or selling stocks, hold them
    	else
    	{
    		System.out.println("Hold shares");
    	}
    	
    	scan.close(); // End main method
    }
}
