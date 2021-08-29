package baekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class Test1427 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String num = scan.nextLine();
		char[] arr = num.toCharArray();
		
		Arrays.sort(arr);

		for(int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
	}

}
