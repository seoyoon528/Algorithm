package baekJoon;

public class Test4673 {

	public static int d(int n) {
		int d_num = n;
		
		while(n > 0) {
			d_num += n % 10;
			n = n / 10;
		}
		return d_num;
	}
	
	public static void main(String[] args) {
		boolean[] arr = new boolean[10000];
		
		for (int i = 1; i <= 10000; i++) {
			int index = d(i);
			
			if (index <= 10000) {
				arr[index] = true;
			}
		}
		
		for (int i = 1; i <= 10000; i++) {
			if (arr[i] != true) {
				System.out.println(i);
			}
		}
	}

}
