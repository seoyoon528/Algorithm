package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Test11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int ans = 0;

        // HashMap 버전
//        HashMap<String, Integer> hm = new HashMap<>();
//        for (int i = 0; i < S.length(); i++) {
//            String tmp = "";
//            for (int j = i; j < S.length() ; j++) {
//                tmp += S.substring(j, j+1);
//                hm.put(tmp, hm.getOrDefault(tmp, 0) + 1);
//            }
//        }
//        ans = hm.keySet().size();시

        // HashSet 버전
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < S.length(); i++) {
            String tmp = "";
            for (int j = i; j < S.length(); j++) {
                tmp += S.substring(j, j+1);
                hs.add(tmp);
            }
        }
        ans = hs.size();
        System.out.println(ans);
    }
}
