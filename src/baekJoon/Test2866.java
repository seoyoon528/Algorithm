package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Test2866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] arr = new char[r][c];
        int ans = 0;

        // 문장을 입력받아 배열에 저장
        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        // 저장된 배열의 값으로 열로 이루어진 문자열 배열 생성
        String[] word = new String[c];

        for (int i = 0; i < c; i++) {
            String tmp = "";
            for (int j = 0; j < r; j++) {
                tmp += arr[j][i];
            }
            word[i] = tmp;
        }

        Loop1 :
        for (int i = 1; i < r; i++) {   // 두번째 행부터 시작
            HashSet<String> set = new HashSet<>();

            Loop2 :
            for (int j = 0; j < c; j++) {
                String cur = word[j].substring(i);

                // cur가 중복된 문자열이라면 Loop1까지 빠져나오고 break
                if (set.contains(cur)) {
                    break Loop1;
                }
                // 없다면 set에 cur 문자열 추가
                else set.add(cur);
            }
            ans++;
        }
        System.out.println(ans);
    }
}
