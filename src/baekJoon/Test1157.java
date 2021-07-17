package baekJoon;
import java.util.Arrays;
import java.util.Scanner;

public class Test1157 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		str = str.toUpperCase();
		
		int max = 0;
		int max_index = 0;
		boolean sameFlag = false;
		int alphabet[] = new int[26];
		
		Arrays.fill(alphabet, 0);
		
		for (int i = 0; i < str.length(); i++) {
			alphabet[str.charAt(i) - 'A']++;			
		}
		
		for (int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] > max) {
				max = alphabet[i];
				max_index = i;
				sameFlag = false;
			} 
			else if(max == alphabet[i]) {
				sameFlag = true;
			}
		}
		
		if (sameFlag == true) {
			System.out.println("?");
		} else {
			System.out.println((char)(max_index + 'A'));
		}
	}
}
