package JavaPrograms;

public class armStrongNumber {

	public static void isArmStrongNumber(int num) {
        System.out.println("The given Number is :"+ num);
		int cube = 0;
		int r;
		int t;

		t = num;

			while (num > 0) {
				r = num % 10;
				num = num / 10;
				cube = cube + (r * r * r);
			}

			if (t == cube) {
				System.out.println("this is a armstrong number");
			} else {
				System.out.println("this is not an armstrong number");
			}
		}
	
	public static void main(String[] args) {
		isArmStrongNumber(153);
	}

}
