package baekJoon;

import java.util.Scanner;

public class Test8958 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] score = new String[in.nextInt()];
		
		for(int i = 0; i < score.length; i++) {
			score[i] = in.next();
		}
		
		for(int i = 0; i < score.length; i++) {
			int count = 0, sum = 0;
			
			for(int j = 0; j < score[i].length(); j++) {
				if(score[i].charAt(j) == 'O') {
					count++;
				}
				else {
					count = 0;
				}
				sum = sum + count;
			}
			System.out.println(sum);
		}
	}
}
