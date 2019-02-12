package generics;

import java.util.List;
import java.util.Optional;

class Ex03_GenericsTest {
	public static void main(String[] args) {
		// 1.
		Optional<Object> op = new Optional<String>(); // ����! --> ���� ���׸�Ÿ���� Object & String���� ����ġ!
		
		// 2.
		Optional<?> op2 = new Optional<String>(); // ����!
			// "?" == "? extends Object" --> Object�� child Ÿ�� ��� ��� ���� --> ���� ���� �� � Ÿ���̿��� ��� ���� 
		// 3.
		Optional<String> op3 = new Optional<String>(); // ����!
			// �׷��� �������� ������ Optional Ŭ������ �����ڰ� private�̱� ����
		
		// 4.
		Optional<? extends List> op4 = new Optional<Integer>(); // List Ŭ������ child Ŭ�����̱⸸ �ϸ� � Ÿ���̿��� ��� ����
		// 5.
		Optional<? super List> op5 = new Optional<Integer>(); // List Ŭ������ parent Ŭ������ Ÿ�Ը� ��� ����
		
		// 6.
		Optional op6 = new Optional();
			// "?" ���� ���׸� �ƿ� �� ����? --> ���׸����� ������ �����ϴ� �� --> ��ġ�ʴ� �ٸ� Ÿ���� �ԷµǴ� ���� ���� & �Ź� Ÿ��üũ�� ����ȯ�� �ؾ� �Ѵ�.
	}
}
