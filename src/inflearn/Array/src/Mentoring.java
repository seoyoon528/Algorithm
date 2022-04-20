import java.util.Scanner;

/* Array-12
   현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
   멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
   선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
   만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
 */

public class Mentoring {
    public static void solution(int n, int m, int[][] arr) {
        int ans = 0;

        for (int i = 1; i <= m; i++) {      // i번 학생
            for (int j = 1; j <= n; j++) {      // j번 학생
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int pi=0, pj=0;     // pi :: i의 position, pj :: j의 position

                    for (int s = 0; s < n; s++) {
                        if (arr[k][s] == i) {
                            pi = s;
                        }
                        if (arr[k][s] == j) {
                            pj = s;
                        }
                    }
                    if (pi < pj) {
                        cnt++;
                    }
                }
                if (cnt == m) {
                    ans++;
                }
            }
        }
        System.out.print(ans);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        solution(n, m, arr);
    }
}
