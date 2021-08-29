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
				
		//�߾Ӱ�
		int mid = 0;
		Arrays.sort(arr);
		mid = arr[N/2];
		
		//�ֺ�
		boolean flag = false;	// ������ ������ �ֺ��� 1���� �������� ��� true, �ƴ� ��� false
		int mode_max = 0; 	// �ֺ��� �󵵼�
		int mode = 10000;	// �ֺ� �ʱ�ȭ
		
		for(int i = 0; i < N; i++) {
			int jump = 0;	// ������ ���� ���¸�ŭ i�� jump
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
			
			// ���� �ֺ��� �ִ밪�� �����ϸ鼭 �� ���� �ߺ��Ǵ� ���
			else if(count == mode_max && flag == true) {
				mode = i_value;
				flag = false;
			}
			
			i += jump;
		}
		
		//����
		int min = arr[0];
		int max = arr[N-1];
		int range = max - min;
		
		System.out.println((int)Math.round((double)sum / N));
		System.out.println(mid);
		System.out.println(mode);
		System.out.println(range);
	}

}
