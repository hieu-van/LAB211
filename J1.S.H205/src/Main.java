import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Startup st1 = new Startup("Company 35", 20000);
		MinMaxAccount st1_MMA = new MinMaxAccount(st1);
		System.out.printf("Đã tạo MinMaxAccount cho %s với số dư là %d cent.\n", st1.getName(), st1_MMA.getBalance());

		do {
			System.out.println("\n1. Ghi có (debit)");
			System.out.println("2. Ghi nợ (credit)");
			System.out.println("3. Tra cứu số dư nhỏ nhất");
			System.out.println("4. Tra cứu số dư lớn nhất");
			System.out.println("5. Tra cứu số dư hiện tại");

			System.out.print("Nhập: ");
			Scanner sc = new Scanner(System.in);
			int ans = sc.nextInt(); sc.nextLine();

			switch (ans) {
				case 1:
					System.out.print("Nhập số tiền: ");
					int amount = sc.nextInt(); sc.nextLine();
					st1_MMA.debit(new Debit(amount));

					break;
				case 2:
					System.out.print("Nhập số tiền: ");
					amount = sc.nextInt(); sc.nextLine();
					st1_MMA.credit(new Credit(amount));

					break;
				case 3:
					System.out.println(st1_MMA.getMin());
					break;
				case 4:
					System.out.println(st1_MMA.getMax());
					break;
				case 5:
					System.out.println(st1_MMA.getBalance());
					break;
				default:
					System.exit(0);
			}
		} while (true);
	}
}