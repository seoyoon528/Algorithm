package baekJoon;
import java.util.Scanner;

public class Test1712 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();

		if (B >= C) {
			System.out.println(-1);
		}
		else {
			//A + nB < nC ->  n > A/(C-B)
			System.out.println(A/(C-B) + 1);
		}
	}

}
