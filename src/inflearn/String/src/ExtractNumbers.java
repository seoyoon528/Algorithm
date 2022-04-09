import java.util.Scanner;

public class ExtractNumbers {
    public static void solution(String str) {
        int i = 0;
        str = str.replaceAll("[^0-9]", "");
        while (i < str.length()) {
            if (str.charAt(i) != '0') {
                break;
            }
            i++;
        }
        str = str.substring(i);
        System.out.println(Integer.valueOf(str));
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        solution(str);
    }
}
