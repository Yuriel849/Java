package study;

import java.util.ArrayList;
import java.util.Collections;

public class Ex03_Sorting {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		for(int i = 10; i >= 0; i--) {
			list.add(new Integer(i));
		}
		System.out.println(list);
		
		Collections.sort(list); // ������ �ȴ� --> �׷��� ���� ������ ������ �� ��µ�??
						// ��� Collections.sort()���� �Ű������� 2�� --> �ι�° �Ű������� ����ڰ� ������ �� �ִ� ���ı��ؿ� �Ű�����
						// ���⼭�� ��ü�� Integer�� "��������" ���ı��� �⺻���� ������ �ְ�, �� �⺻���� Collections.sort()���� �����Ѵ�
		System.out.println(list);

	}

}
