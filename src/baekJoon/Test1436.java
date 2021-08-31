package baekJoon;

import java.util.Scanner;

public class Test1436 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int count = 1;
		int movie = 666;
		
		while(count != N) {
			movie++;
			
			if(String.valueOf(movie).contains("666")) {
				count++;
			}
		}
		
		System.out.print(movie);
	}

}
