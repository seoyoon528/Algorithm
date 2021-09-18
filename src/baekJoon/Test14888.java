package baekJoon;

import java.util.Scanner;

public class Test14888 {
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int result = 0;

	public static void main(String[] args) {
		Scanner  scan = new Scanner(System.in);
		int N = scan.nextInt();
		int sum = 0;
		
		if(N < 2 || N > 11) {
			System.out.println("It's out of range!");
		}
		
		int[] arr = new int[N];
		int[] operator = new int[4];
		
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		
		for(int i = 0; i < 4; i++) {
			operator[i] = scan.nextInt();
			sum += operator[i];
		}
		
		if(sum != N-1) {
			System.out.println("Sum must be N-1");
		}
		else {
			operate(arr, operator);
		}
		
	
	}
	
	public static int operate(int[] arr, int[] op) {		
		if(result > max) {
			max = result;
		}
		
		return max;
	}

}
