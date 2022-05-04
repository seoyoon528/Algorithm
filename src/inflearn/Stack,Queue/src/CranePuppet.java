import java.util.Scanner;
import java.util.Stack;

/* Stack,Queue-03
 * 게임개발자인 죠르디는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 합니다.
 * 죠르디는 게임의 재미를 높이기 위해 화면 구성과 규칙을 다음과 같이 게임 로직에 반영하려고 합니다.
 * 게임 화면은 1 x 1 크기의 칸들로 이루어진 N x N 크기의 정사각 격자이며 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다.
 * (위 그림은 5 x 5 크기의 예시입니다). 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다.
 * 모든 인형은 1 x 1 크기의 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다.
 * 모든 인형은 1 x 1 크기의 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다.
 * 게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다. 집어 올린 인형은 바구니에 쌓이게 되는 데,
 * 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다.
 * 크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.
 * 또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다.
 * 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,
 * 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구하는 프로그램을 작성하세요.
 */

public class CranePuppet {
    public static Stack<Integer> basket = new Stack<>();
    public static int cnt = 0;

    public static int solution(int n, int[][] board, int m, int[] moves) {
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n+1; j++) {
                int currentPick = board[j][moves[i]];
                if (currentPick != 0) {
                    checkBasket(currentPick);
                    board[j][moves[i]] = 0;
                    break;
                }
            }
        }
        return cnt;
    }

    public static int checkBasket(int currentPick) {
        if (!basket.isEmpty() && basket.peek() == currentPick) {
            basket.pop();
            cnt = cnt + 2;
        }
        else {
            basket.push(currentPick);
        }
        return cnt;
    }

    public static void main(String[] args) {
        CranePuppet T = new CranePuppet();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] board = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = in.nextInt();
            }
        }

        int m = in.nextInt();
        int[] moves = new int[m];
        for (int k = 0; k < m; k++) {
            moves[k] = in.nextInt();
        }

        System.out.println(T.solution(n, board, m, moves));
    }
}
