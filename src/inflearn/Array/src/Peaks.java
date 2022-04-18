import java.util.Scanner;

/* Array-10
 * 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
 * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
 * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 * 만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
 */

public class Peaks {
    public static void solution(int n, int[][] arr) {
        int cnt = 0;

        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= n; k++) {
                if (findPeak(arr, j, k)) {
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }

    public static boolean findPeak(int arr[][], int x, int y) {
        if (arr[x][y] > arr[x-1][y] && arr[x][y] > arr[x+1][y] && arr[x][y] > arr[x][y-1] && arr[x][y] > arr[x][y+1]) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n+2][n+2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        solution(n, arr);
    }
}
