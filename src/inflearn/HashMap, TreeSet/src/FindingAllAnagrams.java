import java.util.HashMap;
import java.util.Scanner;

/* HashMap, TreeSet-04
 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 */

public class FindingAllAnagrams {
    public static void solution(String str1, String str2) {
        int ans = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (char i : str2.toCharArray()) {
            tMap.put(i, tMap.getOrDefault(i, 0) + 1);
        }

        for (int j = 0; j < str2.length()-1; j++) {
            sMap.put(str1.charAt(j), sMap.getOrDefault(str1.charAt(j), 0) + 1);
        }

        int lt = 0;
        for (int k = str2.length()-1; k < str1.length(); k++) {
            sMap.put(str1.charAt(k), sMap.getOrDefault(str1.charAt(k), 0) + 1);
            if (sMap.equals(tMap)) {
                ans++;
            }
            sMap.put(str1.charAt(lt), sMap.get(str1.charAt(lt))-1);
            if (sMap.get(str1.charAt(lt)) == 0) {
                sMap.remove(str1.charAt(lt));
            }
            lt++;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        solution(str1, str2);
    }
}
