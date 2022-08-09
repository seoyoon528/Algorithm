import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test2493 {

// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int N = Integer.parseInt(br.readLine());

// 		StringTokenizer st = new StringTokenizer(br.readLine());
// 		Stack<int[]> stack = new Stack<int[]>();
		
// 		for (int i = 1; i <= N; i++) {
// 			 int high = Integer.parseInt(st.nextToken());
			
// 			while(!stack.isEmpty()) {
// 				if (high >= stack.peek()[1]) {
// 					stack.pop();
// 				}
// 				else {
// 					System.out.print(stack.peek()[0]+ " ");
// 					break;
// 				}
// 			}
// 			if (stack.isEmpty()) System.out.print("0 ");
			
// 			stack.push(new int[] {i, high});
// 		}
// 	}
	
	/*교수님 ver*/
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Tower> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int h = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek().height < h) {	// 내가 스택에 들어가기 전에 나보다 높은 애가 없어야 함 (= 나보다 낮은 애 다 빼기)
				stack.pop();
			}
			
			if (stack.isEmpty()) {
				sb.append("0 ");
			} else {
				sb.append(stack.peek().num + " ");
			}
			
			stack.push(new Tower(h, i));
		}
		System.out.println(sb.toString());
	}
	
	static class Tower {
		int height, num;
		Tower(int h, int n) {
			height = h;
			num = n;
		}
	}
}
