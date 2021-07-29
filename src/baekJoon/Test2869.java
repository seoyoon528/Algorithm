package baekJoon;
import java.util.Scanner;

public class Test2869 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int up = scan.nextInt();
		int down = scan.nextInt();
		int high = scan.nextInt();
		
		int days = (high - down) / (up - down);
		
		if ((high - up) % (up - down) > 0) {
			days++;
		}
		
		System.out.println(days);
		
	}

}
