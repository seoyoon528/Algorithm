import java.util.Scanner;

/* Array-04
 * 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 입력은 피보나치 수열의 총 항의 수이다.
 */

public class Fibonacci {
    public static void solution(int n) {
        int[] fib = new int[n];
        fib[0] = 1;
        fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        for (int j = 0; j < n; j++) {
            System.out.print(fib[j] + " ");
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solution(n);
    }
}
