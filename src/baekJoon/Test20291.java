package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String file = br.readLine();
            int idx = file.indexOf(".") + 1;
            map.put(file.substring(idx), map.getOrDefault(file.substring(idx), 0) + 1);
        }

        // Key 기준 사전순 정렬을 위해 TreeMap 사용
        // TreeMap :: 키를 저장함과 동시에 자동 오름차순으로 정렬. 레드 블랙 트리로 이루어짐
        Map<String, Integer> sortedMap = new TreeMap<>(map);

        for (String key : sortedMap.keySet()) {
            System.out.println(key + " " + sortedMap.get(key));
        }

        // entry로 map에 접근해 출력하는 경우
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
    }
}
