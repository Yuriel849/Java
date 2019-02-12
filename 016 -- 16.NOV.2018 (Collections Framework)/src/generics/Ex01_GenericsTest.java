package generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class Ex01_GenericsTest {
	public static void main(String[] args) {
		/* ArrayList�� ���ο��� Object �迭�� ����ϱ� ��� Ÿ���� ��ü�� ������ �� �ִ�.
		 * ������ �Ϲ������� ���� Ÿ���� ��ü�鸸 ����Ѵ�. Generics�� �ƿ� ������ Ÿ���� ��ü�鸸 ���� �� �ְ� �����Ѵ�.
		 * 
		 * Generics�� ���� - 01 -->> ���� Ÿ�� �̿��� Ÿ���� ���� ���� �����ش�.
		 */
		ArrayList<String> list = new ArrayList<String>(); //--> i.e. list�� StringŸ�� ��ü�� ���� �ž�!
		list.add("String");
		
		/* Generics�� ���� - 02 -->> ���ʿ��� Ÿ��üũ(instanceof) & ����ȯ�� �����Ѵ�.
		 */
		HashSet<String> set = new HashSet<String>();
		set.add("abc"); // boolean add(Object o) --> ������ �μ��� �����ϴ� ���� �� �־�� �Ѵ�. --> ������ �μ��� �����ϴ� ObjectŸ������ �޴´�.
		set.add("ABC");
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
//			String str = (String)it.next(); // next() ����Ÿ���� Object --> ����ȯ �ʿ� --> Generics �� ���� �� 
			String str = it.next();
		}
	} // main() ��.
} // Ŭ���� ��.