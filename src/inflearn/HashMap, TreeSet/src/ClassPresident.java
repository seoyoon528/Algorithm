import java.util.HashMap;
import java.util.Scanner;

/* HashMap, TreeSet-01
 * 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
 * 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
 * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
 * 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
 */

public class ClassPresident {
    public static void solution(int n, String str) {
        char ans = ' ';
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : str.toCharArray()) {      // map을 돌며
            map.put(x, map.getOrDefault(x, 0)+1);   // 같은 key를 만나면 값을 1씩 증가시킴
                                                                // getOrDefault :: key의 값이 존재하지 않는다면 default로 설정해준 값을 넣어줌
        }

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {     // map의 key를 탐색하며(map.keySet())
//            System.out.println(key + " " + map.get(key));   // map의 key와 key의 값을 가져옴
            if (map.get(key) > max) {
                max = map.get(key);
                ans = key;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        solution(n, str);
    }
}
