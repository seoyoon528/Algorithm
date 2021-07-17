package baekJoon;

import java.util.Scanner;

public class Test1546 {

	public static void main(String[] args) {
		int N;
		double avg = 0, max = 0, sum = 0;
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		
		double[] scores = new double[N];
		
		for(int i = 0; i < N; i++) {
			scores[i] = in.nextDouble();

			if (scores[i] > max) {
				max = scores[i];
			}
		}
		
		for(int j = 0; j < N; j++) {
			scores[j] = scores[j]/max*100;
			sum += scores[j];
		}
		
		avg = sum / N;
		
		System.out.println(avg);
	}

}
