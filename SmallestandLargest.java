package JavaPrograms;

import java.util.Arrays;

public class SmallestandLargest {

	public static void main(String[] args) {

		int numbers[] = { -10, 24, -50, -99, 987, 658745, 0 };

		int largest = numbers[0];
		int smallest = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > largest) {
				largest = numbers[i];
			} else if (numbers[i] < smallest) {
				smallest = numbers[i];
			}
		}
      System.out.println("Given Array is:"+Arrays.toString(numbers));
      System.out.println("The largest number is :" +largest);
      System.out.println("The largest number is :" +smallest);
	}
}