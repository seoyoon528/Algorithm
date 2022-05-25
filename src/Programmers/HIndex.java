import java.util.Arrays;

public class HIndex {
    public static int solution(int[] citations) {
        // {6, 5, 3, 1, 0} -> {0, 1, 3, 5, 6}
        // 0 ->
        // 1 -> 6
        // 2 -> 5
        // 3 -> 3 H-Index
        // 4 -> 1

        // {10, 8, 5, 4, 3} -> {3, 4, 5, 8, 10}
        // 0 ->
        // 1 -> 10
        // 2 -> 8
        // 3 -> 5
        // 4 -> 4 H-Index
        // 5 -> 3

        // {12, 11, 10, 9, 8, 1} -> {1, 8, 9, 10, 11, 12}
        // 0 ->
        // 1 -> 12
        // 2 -> 11
        // 3 -> 10
        // 4 -> 9
        // 5 -> 8 H-Index
        // 6 -> 1

        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int min = Math.min(citations[i], citations.length-i);
            answer = Math.max(min, answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4, 4, 4};
        System.out.println(solution(arr));
    }
}
