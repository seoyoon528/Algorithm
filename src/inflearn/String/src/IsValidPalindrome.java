import java.util.Locale;
import java.util.Scanner;

public class IsValidPalindrome {
    public static void solution(String str) {
        int i = 0;
        boolean pal = true;
        str = str.toLowerCase(Locale.ROOT);
        str = str.replaceAll("[^a-z]", "");

        while (i < str.length() / 2) {
            if (str.charAt(i) != str.charAt(str.length()-(1+i))) {
                pal = false;
                break;
            }
            i++;
        }

        if (pal == true) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        solution(str);
    }
}
