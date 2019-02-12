package collectionsFramework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Ex07_SetToListTest {
	public static void main(String[] args) {
		List list = Arrays.asList(1,2,1,2,3,1,1);
		
		// list���� �ߺ� �� ���� --> ��κ��� �÷��� Ŭ�������� ��ȣ ��ȯ�� �����ϴ�		
		Set set = new HashSet(list); // HashSet(Collection c) ������ ���
		
		System.out.println(set);
		// [1, 2, 3] ���
	}
}
