package JavaPrograms;

public class ReverseInteger {

	public static void main(String[] args) {
		
		//1. using while method
		int num= 12345;
		int rev = 0;
		
		while (num!= 0) {
			rev = rev*10  + num%10; // (0*10 + 5[reminder]) = 5
			num = num/10;	//12345/10 =	1234
		}

		System.out.println("Reverse of Integer is :" + rev);
		
		//2. Using StringBuffer Method
		
		int num1= 123456;
		System.out.println(new StringBuffer(String.valueOf(num1)).reverse());
	}
}