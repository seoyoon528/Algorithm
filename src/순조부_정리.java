import java.util.Arrays;
public class 순조부_정리 {

	static int[] arr = {1, 2, 3, 4, 5, 6};
	static boolean[] visit;
	static int[] result;
	
	public static void main(String[] args) {
		visit = new boolean[6];
		result = new int[3];
		
//		perm(0);
//		dupPerm(0);
//		comb1(0, 0);
//		comb2(0, 0);
//		dupComb(0, 0);
		subset(0);
	}
	
	// 순열 => 순서를 고려해서 짜요! {1, 2, 3}, {1, 2, 4}, {1, 2, 5}, {1, 2, 6}, {2, 1, 3}
	static void perm(int cnt) {
		if (cnt == 3) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (visit[i]) continue;
			result[cnt] = arr[i];
			visit[i] = true;
			perm(cnt + 1);
			visit[i] = false;
 		}
	}
	
	static void dupPerm(int cnt) {
		if (cnt == 3) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			result[cnt] = arr[i];
			dupPerm(cnt + 1);
		}
	}

	// 재귀 버전
	static void comb1(int idx, int cnt) {
		if (cnt == 3) {
			System.out.println(Arrays.toString(visit));
			return;
		}
		
		if (idx == arr.length) return;
		
		visit[idx] = true;
		comb1(idx + 1, cnt + 1);
		visit[idx] = false;
		comb1(idx + 1, cnt);
	}
	
	// for문 버전
	static void comb2(int cnt, int start) {
		if (cnt == 3) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			result[cnt] = arr[i];
			comb2(cnt + 1, i + 1);
		}
	}

  	// for문 버전
	static void comb3(int cnt, int start) {
		if (cnt == 3) {
			System.out.println(Arrays.toString(visit));
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			visit[i] = true;
			comb2(cnt + 1, i + 1);
			visit[i] = false;
		}

	} 
	
	static void dupComb(int cnt, int start) {
		if (cnt == 3) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			result[cnt] = arr[i];
			dupComb(cnt + 1, i);
		}
	}
	
	static void subset(int idx) {
		if (idx == arr.length) {
			System.out.println(Arrays.toString(visit));
			return;
		}
		
		visit[idx] = true;
		subset(idx + 1);
		visit[idx] = false;
		subset(idx + 1);
	}
}
