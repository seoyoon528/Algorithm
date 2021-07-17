package baekJoon;
import java.util.Scanner;

public class Test2675 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		int[] repeat = new int[test];
		String[] str = new String[20];
		
		for (int i = 0; i < test; i++) {
			repeat[i] = scan.nextInt();
			str[i] = scan.next();
			
		}
		
		for (int i = 0; i < test; i++) {
			for (int j = 0; j < str[i].length(); j++) {
				for (int k = 1; k <= repeat[i]; k++) {
					System.out.print(str[i].charAt(j));
				}
			}
			System.out.println(" ");
		}
	}

}
