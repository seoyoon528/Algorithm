package baekJoon;
import java.util.Scanner;

public class Test2908 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		int r_num1 = 0, r_num2 = 0;
		
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		
//		if (num1 % 10 > num2 % 10) {
//			temp = num1;
//		}
//		else if (num1 % 10 < num2 % 10) {
//			temp = num2;
//		}
//		else {
//			if (num1 % 100 > num2 % 100) {
//				temp = num1;
//			}
//			else if (num1 % 100 < num2 % 100) {
//				temp = num2;
//			}
//			else {
//				if (num1 % 1000 > num2 % 1000) {
//					temp = num1;
//				}
//				else {
//					temp = num2;
//				}
//			}
//		}
//		while (temp != 0) {
//			result = result * 10 + temp % 10;
//			temp /= 10;
//		}
		
		
		while (num1 != 0) {
			r_num1 = r_num1 * 10 + num1 % 10;
			num1 /= 10;
		}
		
		while (num2 != 0) {
			r_num2 = r_num2 * 10 + num2 % 10;
			num2 /= 10;
		}
		
		if (r_num1 > r_num2) {
			System.out.println(r_num1);
		}
		else {
			System.out.println(r_num2);
		}
	}

}
