import java.util.Arrays;

public class HIndex {
    public static int solution(int[] citations) {
        // {6, 5, 3, 1, 0} -> {0, 1, 3, 5, 6}
        // 1 -> 6 [3]
        // 2 -> 5 [2]
        // 3 -> 3 [1] H-Index
        // 4 -> 1 [0]

        // {10, 8, 5, 4, 3} -> {3, 4, 5, 8, 10}
        // 1 -> 10 [4]
        // 2 -> 8 [3]
        // 3 -> 5 [2]
        // 4 -> 4 [1] H-Index
        // 5 -> 3 [0]

        // {12, 11, 10, 9, 8, 1} -> {1, 8, 9, 10, 11, 12}
        // 1 -> 12 [5]
        // 2 -> 11 [4]
        // 3 -> 10 [3]
        // 4 -> 9 [2]
        // 5 -> 8 [1] H-Index
        // 6 -> 1 [0]

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
