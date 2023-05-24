package baekJoon;

// L : 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
// D : 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
// B : 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
// P $ : $라는 문자를 커서 왼쪽에 추가함

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 문자열 입력받기
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // M(입력할 명령어의 개수) 입력받기
        int M = Integer.parseInt(br.readLine());

        Stack<Character> temp = new Stack<>();
        // M만큼 for문 돌며 명령 수행
        for (int i = 0; i < M; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine());

             switch(st.nextToken()) {
                 case "L":
                     if (stack.size() > 0) {
                         temp.push(stack.pop());
                     }
                     break;

                 case "D" :
                     if (temp.size() > 0) {
                         stack.push(temp.pop());
                     }
                     break;

                 case "B" :
                     if (stack.size() > 0) {
                         stack.pop();
                     }
                     break;

                 case "P" :
                     stack.push(st.nextToken().charAt(0));
                     break;
             }
        }
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!temp.isEmpty()) {
            sb.append(temp.pop());
        }
        System.out.println(sb.toString());
    }
}
