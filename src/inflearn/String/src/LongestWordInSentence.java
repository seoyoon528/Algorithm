import java.util.Scanner;

/* String-03
  한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
  문장속의 각 단어는 공백으로 구분됩니다.
  가장 길이가 긴 단어가 여러개일 경우 문장 속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.
*/

public class LongestWordInSentence {
    public static String solution (String str) {
        String[] words = str.split(" ");
        String LongestWord = "";

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > LongestWord.length()) {
                LongestWord = words[i];
            }
        }
        return LongestWord;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solution(str));
    }
}
