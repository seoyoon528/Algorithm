package baekJoon;

import java.util.Scanner;

public class Test14888 {
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] arr;
	static int result = 0;

	public static void main(String[] args) {
		Scanner  scan = new Scanner(System.in);
		N = scan.nextInt();
		
		if(N < 2 || N > 11) {
			System.out.println("It's out of range!");
		}
		
		arr = new int[N];
		int[] operator = new int[4];
		
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		
		for(int j = 0; j < 4; j++) {
			operator[j] = scan.nextInt();
		}
		
		operate(0, 0);
		
	
	}
	
	
	
	public static void operate(int total, int x) {		
		if(x == N) {
			if(total > max) {
				max = total;
			}
			else if(total < min) {
				min = total;
			}
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			switch(i) {
			case 0:
				operate(total + arr[x], x + 1);
				break;
			
			case 1:
				operate(total - arr[x], x + 1);
				break;
			
			case 2:
				operate(total * arr[x], x + 1); 
				break;
			case 3:
				operate(total / arr[x], x + 1);
			}	
		}
	}

}
