package exercises.byChapter.chapter_05;

// Ŀ�ǵ�������κ��� �Ž��� �� �ݾ��� �Է� �޾� ����Ѵ�.
// ������ ������ ������ �Ž������� ������ �� ������, "�Ž������� �����մϴ�."��� ����ϰ� �����Ѵ�.
// ������ ���� ����ϴٸ�, �Ž������� ������ ��ŭ ���� ������ ���� ���� ������ ������ ȭ�鿡 ����Ѵ�.

class Exercise05_07 {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("USAGE : java Exercise5_7 3120");
			System.exit(0);
		}
		
		// ���ڿ��� ���ڷ� ��ȯ�Ѵ�. (�Է��� ���� ���ڰ� �ƴ� ��� ���� �߻�)
		int money = Integer.parseInt(args[0]);
		
		System.out.println("money = " + money);
		
		int[] coinUnit = { 500, 100, 50, 10 }; // ������ ����
		int[] coin 	   = {   5,   5,  5,  5 }; // ������ ������ ����
		
		for(int i = 0; i < coinUnit.length; i++) {
			int coinNum = 0;
				// 1. �ݾ�(money)�� ���� ������ ������ �ʿ��� ������ ����(coinNum)�� ���Ѵ�.
			coinNum = money / coinUnit[i];
				// 2. coin���� coinNum ��ŭ�� ������ ���� (���� ������ ������� �ʴٸ� coin�� �ִ� ��ŭ�� ����.)
			if(coinNum > coin[i]) {
				coinNum = coin[i];
				coin[i] = 0;
			} else {
				coin[i] -= coinNum;
			}
				// 3. �ݾ׿��� ������ ����(coinNum)�� ���� ������ ���� ���� ����.
				money -= coinNum * coinUnit[i];
				System.out.println(coinUnit[i] + "�� : " + coinNum);
		}
		
		if(money > 0) {
			System.out.println("�Ž������� �����մϴ�.");
			System.exit(0); // ���α׷��� �����Ѵ�.
		}
		
		System.out.println(" = ���� ������ ���� = ");
		
		for(int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i] + "�� : " + coin[i]);
		}
	}
}