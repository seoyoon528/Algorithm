import java.util.Locale;
import java.util.Scanner;

/* String-08
  문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
  단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
  알파벳 이외의 문자들의 무시합니다.
*/

public class IsValidPalindrome {
    public static void solution(String str) {
        int i = 0;
        boolean pal = true;
        str = str.toLowerCase(Locale.ROOT);
        str = str.replaceAll("[^a-z]", "");

        while (i < str.length() / 2) {
            if (str.charAt(i) != str.charAt(str.length()-(1+i))) {
                pal = false;
                break;
            }
            i++;
        }

        if (pal == true) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        solution(str);
    }
}
