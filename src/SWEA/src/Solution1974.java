import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution1974 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int[][] puzzle = new int[9][9];
            Integer[] numArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            int ans = 1;

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    puzzle[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < 9; i++) {
                // 가로줄 체크
                ArrayList<Integer> numHorArrayList = new ArrayList<Integer>(Arrays.asList(numArr));
                for (int j = 0; j < 9; j++) {
                    if (numHorArrayList.contains(puzzle[i][j])) {
                        numHorArrayList.remove(numHorArrayList.indexOf(puzzle[i][j]));
                    }
                }

                // 세로줄 체크
                ArrayList<Integer> numVerArrayList = new ArrayList<>(Arrays.asList(numArr));
                for (int k = 0; k < 9; k++) {
                    if (numVerArrayList.contains(puzzle[k][i])) {
                        numVerArrayList.remove(numVerArrayList.indexOf(puzzle[k][i]));
                    }
                }

                if (!numHorArrayList.isEmpty() || !numVerArrayList.isEmpty()) {
                    ans = 0;
                }
            }

            for (int i = 0; i < 9; i+=3) {
                for (int j = 0; j < 9; j+=3) {
                    // 3x3 박스 체크
                    ArrayList<Integer> numBoxArrayList = new ArrayList(Arrays.asList(numArr));
                    for (int p = 0; p < 3; p++) {
                        for (int q = 0; q < 3; q++) {
                            if (numBoxArrayList.contains(puzzle[p+i][q+j])) {
                                numBoxArrayList.remove(numBoxArrayList.indexOf(puzzle[p+i][q+j]));
                            }
                        }
                    }
                    if (!numBoxArrayList.isEmpty()) {
                        ans = 0;
                    }
                }
            }
            System.out.println("#" + test_case + " " + ans);
        }

    }
}
