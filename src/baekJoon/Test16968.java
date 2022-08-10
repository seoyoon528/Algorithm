import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test16968 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();
        int ans = 1;

        if (c[0] == 'c') ans *= 26;
        else if (c[0] == 'd') ans *= 10;

        for (int i = 1; i < c.length; i++) {

            if (c[i - 1] == c[i]) {
                if (c[i] == 'c') {
                    ans *= 25;
                }
                else ans *= 9;
            }
            else {
                if (c[i] == 'c') {
                    ans *= 26;
                }
                else ans *= 10;
            }
        }

        System.out.println(ans);
    }
}
