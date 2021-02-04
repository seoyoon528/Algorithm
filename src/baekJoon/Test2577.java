package baekJoon;

import java.util.Scanner;

public class Test2577 {

	public static void main(String[] args) {
		int mul = 0, len=0;
		int[] num = new int[10];
		int[] count = new int[10];
		Scanner in = new Scanner(System.in);
		
		mul = in.nextInt() * in.nextInt() * in.nextInt();
		
		while (true) {
			num[len] = mul%10;
			mul = mul/10;
			len++;

			if (mul < 1) {
				break;
			}
		}
				
		for (int i = 0; i < len; i++) {
			count[num[i]]++;
		}

		for (int j = 0; j < 10; j++) {
			System.out.println(count[j]);
		}
	}

}
