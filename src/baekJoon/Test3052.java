package baekJoon;

import java.util.Scanner;

public class Test3052 {

	public static void main(String[] args) {
		int n, result = 0;
		int rest[] = new int[10];
		Scanner in = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++) {
			n = in.nextInt();
			rest[i] = n % 42;
		}
		
		for(int j = 0; j < 10; j++) {
			int count = 0;
			for (int k = j+1; k < 10; k++) {
				if (rest[j] == rest[k]) {
					count++;
				}
			}
			if (count == 0) {
				result++;
			}
		}
		System.out.println(result);
	}
}
