import java.util.Scanner;

/* String-10
  한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진
  최소거리를 출력하는 프로그램을 작성하세요.
*/

public class ShortestCharDistance {
    public static void solution(String str, char t) {
        int i = 0;
        int[] ans = new int[str.length()];

        while (i < str.length()) {
            int lt = i, rt = i;
            boolean lbool = false, rbool = false;

            if (i == 0) {
                while (rt < str.length()) {
                    if (str.charAt(rt) == t) {
                        ans[i] = rt - i;
                        break;
                    }
                    rt++;
                }
            }
            else if (i == str.length()-1) {
                while (lt > 0) {
                    if (str.charAt(lt) == t) {
                        ans[i] = i - lt;
                        break;
                    }
                    lt--;
                }
            }
            else {
                while (rt < str.length()) {
                    if (str.charAt(rt) == t) {
                        rbool = true;
                        break;
                    }
                    rt++;
                }
                while (lt >= 0) {
                    if (str.charAt(lt) == t) {
                        lbool = true;
                        break;
                    }
                    lt--;
                }

                if (lbool == false && rbool == true) {
                    ans[i] = rt - i;
                }
                else if (lbool == true && rbool == false) {
                    ans[i] = i - lt;
                }
                else {
                    ans[i] = min(i - lt, rt - i);
                }
            }
            i++;
        }

        for (int j = 0; j < str.length(); j++) {
            System.out.print(ans[j] + " ");
        }
    }

    public static int min(int x, int y) {
        if (x < y) {
            return x;
        } else {
            return y;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char t = in.next().charAt(0);
        solution(str, t);
    }
}
