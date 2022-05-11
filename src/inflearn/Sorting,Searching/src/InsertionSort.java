import java.util.Scanner;

/* Sorting,Searching-03
 * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 * 정렬하는 방법은 삽입정렬입니다.
 */

public class InsertionSort {
    public static int[] solution(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int tmp = arr[i], j;
            for (j = i-1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                }
                else break;
            }
            arr[j+1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        InsertionSort T = new InsertionSort();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int x : T.solution(arr)) System.out.print(x + " ");
    }
}
