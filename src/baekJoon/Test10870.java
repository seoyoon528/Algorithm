package baekJoon;

import java.util.Scanner;

public class Test10870 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		System.out.println(Fibonacci(n));
		
	}
	
	public static int Fibonacci(int num) {
		if (num <= 1) {
			return num;
		}
		return Fibonacci(num-1) + Fibonacci(num-2);
	}

}
