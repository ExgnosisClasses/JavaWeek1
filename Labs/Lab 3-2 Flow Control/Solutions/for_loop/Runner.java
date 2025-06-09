
public class Runner {
	public static void main(String[] args) {
		int sum = 0;
		for (int i =1 ; i <= 20; i++ ) {
			if (0 != i % 2) continue;
			System.out.println(sum);
			if (sum > 30) break;
			sum += (i * i);
		}
		System.out.println(sum);
	}
}