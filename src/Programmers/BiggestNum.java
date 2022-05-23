import java.util.Arrays;

public class BiggestNum {
    static int max = Integer.MIN_VALUE;

    public static String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        // TODO 정렬 알고리즘 다시 짜기
        Arrays.sort(str);

        answer = String.valueOf(max);
        return answer;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {6, 10, 2};
        System.out.println(solution(arr));
    }
}
