package exercises.byChapter.chapter_05;

// �Ž������� �� ���� �������� ������ �� �ִ����� ����϶�.
// ���� money�� �ݾ��� �������� �ٲپ��� �� ���� �� ���� ������ �ʿ����� ����ؼ� ����϶�.
// ��, ������ ���� ���� �������� �Ž��� �־���Ѵ�.

class Exercise05_06 {
	public static void main(String[] args) {
		// ū �ݾ��� ������ �켱������ �Ž��� ����Ѵ�.
		int[] coinUnit = { 500, 100, 50, 10 };
		
		int money = 2680;
		System.out.println("money = " + money);

		for(int i = 0; i < coinUnit.length; i++) {
			int num = money / coinUnit[i];
			System.out.println(coinUnit[i] + "�� : " + num);
			money %= coinUnit[i];
		}
	}
}