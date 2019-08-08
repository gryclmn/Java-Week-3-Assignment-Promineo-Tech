import java.time.Year;
import java.util.Arrays;
import java.util.stream.IntStream;

import javax.management.loading.PrivateClassLoader;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class App {

	public static void main(String[] args) {
		
		/* 
		 * ********************
		 * Step 1
		 * ********************
		 */
		
		int[] ages = {3, 9, 23, 64, 2, 8, 28};
		
		// Instructions are to get the difference of the first and last element.
		// However we are not allowed to use any numbers at all...
		int lengthOfArr = ages.length;
		int difference = Math.abs(ages[lengthOfArr - lengthOfArr] - ages[lengthOfArr - 1]);
		
		System.out.println("Difference of first and last element in ages[] = " + difference);
		
		int[] newAges = new int[ages.length];
		
		System.arraycopy(ages,  0, newAges, 0, ages.length);
		
		lengthOfArr = newAges.length;
		newAges[lengthOfArr - 1] = 100;
		difference = Math.abs(newAges[lengthOfArr - lengthOfArr] - newAges[lengthOfArr - 1]);
		
		System.out.println("Difference of first and last element in newAges[] = " + difference);
		
		int sum = 0;
		for (int i = 0; i < newAges.length; i++) {
			sum += newAges[i];
		}
		double average = sum / lengthOfArr;
		System.out.println("The average age in newAges[] = " + average );
		
		/* 
		 * ********************
		 * Step 2
		 * ********************
		 */
		
		String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck", "Bob"};
		sum = 0;
		for (int i = 0; i < names.length; i++) {
			sum += names[i].length();
		}
		average = sum / names.length;
		System.out.println("The average number of letters per name in names[] = " + average );
		
		String allNames = "";
		for (int i = 0; i < names.length; i++) {
			allNames += names[i] + " ";
		}
		System.out.println(allNames);
		
		/* 
		 * ********************
		 * Step 3
		 * ********************
		 */
		
		System.out.println("Use array[arr.length] to access the last element of an array");
		
		/* 
		 * ********************
		 * Step 4
		 * ********************
		 */
		
		System.out.println("Use array[0] to access the first element of an array");
		
		/* 
		 * ********************
		 * Step 5
		 * ********************
		 */
		
		int[] nameLengths = new int[names.length];
		for (int i = 0; i < names.length; i++) {
			nameLengths[i] = names[i].length(); 
		}
		
		/* 
		 * ********************
		 * Step 6
		 * ********************
		 */
		
		sum = 0;
		for (int i = 0; i < nameLengths.length; i++) {
			sum += nameLengths[i];
		}
		System.out.println("The sum of all lengths in nameLengths[] = " + sum);
		
		/* 
		 * ********************
		 * Step 7
		 * ********************
		 */
		
		System.out.println(duplicateWord("Hello", 5));
		
		/* 
		 * ********************
		 * Step 8
		 * ********************
		 */
		
		System.out.println(getFullName("Bruce", "Banner"));
		
		/* 
		 * ********************
		 * Step 9
		 * ********************
		 */
		
		System.out.println("checkIfSumGreaterThan100() returns => " + checkIfSumGreaterThan100(ages));
		
		/* 
		 * ********************
		 * Step 10
		 * ********************
		 */
		
		double[] doubleArr = {0.1, 1.0, 236.4592, 1000.1};
		double[] emptyDoubleArr = {};
		System.out.println("getAverageOfDoubleArr() returns => " + getAverageOfDoubleArr(doubleArr));
		System.out.println("Passing empty double[] to getAverageOfDoubleArr() returns => " + getAverageOfDoubleArr(emptyDoubleArr));
	
		/* 
		 * ********************
		 * Step 11
		 * ********************
		 */
		
		double[] anotherDoubleArr = {2.2, 3.3, 4.4, 5.5};
		System.out.println("isFirstArrAvgGreater returns => " + isFirstArrAvgGreater(doubleArr, anotherDoubleArr));
		
		/* 
		 * ********************
		 * Step 12
		 * ********************
		 */
		System.out.println("getAge() returns => " + getAge(1981));

	}
	
	private static String duplicateWord(String word, int n) {
		String duplicatedWord = "";
		for (int i = 0; i < n; i++) {
			duplicatedWord += word;
		}
		return "duplicatedWord() returns => " + duplicatedWord;
	}
	
	private static String getFullName(String firstName, String lastName) {
		return "getFullName() returns => " + firstName + " " + lastName;
	}
	
	private static Boolean checkIfSumGreaterThan100(int[] arr) {
		return Arrays.stream(arr).sum() > 100;
	}
	
	private static double getAverageOfDoubleArr(double[] arr) {
		// We need to use .orElse() in case an empty array is passed in
		return Arrays.stream(arr).average().orElse(Double.NaN);
	}
	
	private static boolean isFirstArrAvgGreater(double[] firstArr, double[] secondArr) {
		return getAverageOfDoubleArr(firstArr) > getAverageOfDoubleArr(secondArr); 
	}
	
	
	/*
	 * getAge calculates a new user's age with the given birthYear
	 */
	private static int getAge(int birthYear) {
		return Year.now().getValue() - birthYear; 
	}

}
