package baekJoon;
import java.util.Scanner;

public class Test2292 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int room = scan.nextInt();
		int ans = 1;
		int n = 1;
		int add = 0;
		
		// 1, 2~7(6), 8~19(12), 20~37(18), 38~61(24)
		
		while(n < room) {
			ans++;
			add = add + 6;
			n += add;
		}
		System.out.println(ans);
	}

}
