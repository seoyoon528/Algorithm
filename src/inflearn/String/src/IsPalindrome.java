import java.util.Locale;
import java.util.Scanner;

/* String-07
  문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES",회문 문자열이 아니면 "NO"를 출력하는 프로그램을 작성하세요.
  단 회문을 검사할 때 대소문자를 구분하지 않습니다.
*/

public class IsPalindrome {
    public static void solution(String str) {
        int i = 0;
        boolean pal = true;
        str = str.toLowerCase(Locale.ROOT);

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
