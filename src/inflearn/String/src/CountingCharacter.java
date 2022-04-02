import java.util.Scanner;

/* String-01
  한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
  대소문자를 구분하지 않습니다. 문자열의 길이는 100을 넘지 않습니다.
*/

public class CountingCharacter {
    public static int solution(String str, char c) {
        int cnt = 0;
        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        CountingCharacter T = new CountingCharacter();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char c = in.next().charAt(0);       // in.next().charAt(0) :: char 1개 입력받기
        System.out.println(solution(str, c));
    }
}


