package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test11650 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner scan = new Scanner(System.in);
//		int N = scan.nextInt();
//		int[][] coor = new int[N][2];
//		
//		for(int i = 0; i < N; i++) {
//			coor[i][0] = scan.nextInt();
//			coor[i][1] = scan.nextInt();				
//
//		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//Comparator ��� -> ���ٽ����� ����
//		Arrays.sort(coor, (e1, e2) -> {
//			if(e1[0] == e2[0]) {	// x��ǥ�� ������
//				return e1[1] - e2[1];	// y��ǥ�� ���Ͽ� ����
//			}
//			else {	// x��ǥ�� �ٸ���
//				return e1[0] - e2[0];	// x��ǥ�� ���Ͽ� ����
//			}
//		});
		
		
		//��û�� �ڵ�
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				
				int temp = 0;
				
				if(arr[i][0] >= arr[j][0]) {

					for(int k = 0; k < 2; k++) {
						temp = arr[i][k];
						arr[i][k] = arr[j][k];
						arr[j][k] = temp;		
					}
					
					if(arr[i][1] > arr[j][1]) {
						for(int k = 0; k < 2; k++) {
							temp = arr[i][k];
							arr[i][k] = arr[j][k];
							arr[j][k] = temp;		
						}
					}
				
				}	
			}

		}
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(coor[i][0] + " " + coor[i][1]);
//		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i< N ; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
		}
		System.out.println(sb);
	}
//	}

}
