package baekJoon;

import java.util.Scanner;

public class Test10989 {	// 카운팅 정렬

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int[] input = new int[N];		// 정렬 전 배열
		int[] counting = new int[10001];	// 수의 범위 0 ~ 10000
		int[] result = new int[N];		// 정렬된 배열
		
		for(int i = 0; i < N; i++) {
			input[i] = scan.nextInt();
		}
		
		// input 배열의 값을 index로 하는 counting 배열의 값 +1
		for(int i = 0; i < N; i++) {
			counting[input[i]]++;
		}
		
		// counting 배열의 누적 합 계산
		for(int i = 1; i < counting.length; i++) {
			counting[i] = counting[i] + counting[i-1];
		}
		
		/* i번째 원소를 index로 하는 counting 배열을 1 감소시킨 뒤,
		 counting 배열의 값을 index로 하여 result에 value값 저장 */
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
