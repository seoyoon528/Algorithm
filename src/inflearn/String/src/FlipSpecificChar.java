import java.util.Scanner;

/* String-05
  영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
  특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
*/

public class FlipSpecificChar {
    public static void solution(String str) {
        String[] ans = new String[str.length()];
        char tmp;
        int lt = 0, rt = str.length() - 1;     // left, right index

        while (lt <= rt) {
            if (Character.isLetter(str.charAt(lt))) {
                if (Character.isLetter(str.charAt(rt))) {
                    tmp = str.charAt(lt);
                    ans[lt] = String.valueOf(str.charAt(rt));
                    ans[rt] = String.valueOf(tmp);
                    rt--;
                    lt++;
                } else {
                    ans[rt] = String.valueOf(str.charAt(rt));
                    rt--;
                }
            }
            else {
                ans[lt] = String.valueOf(str.charAt(lt));
                lt++;
            }
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        }
}

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        solution(str);
    }
}
