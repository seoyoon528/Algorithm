import java.util.Scanner;

/* Array-02
 * 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때,
 * 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요.
 * (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
 */

public class StudentInSight {
    public static void solution(int[] str) {
        int cnt = 1;
        int tmp = str[0];

        for (int i = 1; i < str.length; i++) {
            if (tmp < str[i]) {
                cnt++;
                tmp = str[i];
            }
        }
        System.out.print(cnt);
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
