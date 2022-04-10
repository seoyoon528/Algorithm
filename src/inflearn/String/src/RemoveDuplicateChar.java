import java.util.Scanner;

/* String-06
  소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
  중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
*/

public class RemoveDuplicateChar {
    public static String solution(String str) {
        String ans = "";
        int i = 0;

        while (i < str.length()) {
            if (str.indexOf(str.charAt(i)) == i) {
                ans += str.charAt(i);
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solution(str));
    }
}