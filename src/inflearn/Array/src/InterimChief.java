import java.util.Scanner;

/* Array-11
 * 김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다.
 * 김갑동 선생님은 우선 임시로 반장을 정하고 학생들이 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고 한다.
 * 그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
 * 그래서 김갑동 선생님은 각 학생들이 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 표를 만들었다.
 * 위 경우에 4번 학생을 보면 3번 학생과 2학년 때 같은 반이었고, 3번 학생 및 5번 학생과 3학년 때 같은 반이었으며,
 * 2번 학생과는 4학년 때 같은 반이었음을 알 수 있다. 그러므로 이 학급에서 4번 학생과 한번이라도
 * 같은 반이었던 사람은 2번 학생, 3번 학생과 5번 학생으로 모두 3명이다.
 * 이 예에서 4번 학생이 전체 학생 중에서 같은 반이었던 학생 수가 제일 많으므로 임시 반장이 된다.
 * 각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.
 * 첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.
 * 단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.
 */

public class InterimChief {
    public static void solution(int n, int[][] arr) {
        int[] ans = new int[n];
        int tmp, max = Integer.MIN_VALUE, index = 0;

        for (int i = 0; i < n; i++) {       // i번 학생
            int cnt = 0;

            for (int j = 0; j < n; j++) {       //  i번 학생을 제외한 나머지 학생들

                for (int k = 0; k < 5; k++) {   // i번 학생의 k학년 반과 j번 학생들의 k학년 반 비교
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            ans[i] = cnt;
        }

        for (int i = 0; i < n; i++) {
            if (ans[i] > max) {
                max = ans[i];
                index = i;
            }
        }
        System.out.print(index + 1);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][5];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        solution(n, arr);
    }
}
