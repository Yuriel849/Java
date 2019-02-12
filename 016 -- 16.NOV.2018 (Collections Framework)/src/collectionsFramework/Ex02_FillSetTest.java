package collectionsFramework;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Ex02_FillSetTest {
	public static void main(String[] args) {
		Set set = new HashSet();
		
		// ������ ������ set ä���
		for(int i = 0; set.size() < 10; i++) { // �ߺ��Ǵ� ���� �Է� �����ϱ⿡, ���� �ݺ� Ƚ���� 3���� ���� �� �ִ�.
			int r = (int)(Math.random()*100) + 1;
			set.add(r);
			System.out.println("r = " + r);
		}
		System.out.println(set);
		
		// set ������ �����ϱ�
		List list = new LinkedList(set); // LinkedList(Collection c) ������ ���
		Collections.sort(list); // �Ű������� list, set�� ����� �� ����.
		System.out.println(list);

	}

}
