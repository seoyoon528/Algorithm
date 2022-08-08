import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<int[]>();
		
		for (int i = 1; i <= N; i++) {
			 int high = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if (high >= stack.peek()[1]) {
					stack.pop();
				}
				else {
					System.out.print(stack.peek()[0]+ " ");
					break;
				}
			}
			if (stack.isEmpty()) System.out.print("0 ");
			
			stack.push(new int[] {i, high});
		}
	}
}
