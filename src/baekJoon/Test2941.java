package baekJoon;
import java.util.Scanner;

public class Test2941 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		String croatia[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for (int i = 0; i < croatia.length; i++) {
			if(str.contains(croatia[i])) {
				str = str.replace(croatia[i], "0");
			}
		}
		System.out.println(str.length());
		
		// 노가다 방법
//		int cnt = 0;
//		
//		for (int i = 0; i < str.length(); i++) {
//			cnt++;
//			if (str.charAt(i) == 'c' && i < str.length() - 1) {
//				if (str.charAt(i+1) == '=' || str.charAt(i+1) == '-') {
//					i++;
//				}
//			}
//			else if (str.charAt(i) == 'd' && i < str.length() - 1) {
//				if(str.charAt(i+1) == '-') {
//					i++;
//				}
//				else if(str.charAt(i+1) == 'z' && i+1 < str.length() - 1) {
//					if (str.charAt(i+2) == '=') {
//						i = i+2;
//					}
//				}
//			}
//			else if (str.charAt(i) == 'l' || str.charAt(i) == 'n' && i < str.length() - 1) {
//				 if (str.charAt(i+1) == 'j') {
//					 i++;
//				 }
//			}
//			else if (str.charAt(i) == 's' || str.charAt(i) == 'z' && i < str.length() - 1) {
//				 if (str.charAt(i+1) == '=') {
//					 i++;
//				 }
//			}
//		}
//		System.out.println(cnt);
	}

}
