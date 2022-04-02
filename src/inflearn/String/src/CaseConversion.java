import java.util.Scanner;

/* String-02
    대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여
    출력하는 프로그램을 작성하세요.
*/

public class CaseConversion {
    public static void solution(String str) {
        String ans = "";
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                ans += Character.toUpperCase(c);
            } else {
                ans += Character.toLowerCase(c);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        solution(str);
    }
}
