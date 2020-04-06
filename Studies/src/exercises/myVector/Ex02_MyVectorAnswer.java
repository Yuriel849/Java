package exercises.myVector;

class Ex02_MyVectorAnswer {
	Object[] objArr; // null�� �ڵ��ʱ�ȭ
		// capacity�� �󸶷� ���� �𸣴µ� �����ʱ�ȭ���� ���Ѵ� --> �����ڿ��� �ʱ�ȭ�ؾ�
	int size;
	
	// ������ : �־��� ���� ũ��� iv �ʱ�ȭ 
	Ex02_MyVectorAnswer(int capacity) {
			// capacity�� �迭�� ũ��
		if(capacity < 0) {
			throw new IllegalArgumentException("�߸��� ���� �Է��߽��ϴ� --> " + capacity);
		}
		objArr = new Object[capacity];
	}
	
	// �⺻������ : ����ڰ� capacity�� �������� �ʴ´ٸ�
	Ex02_MyVectorAnswer() {
		this(16); // == MyVectorAnswer(16);
//		objArr = new Object[16];
	}
	
	// MyVectorAnswer�� capacity(== �뷮 == �迭�� ����) ��ȯ
	int capacity() {
		return objArr.length;
	}
	
	// MyVectorAnswer�� size ��ȯ
	int size() {
		return size;
	}
	
	// MyVectorAnswer�� ����� �� true, �ƴϸ� false
	// "�迭�� �����" == �迭�� ����� ��ü�� �ϳ��� ����
	boolean isEmpty() {
//		if(size == 0) { return true; }
//		return false;
		return size == 0;
	}
	
	// ������ index�� ����� ��ü�� ��ȯ
	Object get(int index) {
		if(index < 0) { // �׻� ��ȿ�� �˻縦 �ؾ��Ѵ�!!
			throw new IllegalArgumentException("�ε����� ������ �Ѿ����ϴ� --> " + index);
		}
		return objArr[index];
	}
	// �־��� ��ü(obj)�� �迭�� ����
	void add(Object obj) {
		// ������ ������ �����ִ��� Ȯ���ϱ�
		// A. ������ ������, ���� Ȯ�� �� ���� (ū �迭 ����, ���� ���� ����, �������� ����)
		if(capacity() == size) {
				// 1. ū �迭 ���� (���� �뷮�� 2��)
			Object[] tmp = new Object[objArr.length * 2];
				// 2. �⺻ ���� ���� (objArr[0] ~ objArr[size])
			for(int i = 0; i < size; i++) {
				tmp[i] = objArr[i]; }
				// 3. ������ ���� (���������� ���� �迭���� �� �迭�� �̵�)
			objArr = tmp; }
		// B. ������ ������ obj�� objArr�� ����
		objArr[size++] = obj;
	}
	
	public String toString() {
		String tmp = "[";
		for(int i = 0; i < size; i++) {
			tmp += objArr[i] + ","; }
		return tmp + "]";
	}
	
	// ������ ��ü(obj)�� ��ġ(�迭�� index)�� ��ȯ --> �� ã���� -1 ��ȯ
	int indexOf(Object obj) {
		// objArr���� obj�� ã�´�
		for(int i = 0; i < size; i++) {
			if(objArr[i].equals(obj)) {
				// obj�� ã�� ��ġ(�迭�� index)�� ��ȯ
				return i;
			} }
		return -1;
	}
	
	// objArr���� ������ ��ü(obj)�� �����ϴ� �޼���
	boolean remove(Object obj) {
		// objArr���� obj�� ����ִ��� ��ġ ã��
		int idx = indexOf(obj);		
		// objArr���� obj�� �� ã���� (idx == -1) ���� ����
		if(idx == -1) { return false; }
		// obj ã���� ����
			// (1) �����Ϸ��� ��� ������ ��Ҹ� ��ĭ�� ���� �̵�
		System.arraycopy(objArr, idx+1, objArr, idx, size-1-idx);
				// objArr[idx+1]���� objArr[idx]�� size-idx-1�� ��Ҹ� ����
			// (2) ������ ��Ҹ� null��
		objArr[size-1] = null;
			// (3) size--; 
		size--;
		return true;
	}
	
	// ��ü �迭�� ��� ��ü���� ���� (��� ��Ҹ� null�� �����ϰ� size = 0)
	void clear() {
		for(int i = 0; i < size; i++) {
			objArr[i] = null;
		}
		size = 0;
	}
}