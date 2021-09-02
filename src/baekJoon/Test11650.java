package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test11650 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] coor = new int[N][2];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			coor[i][0] = Integer.parseInt(st.nextToken());
			coor[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//Comparator ��� -> ���ٽ����� ����
		Arrays.sort(coor, (e1, e2) -> {
			if(e1[0] == e2[0]) {	// x��ǥ�� ������
				return e1[1] - e2[1];	// y��ǥ�� ���Ͽ� ����
			}
			else {	// x��ǥ�� �ٸ���
				return e1[0] - e2[0];	// x��ǥ�� ���Ͽ� ����
			}
		});
		
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i< N ; i++) {
			sb.append(coor[i][0] + " " + coor[i][1]).append('\n');
		}
		System.out.println(sb);
	}

}
