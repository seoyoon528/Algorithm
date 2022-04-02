import java.util.ArrayList;
import java.util.Scanner;

/* String-04
  N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
*/

public class WordFlip {
    public static ArrayList<String> solution(int n, String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        String tmp = "";
        for (int i = 0; i < n; i++) {
            for (int j = words[i].length() - 1; j >= 0; j--) {
               tmp += words[i].charAt(j);
            }
            ans.add(tmp);
            tmp = "";
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = in.next();
        }

        for (String x : solution(n, words)) {
            System.out.println(x);
        }
    }
}
