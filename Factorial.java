package JavaPrograms;

public class Factorial {

	// 1 . without recursive --use for loop
	public static int isFactorial(int num) {
		int fact = 1;
		if (num == 0)
			return 1;
		for (int i = 1; i <= num; i++) {
			fact = fact * i;
		}
		return fact;

	}

	// 2. with recursive function : a function is calling itself
	public int fact(int num) {
		if (num == 0)
			return 1;
		else
			return (num * fact(num - 1));
	}

	public static void main(String[] args) {
		System.out.println(isFactorial(4));

	}
}