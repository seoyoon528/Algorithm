package baekJoon;
import java.util.Scanner;

public class Test11720 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n, sum = 0;
		String nums;
		
		n = scan.nextInt();
		nums = scan.next();
		
		for (int i = 0; i < n; i++) {
			sum += nums.charAt(i)-'0';
		}
		
        System.out.println(sum);
	}

}
