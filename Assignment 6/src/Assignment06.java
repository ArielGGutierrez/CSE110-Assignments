// CSE 110     : 86854 / iCourse
// Assignment  : #6
// Author      : Ariel G. Gutierrez 1218982505
// Description : This program works with arrays by a variety of different methods
import java.util.Scanner;
import java.util.Arrays;

public class Assignment06 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
		int arrSize = scan.nextInt();
		int[] arr = new int[arrSize];
		for(int i = 0; i < arrSize; i++)
			arr[i] = scan.nextInt();
		int[] arrCopy = Arrays.copyOf(arr, arrSize);
		String sep = scan.next();
		int idx1 = scan.nextInt(); 
		int idx2 = scan.nextInt();
		
		//Method 1
		System.out.printf("printArray(%s,\"%s\"): ", Arrays.toString(arr), sep);
		printArray(arr, sep);
		System.out.println();
		
		//Method 2
		System.out.printf("getFirst(%s): %d\n", Arrays.toString(arr), getFirst(arr));
		
		//Method 3
		System.out.printf("getLast(%s): %d\n", Arrays.toString(arr), getLast(arr));
		
		//Method 4
		System.out.printf("getAllButFirst(%s): %s\n", Arrays.toString(arr), Arrays.toString(getAllButFirst(arr)));
		
		//Method 5
		System.out.printf("getIndexOfMin(%s): %d\n", Arrays.toString(arr), getIndexOfMin(arr));
		
		//Method 6
		System.out.printf("getIndexOfMax(%s): %d\n", Arrays.toString(arr), getIndexOfMax(arr));
		
		//Method 7
		arr = swapByIndex(arr, idx1, idx2);
		System.out.printf("swapByIndex(%s, %d, %d): %s\n", Arrays.toString(arrCopy), idx1, idx2, Arrays.toString(arr));
		
		//Method 8
		System.out.printf("removeAtIndex(%s, %d): %s\n", Arrays.toString(arr), idx1, Arrays.toString(removeAtIndex(arr, idx1)));
		
		//Method 9
		System.out.printf("insertAtIndex(%s, %d, 100): %s\n", Arrays.toString(arr), idx2, Arrays.toString(insertAtIndex(arr, idx2, 100)));
		
		//Method 10
		System.out.printf("isSorted(%s): %s\n", Arrays.toString(arr), isSorted(arr));
		
		scan.close();
    }
    
    // 1) Write a public static method named printArray, 
    //   that takes two arguments. The first argument is an Array of int 
    //   and the second argument is a String. The method should print out 
    //   a list of the values in the array, each separated by the value of the second argument.
    /**
     * Prints an array with dividers separating elements inside
     * @param array an integer array to be displayed
     * @param divider a string that divides aspect of the array
     */
    public static void printArray(int[] array, String divider)
    {
    	/* Prints the array element + divder for all the elements except for the last one
    	 * to ensure that there is no divider after the last element */
    	for (int i = 0; i < array.length - 1; i++)
    	{
    		System.out.print(array[i] + divider);
    	}
    	
    	System.out.print(array[array.length - 1]); // Prints out the last element
    }
    
    // 2) Write a public static method named getFirst, 
    //    that takes an Array of int as an argument and returns 
    //    the value of the first element of the array.
    /**
     * This method returns the first element of an integer array inputed
     * @param array an integer array to be used
     * @return the first integer element of the array
     */
    public static int getFirst(int[] array)
    {
    	return array[0]; // Returns the first element
    }
    
    // 3) Write a public static method named getLast, 
    //    that takes an Array of int as an argument and returns 
    //    the value of the last element of the array.
    /**
     * This method returns the last element in an array
     * @param array an integer array to be used
     * @return the last integer element of the array
     */
    public static int getLast(int[] array)
    {
    	return array[array.length-1]; // Returns the last element
    }
    
    // 4) Write a public static method named getAllButFirst, 
    //    that takes an Array of int as an argument and creates and returns 
    //    a new array with all of the values in the argument array except the first value.
    /**
     * This method returns a copy of an array passed without the first element
     * @param array an integer array to be used
     * @return a copy of the integer array passed without the first element
     */
    public static int[] getAllButFirst(int[] array)
    {
    	int[] result = new int[array.length - 1]; // Creates a new array
    	
    	/* Fills the new array with every value of the array passed starting from
    	 * the second element */
    	for (int i = 1; i < array.length; i++)
    	{
    		result[i-1] = array[i];
    	}
    	
    	return result; // Returns the result array
    }
    
    // 5) Write a public static method named getIndexOfMin, 
    //    that takes an Array of int as an argument and returns 
    //    the index of the least value in the array.
    /**
     * This method finds the index of the smallest element of an array passed
     * @param array an integer array to be used
     * @return an integer index of the smallest element of the array
     */
    public static int getIndexOfMin(int[] array)
    {
    	int currentMin = array[0]; // Current minimum value
    	int indexOfMin = 0;		   // Index of the current minimum value
    	
    	/* Checks all the elements in the array starting from the second element because the first is set
    	 * as the default minimum value */
    	for (int i = 1; i < array.length; i++)
    	{
    		/* If the value at index i is less then the current minimum value, set it as the
    		 * current minimum value and update the index accordingly */
    		if (array[i] < currentMin)
    		{
    			currentMin = array[i];
    			indexOfMin = i;
    		}
    	}
    	
    	return indexOfMin; // Returns the index of the current minimum value
    }
    
    // 6) Write a public static method named getIndexOfMax, 
    //    that takes an Array of int as an argument and returns 
    //    the index of the largest value in the array.
    /**
     * This method finds the index of the biggest element of an array passed
     * @param array an integer array to be used
     * @return an integer index of the largest element of the array
     */
    public static int getIndexOfMax(int[] array)
    {
    	int currentMax = array[0]; // Current maximum value
    	int indexOfMax = 0;		   // Index of the current maximum value
    	
    	/* Checks all the elements in the array starting from the second element because the first is set
    	 * as the default maximum value */
    	for (int i = 1; i < array.length; i++)
    	{
    		/* If the value at index i is more than the current maximum value, set it as the
    		 * current maximum value and update the index accordingly */
    		if (array[i] > currentMax)
    		{
    			currentMax = array[i];
    			indexOfMax = i;
    		}
    	}
    	
    	return indexOfMax; // Returns the index of the current maximum value
    }
    
    // 7) Write a public static method named swapByIndex, 
    //    that takes three arguments. The first argument is an Array of int, 
    //    and the second and third arguments are int indexes. 
    //    This method will swap the values at the two given index arguments 
    //    in the array, and return a reference to the array.
    /**
     * This method swaps 2 selected elements of an array with each other
     * @param array an integer array to be used
     * @param indexOne first integer index to be swapped
     * @param indexTwo second integer index to be swapped
     * @return a reference to the original array
     */
    public static int[] swapByIndex(int[] array, int indexOne, int indexTwo)
    {
    	int swapHolder = array[indexOne];  // Placeholder value for the element at indexOne
    	
    	array[indexOne] = array[indexTwo]; // Gets overridden with the value at indexTwo
    	
    	array[indexTwo] = swapHolder;	   // Gets overridden with the value at indexOne
    	
    	return array;					   // Returns the reference of the array passed
    }
    
    //8) Write a public static method named removeAtIndex, 
    //  that takes two arguments. The first argument is an Array of int, 
    //  and the second argument is an int index. This method create and return 
    //  a new array with all of the values in the argument array 
    //  except the value at the argument index.
    /**
     * This method removes the value of an array at a specified index
     * @param array an integer array to be used
     * @param indexToRemove integer index of an element to be removed
     * @return a copy of the array passed without the value at indexToRemove
     */
    public static int[] removeAtIndex(int[] array, int indexToRemove)
    {
    	int arrayIndex = 0;						  // Current index of the array passed
    	int[] result = new int[array.length - 1]; // A new array that is one less than the length of the array passed
    	int resultIndex = 0;					  // Current index of the result array
    	
    	/*
    	 * This loop extends until all the elements in the array passed are checked.
    	 * While the current index of the passed array isn't the one that needs to be removed,
    	 * the result array gets filled with that value.  If the current index is the one that needs to be
    	 * removed, the function just skips to the next index.
    	 */
    	while (arrayIndex < array.length)
    	{
    		if (arrayIndex != indexToRemove)
    		{
    			result[resultIndex] = array[arrayIndex];
    			resultIndex++;
    		}
    		
    		arrayIndex++;
    	}
    	
    	return result; // Returns the result array
    }
    
    //9) Write a public static method named insertAtIndex, 
    //   that takes three arguments. The first argument is an Array of int, 
    //   the second argument is an int index, and the third argument is an int value. 
    //   This method create and return a new array with all of the values 
    //   in the argument array and including the third argument value 
    //   inserted at the index specified by the second argument value.
    /**
     * This method creates a copy of an array and inserts a specified value into a specified position
     * @param array an integer array to be used
     * @param indexToAdd integer index of an element to be added
     * @param valueToAdd integer to add at the specified index
     * @return a copy of the array passed with the added value at the specified index
     */
    public static int[] insertAtIndex(int[] array, int indexToAdd, int valueToAdd)
    {
    	int arrayIndex = 0;						  // Current index of the array passed
    	int[] result = new int[array.length + 1]; // A new array that has length of one greater than the passed array
    	int resultIndex = 0;					  // Current index of the result array
    	
    	/* This loop extends to all the elements of the array passed.  If the current index of the array passed is the one where the value passed is to be inserted,
    	 * that value gets inserted.  The value that was originally supposed to be at that index, then gets inserted.  If the current index of the array passed isn't
    	 * where the value needs to be inserted, the original element gets copied to the new array.
    	 * */
    	while (arrayIndex < array.length)
    	{
    		if (arrayIndex == indexToAdd)
    		{
    			result[resultIndex] = valueToAdd;	     // Adds the value to be inserted
    			resultIndex++;							 // Increments the index to add the value that was supposed to be at that index
    			
    			result[resultIndex] = array[arrayIndex]; // Adds the value that was supposed to be at that index
    		}
    		
    		else
    		{
    			result[resultIndex] = array[arrayIndex];
    		}
    		
    		resultIndex++; // Increments the index of the result array
    		arrayIndex++;  // Increments the index of the array passed
    		
    	}
    	
    	/* If the index of the value to be added is the last place, the loop above wouldn't place it, so this statement does */
    	if (indexToAdd > array.length-1 && indexToAdd < result.length)
    	{
    		result[result.length - 1] = valueToAdd;
    	}
    	
    	return result; // Returns the result array
    }
    
    //10) Write a public static method named isSorted, 
    //    that takes an Array of int as an argument. 
    //    This method should return the boolean value true 
    //    if all the element values in the array are in ascending order; 
    //    otherwise the method should return the boolean value false.
    /**
     * This loop checks if the integer array passed is sorted from least to greatest
     * @param array integer array to be checked
     * @return boolean true/false
     */
    public static boolean isSorted(int[] array)
    {
    	/* This loop runs from the beginning of array until the second to last element.  It checks if the current value is bigger than the next value.
    	 * If it is, then the array isn't sorted and it returns false.  If the loop executes completely, then the array is sorted properly
    	 */
    	for (int i = 0; i < array.length - 1; i++)
    	{
    		/* If the next element is greater than this one, it isn't sorted */
    		if (array[i] > array[i + 1])
    		{
    			return false;
    		}
    	}
    	
    	return true;
    }

}
