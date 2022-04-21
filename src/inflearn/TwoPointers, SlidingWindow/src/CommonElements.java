import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* Two Pointers,Sliding Window-02
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 */

public class CommonElements {
    public static void solution(int n, int m, int[] arrA, int[] arrB){
        ArrayList<Integer> newArr = new ArrayList<>();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int pa = 0, pb = 0;

        while (pa < n && pb < m) {
            if (arrA[pa] == arrB[pb]) {
                newArr.add(arrA[pa++]);
                pb++;
            }
            else if (arrA[pa] > arrB[pb]){
                pb++;
            }
            else {
                pa++;
            }
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
