package baekJoon;
import java.util.Scanner;

public class Test1152 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str;
		int cnt = 0;

		str = scan.nextLine();
		str = str.trim();
		
		if (str.isEmpty()) {
			System.out.println(0);
		} 
		else {
			for (int i = 0; i < str.length(); i++) {	
				if (str.charAt(i) == ' ') {
						cnt++;
				}
			}
			System.out.println(cnt + 1);		
		}
	}
}
