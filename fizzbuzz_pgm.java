package JavaPrograms;

import java.util.Scanner;

public class fizzbuzz_pgm {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first Number:");
		int a = sc.nextInt();
		System.out.println("Enter second Number:");
		int b = sc.nextInt();
		for (int i = a; i <= b; i++) {
			if (i % 3 == 0 && i % 5 ==0)
				System.out.println("FizzBuzz");
			else if (i % 3 == 0)
				System.out.println("Fizz");
			else if (i % 5 == 0)
				System.out.println("Buzz");
			else {
				System.out.println(i);
			}
		}
	}
}