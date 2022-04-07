import java.util.Scanner;

public class RemoveDuplicateChar {
    public static String solution(String str) {
        String ans = "";
        int i = 0;

        while (i < str.length()) {
            if (str.indexOf(str.charAt(i)) == i) {
                ans += str.charAt(i);
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solution(str));
    }
}