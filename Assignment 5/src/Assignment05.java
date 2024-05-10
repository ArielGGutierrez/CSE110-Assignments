// CSE 110     : 86854 / iCourse
// Assignment  : #5
// Author      : Ariel G. Gutierrez 1218982505
// Description : This program takes number and string inputs from the user and employs a variety of methods to achieve different results with the inputs
import java.util.Scanner;

public class Assignment05 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Code to test methods
		displayGreeting();
		String str = scan.nextLine();
		System.out.printf("displayText(\"%s\"): ", str);
		displayText(str);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		printTotal(a, b, c);
		System.out.printf("getTotal(%s,%s,%s) :%s\n", a, b, c, getTotal(a,b,c));
		System.out.printf("getAverage(%s,%s,%s) :%s\n", a, b, c, getAverage(a,b,c));
		String s1 = scan.next();
		String s2 = scan.next();
		String s3 = scan.next();
		System.out.printf("averageLength(%s,%s,%s) :%s\n", s1, s2, s3, averageLength(s1, s2, s3));
		System.out.printf("lengthOfShortest(%s,%s) :%s\n", s1, s2, lengthOfShortest(s1, s2));
		System.out.printf("stringOfStars(%s) :%s\n", s1, stringOfStars(s1));
		System.out.printf("maxStringOfStars(%s,%s) :%s\n", s1, s2, maxStringOfStars(s1, s2));
		System.out.printf("midStringOfStars(%s,%s,%s) :%s\n", s1, s2, s3, midStringOfStars(s1, s2, s3));
		scan.close();
    }
    
    // 1) Write (define) a static method named displayGreeting, 
    //  that takes no arguments and returns no value.
    //  When this function is called, it should print the text "Hello, and welcome!".
    /** 
     * This method displays the following message: Hello, and welcome!
     * @param str String
     * @return
     */
    static void displayGreeting()
    {
    	System.out.println("Hello, and welcome!");
    }
    
    //2) Write (define) a static method named displayText, 
    //  that takes a single String argument and returns no value. 
    //  When this function is called, it should print the value of the argument that was passed to it.
    /** 
     * This method displays the string inputed
     * @param str a string to be displayed
     * @return
     */
    static void displayText(String str)
    {
    	System.out.println(str);
    }
    
    //3) Write (define) a static method named printTotal, 
    //  that takes three int arguments. 
    //  When this function is called, it should print the sum of the three arguments passed to it. 
    //  This function should return no value.
    /** 
     * This method prints the sum of three integers inputed
     * @param num1 a first integer to be added
     * @param num2 a second integer to be added
     * @param num3 a third integer to be added
     * @return
     */
    static void printTotal(int num1, int num2, int num3)
    {
    	System.out.println(num1 + num2 + num3);
    }
    
    //4) Write (define) a static method named getTotal, 
    //  that takes three int arguments. 
    //  When this function is called, it should return the sum 
    //  of the three arguments passed to it as an int.
    /** 
     * This method calculates the sum of three integers inputed
     * @param num1 a first integer to be added
     * @param num2 a second integer to be added
     * @param num3 a third integer to be added
     * @return the sum of the three integers
     */
    static int getTotal(int num1, int num2, int num3)
    {
    	int sum = num1 + num2 + num3; // Finds the sum of 3 numbers
    	return sum;
    }
    
    //5) Write (define) a static method named getAverage, 
    //  that takes three int arguments. 
    //  When this function is called, it should return the average 
    //  of the three arguments passed to it as a double.
    /** 
     * This method calculates the average of three integers inputed
     * @param num1 a first integer to be averaged
     * @param num2 a second integer to be averaged
     * @param num3 a third integer to be averaged
     * @return the average of the three integers as a double
     */
    static double getAverage(int num1, int num2, int num3)
    {
    	final int TOTALNUMS = 3; 					 // Number of numbers to divide by
    	
    	int sum = getTotal(num1, num2, num3); 		 // Finds the sum of the 3 numbers
    	double average = (double) (sum) / TOTALNUMS; // Finds the average of the 3 numbers
    	
    	return average;
    }
    
    //6) Write (define) a static method named averageLength, 
    //  that takes three String arguments. 
    //  When this function is called, it should return the average length (number of characters) 
    //  of the String arguments passed to it as a double.
    /** 
     * This method calculates the average length of three strings
     * @param str1 a first string to be averaged
     * @param str2 a second string to be averaged
     * @param str3 a third string to be averaged
     * @return the average of the length of the three strings passed as a double
     */
    static double averageLength(String str1, String str2, String str3)
    {
    	int length1 = str1.length();							// Finds the length of the first string
    	int length2 = str2.length();							// Finds the length of the second string
    	int length3 = str3.length(); 							// Finds the length of the third string
    	
    	double average = getAverage(length1, length2, length3); // Finds the average of all the lengths
    	
    	return average;
    }
    
    //7) Write (define) a static method named lengthOfShortest, 
    //  that takes two String arguments. When this function is called, 
    //  it should return the length (number of characters) 
    //  of the shortest String argument passed to it as an int.
    /** 
     * This method calculates the shortest length of two strings
     * @param str1 a first string to be compared
     * @param str2 a second string to be compared
     * @return the length of the shortest string passed as an integer
     */
    static int lengthOfShortest(String str1, String str2)
    {
    	int length1 = str1.length(); // Finds the length of the first string
    	int length2 = str2.length(); // Finds the length of the seconds string
    	
    	/* Finds the shortest of the 2 strings by comparing which length is shorter */
    	if (length1 <= length2)
    	{
    		return length1;
    	}
    	
    	else
    	{
    		return length2;
    	}
    	
    }
    
    //8) Write (define) a static method named stringOfStars, 
    //  that takes one String argument.
    //  When this function is called, it should return a String of asterisks (*) 
    //  that is the same length as the string argument passed to it.
    /** 
     * This method finds a string of the same length as the one passed comprised of "*"
     * @param str a string of a certain length
     * @return a string of "*" that has the same length as the string passed
     */
    static String stringOfStars(String str)
    {
    	int length = str.length(); // Finds the length of the string passed
    	String result = ""; 	   // Empty result that will get changed
    	
    	/* Creates a string of stars that has the same length as the string passed */
    	for (int i = 0; i < length; i++)
    	{
    		result += "*";
    	}
    	
    	return result;
    }
    
    //9) Write (define) a static method named maxStringOfStars, 
    //  that takes two String arguments. 
    //  When this function is called, it should return a String of asterisks (*) 
    //  that is the same length as the longest string argument passed to it.
    /** 
     * This method first finds the max length between two strings and creates a string comprised
     * of "*" of the same max length
     * @param str1 a first string to compare
     * @param str2 a second string to compare
     * @return a string of "*" that has the same length as the biggest string passed
     */
    static String maxStringOfStars(String str1, String str2)
    {
    	int length1 = str1.length(); 	  // Finds the length of the first string
    	int length2 = str2.length(); 	  // Finds the length of the seconds string
    	
    	String result = ""; 			  // Empty result that will be changed
    	
    	/* Finds the bigger of the 2 strings by comparing lengths */
    	if (length1 >= length2)
    	{
    		result = stringOfStars(str1); // Gives a string of stars with the length of string 1
    	}
    	
    	else
    	{
    		result = stringOfStars(str2); // Gives a string of stars with the length of string 2
    	}
    	
    	return result;
    }
    
    //10) Write (define) a static method named midStringOfStars, 
    //   that takes three String arguments. 
    //   When this function is called, it should return a String of asterisks (*) 
    //   that is the same length as the string argument with the length 
    //   that would be in the middle if the lengths of the arguments were arranged in ascending order.
    /** 
     * This method first finds the middle length between three strings and creates a string comprised
     * of "*" of the same middle length
     * @param str1 a first string to compare
     * @param str2 a second string to compare
     * @param str3 a third string to compare
     * @return a string of "*" that has the same length as the middle sized string passed
     */
    static String midStringOfStars(String str1, String str2, String str3)
    {
    	int lengthstr1 = str1.length(); // Finds the length of the first string
    	int lengthstr2 = str2.length(); // Finds the length of the seconds string
    	int lengthstr3 = str3.length(); // Finds the length of the third string
    	String result = "";				// Empty result that will be changed
    	
    	/* Cases where string 1 would be the middle length
    	 * str3 <= str1 <= str2
    	 * str2 <= str1 <= str3 */
    	if ((lengthstr1 <= lengthstr2 && lengthstr3 <= lengthstr1) || (lengthstr1 <= lengthstr3 && lengthstr2 <= lengthstr1))
    	{
    		result = stringOfStars(str1);
    	}
    	
    	/* Cases where string 2 would be the middle length
    	 * str3 <= str2 <= str1
    	 * str1 <= str2 <= str3 */
    	else if ((lengthstr2 <= lengthstr1 && lengthstr3 <= lengthstr2) || (lengthstr2 <= lengthstr3 && lengthstr1 <= lengthstr2))
    	{
    		result = stringOfStars(str2);
    	}
    	
    	/* Cases where string 3 would be the middle length
    	 * str2 <= str3 <= str1
    	 * str1 <= str3 <= str2 */
    	else if ((lengthstr3 <= lengthstr1 && lengthstr2 <= lengthstr3) || (lengthstr3 <= lengthstr2 && lengthstr1 <= lengthstr3))
    	{
    		result = stringOfStars(str3);
    	}
    	
    	return result;
    }

}
