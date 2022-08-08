package day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1228 {

	public static void main(String[] args) throws IOException {
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			List<Integer> crypto = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				crypto.add(Integer.parseInt(st.nextToken()));
			}
			
			int orderNum = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			while (orderNum > 0) {
					String c = st.nextToken();
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					for (int i = 0; i < y; i++) {
						crypto.add(x, Integer.parseInt(st.nextToken()));
						x++;
					}
					orderNum--;
			}
			
			System.out.print("#"+test_case+" ");
			for (int i = 0; i < 10; i++) {
				System.out.print(crypto.get(i) + " ");
			}
			System.out.println();
		}
	}

}
