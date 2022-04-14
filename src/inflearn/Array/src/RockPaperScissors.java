import java.util.Scanner;

/* Array-03
 * A, B 두 사람이 가위바위보 게임을 합니다.
 * 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
 * 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
 */

public class RockPaperScissors {
    public static void solution(int n, int[] A, int[] B) {
        for (int i = 0; i < n; i++) {
            System.out.println(rockPaperScissorsRule(A[i], B[i]));
        }
    }

    public static String rockPaperScissorsRule(int a, int b) {
        if ((a == 1 && b == 2) || (a == 2 && b == 3) || (a == 3 && b == 1)) {
            return "B";
        }
        else if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2)) {
            return "A";
        }
        else {
            return "D";
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = in.nextInt();
        }
        solution(n, A, B);
    }
}
