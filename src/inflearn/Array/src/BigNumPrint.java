import java.util.Scanner;

/* Array-01
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 * (첫 번째 수는 무조건 출력한다)
 */

public class BigNumPrint {
    public static void solution(int[] str) {
        for (int i = 0; i < str.length; i++) {
            if (i == 0) {
                System.out.print(str[i] + " ");
            }
            else {
                if (str[i] > str[i - 1]) {
                    System.out.print(str[i] + " ");
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] str = new int[n];
        for (int i = 0; i < n; i++) {
            str[i] = in.nextInt();
        }
        solution(str);
    }
}
