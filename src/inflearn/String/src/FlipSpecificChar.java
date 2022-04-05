import java.util.Scanner;

public class FlipSpecificChar {
    public static void solution(String str) {
        String[] ans = new String[str.length()];
        char tmp;
        int lt = 0, rt = str.length() - 1;     // left, right index

        while (lt <= rt) {
            if (Character.isLetter(str.charAt(lt))) {
                if (Character.isLetter(str.charAt(rt))) {
                    tmp = str.charAt(lt);
                    ans[lt] = String.valueOf(str.charAt(rt));
                    ans[rt] = String.valueOf(tmp);
                    rt--;
                    lt++;
                } else {
                    ans[rt] = String.valueOf(str.charAt(rt));
                    rt--;
                }
            }
            else {
                ans[lt] = String.valueOf(str.charAt(lt));
                lt++;
            }
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        }
}

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        solution(str);
    }
}
