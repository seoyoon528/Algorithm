package baekJoon;

import java.util.Scanner;

public class Test10989 {	// ī���� ����

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int[] input = new int[N];		// ���� �� �迭
		int[] counting = new int[10001];	// ���� ���� 0 ~ 10000
		int[] result = new int[N];		// ���ĵ� �迭
		
		for(int i = 0; i < N; i++) {
			input[i] = scan.nextInt();
		}
		
		// input �迭�� ���� index�� �ϴ� counting �迭�� �� +1
		for(int i = 0; i < N; i++) {
			counting[input[i]]++;
		}
		
		// counting �迭�� ���� �� ���
		for(int i = 1; i < counting.length; i++) {
			counting[i] = counting[i] + counting[i-1];
		}
		
		/* i��° ���Ҹ� index�� �ϴ� counting �迭�� 1 ���ҽ�Ų ��,
		 counting �迭�� ���� index�� �Ͽ� result�� value�� ���� */
		for(int i = N-1; i >= 0; i--) {
			int value = input[i];
			counting[value]--;
			result[counting[value]] = value;
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(result[i]);
		}
		
	}

}
