package baekJoon;

import java.util.Scanner;

public class Test10872 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if (n == 0) {
			System.out.println(1);
		}
		else {
			System.out.println(factorial(n));
		}
	}
	
	public static int factorial(int num) {
		if (num == 1) {
			return 1;
		}
		return num * factorial(num-1);
	}

}
