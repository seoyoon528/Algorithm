package baekJoon;

import java.util.Scanner;

public class Test1110 {

	public static void main(String[] args) {
		int init, copy, count = 0;
		Scanner in = new Scanner(System.in);
		
		init = in.nextInt();
		copy = init;
		
		while(true) {
			int newN;

			newN = ((copy%10)*10) + (((copy/10) + (copy%10))%10);
			System.out.println("newN = " + newN);
			count++;
			
			if (init == newN) {
				System.out.println("종료합니다. = " + count);
				break;
			}
			copy = newN;
		}
	}
}
