package study;

class Return {
	int max(int a, int b) {
		if(a>b) {
			return a;
		} // �� ����? if�� �� int�� a�� ��ȯ�ϴµ�? --> if�� ���� �� �� ����?? --> �׷��� int���� ��ȯ���� �ʱ⿡ ����!
		else {
			return b;
		}
	}
}

public class Ex07_Return {
	public static void main(String[] args) {
		Return ret = new Return();
		ret.max(4, 5); // ȣ���� �� ��ȯ���� ���� �ʴ� ���� �������� �ʴ´�
					   // ������ �� ��ȯ���� �־�� �ϴµ� ���� ���� �����ȴ�
	}
}
