package baekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class Test2108 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
			sum += arr[i];
		}
				
		//중앙값
		int mid = 0;
		Arrays.sort(arr);
		mid = arr[N/2];
		
		//최빈값
		boolean flag = false;	// 이전의 동일한 최빈값이 1번만 등장했을 경우 true, 아닐 경우 false
		int mode_max = 0; 	// 최빈값의 빈도수
		int mode = 10000;	// 최빈값 초기화
		
		for(int i = 0; i < N; i++) {
			int jump = 0;	// 동일한 수가 나온만큼 i값 jump
			int count = 1;
			int i_value = arr[i];
			
			for(int j = i + 1; j < N; j++) {
				if (i_value != arr[j]) {
					break;
				}
				count++;
				jump++;
			}
			
			if(count > mode_max) {
				mode_max = count;
				mode = i_value;
				flag = true;	
			}
			
			// 이전 최빈값의 최대값과 동일하면서 한 번만 중복되는 경우
			else if(count == mode_max && flag == true) {
				mode = i_value;
				flag = false;
			}
			
			i += jump;
		}
		
		//범위
		int min = arr[0];
		int max = arr[N-1];
		int range = max - min;
		
		System.out.println((int)Math.round((double)sum / N));
		System.out.println(mid);
		System.out.println(mode);
		System.out.println(range);
	}

}
