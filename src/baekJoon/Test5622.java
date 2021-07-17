package baekJoon;
import java.util.Scanner;

public class Test5622 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		int cnt = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'C') {
				cnt = cnt + 3;
			}
			else if ('D' <= str.charAt(i) && str.charAt(i) <= 'F') {
				cnt = cnt + 4;
			}
			else if ('G' <= str.charAt(i) && str.charAt(i) <= 'I') {
				cnt = cnt + 5;
			}
			else if ('J' <= str.charAt(i) && str.charAt(i) <= 'L') {
				cnt = cnt + 6;
			}
			else if ('M' <= str.charAt(i) && str.charAt(i) <= 'O') {
				cnt = cnt + 7;
			}
			else if ('P' <= str.charAt(i) && str.charAt(i) <= 'S') {
				cnt = cnt + 8;
			}
			else if ('T' <= str.charAt(i) && str.charAt(i) <= 'V') {
				cnt = cnt + 9;
			}
			else if ('W' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				cnt = cnt + 10;
			}
		}
		
		System.out.println(cnt);
	}

}
