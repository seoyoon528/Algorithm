package baekJoon;
import java.util.Scanner;
import java.util.Arrays;

public class Test10809 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arr[] = new int[26];
		Arrays.fill(arr, -1);
		
		String word = scan.next();
		
		for (int i = 0; i < word.length(); i++) {
			if (arr[word.charAt(i) - 97] == -1) {
				arr[word.charAt(i) - 97] = i;
			}
		}
		
		for (int i = 0; i < 26; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
