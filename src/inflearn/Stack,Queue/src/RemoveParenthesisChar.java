import java.util.Scanner;
import java.util.Stack;

/* Stack,Queue-02
 * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 */

public class RemoveParenthesisChar {
    public static void solution(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(');
            }
            else {
                stack.push(c);
            }

        }
        for (char x : stack) {
            System.out.print(x);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        solution(str);
    }
}
