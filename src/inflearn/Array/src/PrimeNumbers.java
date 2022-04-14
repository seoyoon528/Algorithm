import java.util.Scanner;

/* Array-05
* 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
*/

public class PrimeNumbers {
    public static void solution(int n) {
        int prime = 0;
        int[] num = new int[n+1];

        for(int i = 2; i <= n; i++) {
            if (num[i] == 0) {
                prime++;
                for (int j = i; j <= n; j= j+i){
                    num[j] = 1;
                }
            }
        }
        System.out.print(prime);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solution(n);
    }
}
