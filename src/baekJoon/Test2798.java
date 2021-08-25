package baekJoon;

import java.util.Scanner;

public class Test2798 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		int arr[] = new int[N];
		
 		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
 		
 		System.out.println(blackJack(arr, N, M));
	}
	
	public static int blackJack(int arr[], int N, int M) {
		int sum = 0;
		int max = 0;
		
 		for(int i = 0; i < arr.length-2; i++) {
 			for(int j = i+1; j < arr.length-1; j++) {
 				for(int k = j+1; k < arr.length; k++) {
 					
 					if (i != j || j != k || i != k) {	
 						sum = arr[i] + arr[j] + arr[k];
 						
 				 		if(sum > max) {
 				 			if (sum <= M) { 				 				
 				 				max = sum;
 				 			}
 				 		}
 					}
 				}
 			}
 		}
 		
 		return max;
	}
}
