package baekJoon;

import java.util.Scanner;

public class Test2231 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
				
		for(int i = 0; i < N; i++) {
			int temp = i;
			int sum = 0;
			
			while (temp > 0) {
				sum = sum + temp % 10;
				temp = temp / 10;
			}
			
			if ((i + sum) == N) {
				System.out.println(i);
				break;
			}
		}
				
	}

}
