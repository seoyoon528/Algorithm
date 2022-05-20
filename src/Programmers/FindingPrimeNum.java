import java.util.HashSet;
import java.util.Scanner;

public class FindingPrimeNum {
    static boolean[] visited;
    static String numbers;
    static HashSet<Integer> set;

    public static void solution(int depth, String cur) {
        if (depth == numbers.length()) return;

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i] == true) {
                continue;
            }
            else {
                String number = cur + numbers.charAt(i);

                if (isPrime(Integer.parseInt(number))) {
                    set.add(Integer.parseInt(number));
                }
                visited[i] = true;
                solution(depth+1, number);
                visited[i] = false;
            }

        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num > 1) {
           for (int i = 2; i <= Math.sqrt(num); i++) {
               if (num % i == 0) {
                   return false;
               }
           }
        }
       return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        numbers = in.next();
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        solution(0, "");
        System.out.println(set.size());
    }
}
