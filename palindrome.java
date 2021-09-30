package JavaPrograms;

public class palindrome {

	public static void isNumberPalindrome(int num) {
        System.out.println("The Given number is :" + num);
		int r = 0;
		int sum = 0;
		int t;

		t = num;

		while (num > 0) {
			r = num % 10;
			sum = (sum * 10) + r;
			num = num / 10;
		}
		if (t == sum) {
			System.out.println("Number is Palindrome");

		} else {
			System.out.println("Number is not Palindrome");
		}
	}
	public static void main(String[] args) {
            isNumberPalindrome(151);
            isNumberPalindrome(2022);
	}
}