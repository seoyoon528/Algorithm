package baekJoon;

import java.util.Scanner;

public class Test4344 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int C = in.nextInt();
		double[] result = new double[C];
		
		for(int i = 0; i < C; i++) {
			double avg = 0;
			int sum = 0;
			
			int N = in.nextInt();
			int[] score = new int[N];
			
			for(int j = 0; j < N; j++) {
				score[j] = in.nextInt();
				sum += score[j];
			}
			
			avg = sum / N;

			double up = 0; // up�� double�� �������� ������ ����� ����� �ȳ���!
			for(int k = 0; k < N; k++) {
				if (score[k] > avg) {
					up++;
				}
			}
			
			result[i] = (up / N) * 100;
		}
		
		for (int i = 0; i < C; i++) {
			System.out.printf("%.3f%%\n", result[i]); //'%'�� ���� ���ؼ� '%%' �����
		}
	}

}
