package baekJoon;
import java.util.Arrays;
import java.util.Scanner;

public class Test1316 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		num = scan.nextInt();
		
		int checker = num;
		boolean croatia[] = new boolean[26];
		
		for (int i = 0; i < num; i++) {
			Arrays.fill(croatia, false);
			String str = scan.next();
			
			for (int j = 0; j < str.length(); j++) {
				if (croatia[str.charAt(j) - 97] == false) {
					croatia[str.charAt(j) - 97] = true;
				}
				
				else {
					if (str.charAt(j) > 0 && str.charAt(j) != str.charAt(j-1)) {
						checker--;
						break;
					}
				}
			}
		}
		
		System.out.println(checker);
	}

}
