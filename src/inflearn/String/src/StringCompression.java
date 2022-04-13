import java.util.Scanner;

/* String-11
  알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는 문자
  바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
  단 반복 횟수가 1인 경우 생략합니다.
*/

public class StringCompression {
    public static void solution(String str) {
        str += " ";
        String ans = "";
        int i = 1, cnt = 1;

        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(i-1)) {
                cnt++;
            }
            else {
                if (cnt > 1) {
                    ans += str.charAt(i-1);
                    ans += String.valueOf(cnt);
                }
                else {
                    ans += str.charAt(i-1);
                }
                cnt = 1;
            }
            i++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        solution(str);
    }
}
