import java.util.ArrayList;
import java.util.Scanner;

/* Two Pointers,Sliding Window-01
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 */

public class ArrayConcatenation {
    public static void solution(int n, int m, int[] arrA, int[] arrB){
        ArrayList<Integer> newArr = new ArrayList<>();
        int pa = 0, pb = 0;

        while (pa < n && pb < m) {
            if (arrA[pa] < arrB[pb]) {
                newArr.add(arrA[pa++]);
            } else {
                newArr.add(arrB[pb++]);
            }
        }
        while (pa < n) {
            newArr.add(arrA[pa++]);
        }
        while (pb < m) {
            newArr.add(arrB[pb++]);
        }

        for (int i : newArr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arrA[] = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = in.nextInt();
        }

        int m = in.nextInt();
        int arrB[] = new int[m];
        for (int j = 0; j < m; j++) {
            arrB[j] = in.nextInt();
        }
        solution(n, m, arrA, arrB);
    }
}
