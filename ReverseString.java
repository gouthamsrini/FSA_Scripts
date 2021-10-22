package JavaPrograms;

public class ReverseString {

	public static void main(String[] args) {

		// String can be reversed in two ways
		// Method 1. Using for loop

		String s = "Selenium";
		int len = s.length();
		String rev = ""; // this is created due to store reverse string

		for (int i=len-1; i>=0; i--) {
			rev = rev +s.charAt(i);// charAt(i) will store the each string and then here we are appending with reverse object which is empty
		}
		System.out.println(rev);
		
		//Method 2. Using string buffer class
		
        StringBuffer sf = new StringBuffer(s);
        System.out.println(sf.reverse());
	}
}

   //   String Buffer is mutable whereas String is immutable object