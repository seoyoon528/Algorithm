public class TargetNumber {
    static int answer = 0;
    public static int solution(int[] numbers, int target) {
        answer = 0;
        BFS(numbers, target, 0, 0, 0);
        return answer;
    }

    public static void BFS(int[] numbers, int target, int depth, int sum, int idx) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        BFS(numbers, target, depth + 1, sum + numbers[idx], idx + 1);
        BFS(numbers, target, depth + 1, sum - numbers[idx], idx + 1);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }
}
