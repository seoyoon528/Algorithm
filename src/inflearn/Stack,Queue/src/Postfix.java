import java.util.Scanner;
import java.util.Stack;

/* Stack,Queue-04
 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 */

public class Postfix {
    public static void solution(String str) {
        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '+') {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2+num1);
            }
            else if (c == '-') {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2-num1);
            }
            else if (c == '*') {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2*num1);
            }
            else if (c == '/') {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2/num1);
            }
            else {
                stack.push(Integer.parseInt(String.valueOf(c)));
            }
        }
        System.out.println(stack.peek());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        solution(str);
    }
}
