package study;

/* ���۷��� ���� (== �������� == ���� == ���۷���)
 * 	>> �⺻���� ��(����, �Ǽ�, ���� ��)�� �ƴ� �������� �ּ�(��ġ��)�� �����ϴ� ����
 * 	>> ���۷��� ������ �����ϴ� �����ʹ� Heap memory ������ ����ȴ� (�ε��ȴ�)
 * 		<-> ���۷��� ���� �� ��ü�� CallStack memory ������ ����ȴ� 
 * 	>> �⺻�� �̿��� Ÿ�� : �迭 Ÿ��, Ŭ���� Ÿ��
 * 	>> �⺻��(�ʱⰪ)�� 'null'
 */

public class Ex03_Reference {
	public static void main(String[] args) {
		String str = new String("abc");
		String str2 = "abc";
		
		int[] array = new int[5];
		
		// str & array �ʱ�ȭ�ϱ�
		str = null;
		array = null;

	}

}
