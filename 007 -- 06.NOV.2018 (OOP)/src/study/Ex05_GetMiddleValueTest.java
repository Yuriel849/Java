package study;

// File -> New -> JUnit Test Case -> (path �߰��� �ʿ��ϴٰ� �� ��� add) -> Finish
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Ex05_GetMiddleValueTest {
	/* 3���� ���� �Է� �޾Ƽ� �߰����� ��ȯ�ϴ� �޼��� �ۼ�
	 * �޼��� �̸� : mid
	 * �Է� : ������ 3��
	 * ���: ������ 1�� (�߰���)
	 */
	
	int mid(int x, int y, int z) {
		/* x, y, z �߿��� �߰� ũ���� ���� ��ȯ�Ѵ�.
		 * 	ex) 1, 1, 2�� ��� 1�� ��ȯ�Ǿ�� �Ѵ�.
		 * 		1, 2, 2�� ��� 2�� ��ȯ�Ǿ�� �Ѵ�.
		 */
		int mid = x;
		
//		// ��� 01 >>
//		{
//		if(x < y) {
//			if(y < z) { mid = y; }
//			else {
//				if(x < z) { mid = z; }
//				else { mid = x;	}
//			}
//		} else { // x > y
//			if(x < z) { mid = x; }
//			else {
//				if(y < z) { mid = z; }
//				else { mid = y; }
//			}
//		}
//		}
//		
//		// ��� 02 >>
//		{
//		int[] str = new int[3];
//		str[0] = x;
//		str[1] = y;
//		str[2] = z;
//		int temp;
//		
//		for(int i = 0; i < str.length-1; i++) {
//			for(int k = 0; k < str.length-1-i; k++) {
//				if(str[k] < str[k+1]) {
//					temp = str[k];
//					str[k] = str[k+1];
//					str[k+1] = temp;
//				}
//			}
//		}
//		mid = str[1];
//		}
//		
//		// ��� 03 >>
//		{
//		mid = (x < y) ? (y < z) ? y : (x < z) ? z : x : (x < z) ? x : (y < z) ? z : y;
//			/* ���׿����� �ߺ��Ͽ� ���� ����� ������ �Ǵµ�... ������ ������٤���
//			 * 	>> ��ȣ �־ ������ ���
//			 * 	>> mid = (x < y) ? ((y < z) ? y : ((x < z) ? z : x)) : ((x < z) ? x : ((y < z) ? z : y));
//			 */
//		}

		// �������� ��� -> 1. ��, 2. ����, 3. �񱳿�����, etc.
		
		// ��� 04 >> ����� �� >> ���� ������ ��
		{
		if((x < y && y < z) || (z < y && y < x)) return y;
		if((y < x && x < z) || (z < x && x < y)) return x;
		return z;
		}
		// �Ϻ����� �ʴ�... mid(3,3,2) == 3 --> ����
		
		//return mid;
	}
	
	// ���� text�� �� ���⼭ �̷��� �����Ѵ� --> @Test �ݵ�� �ʿ�! �� �޼����� �̸��� �ٸ���!
	@Test
	void test() {
		assertTrue(mid(1,2,3) == 2);
	}
	
	@Test
	void test2() {
		assertTrue(mid(2,1,3) == 2);
	}
	
	@Test
	void test3() {
		assertTrue(mid(3,1,2) == 2);
	}
	
	@Test
	void test4() {
		assertTrue(mid(1,2,2) == 2);
	}
	
	@Test
	void test5() {
		assertTrue(mid(1,1,1) == 1);
	}
	
	@Test
	void test6() {
		assertTrue(mid(3,2,1) == 2);
	}
	
	@Test
	void test7() {
		assertTrue(mid(3,1,2) == 2);
	}
	
	@Test
	void test8() {
		assertTrue(mid(3,3,2) == 3);
	}

	@Test
	void test9() {
		assertTrue(mid(3,3,3) == 3);
	}
}
