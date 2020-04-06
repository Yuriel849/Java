package exercises.myVector;

// �̹� �����ϴ� Vector Ŭ������ ����ϴ� ������ Ŭ������ ������.
class Ex01_MyVector {
	Object[] objArr;
	int size;
	int capacity;
	
	// ����ڰ� capacity�� ������ �� �ִ� ������
	Ex01_MyVector(int capacity) {
		if(capacity < 0) { System.exit(0); } // 0���� ���� ���ڸ� ����ϸ� �����ϵ��� �Ѵ�.
		this.capacity = capacity;
		objArr = new Object[capacity];
	}
	
	// �⺻������ (default capacity = 16)
	Ex01_MyVector() {
		this(16);
	}

	// �迭�� ����� ��ü�� ������ ��ȯ
	int size() {
		return size;
	}
	
	// �迭�� ũ�⸦ ��ȯ
	int capacity() {
		return capacity;
	}
	
	// �迭�� ������� Ȯ��
	boolean isEmpty() {
		if(size == 0) { return true; }
		else { return false; }
	}
	
	// �迭�� �߰�
	void add(Object obj) { // ������ ������ �ִ����� Ȯ���ؾ�!
		if(size >= capacity) { // i.e. ���� ��ü�迭�� �� �ڸ��� ���� ��
			ensureCapacity(capacity*2); // �迭�� �ø���
			objArr[size++] = obj;
		}
		else { objArr[size++] = obj; } // �迭�� ��ü �߰� �� size �� 1 ����
	}
	
	// �� Ŀ�� �� �迭�� �����ϰ� ���� �迭�� ������ ���� �ٿ��ִ´�
	void ensureCapacity(int newSize) {
		if(newSize <= capacity) {
			System.out.println("�߸��� ���� �Է��߽��ϴ�.");
			System.exit(0);
		}
		Object[] obj = new Object[newSize];
		System.arraycopy(objArr, 0, obj, 0, size);
		objArr = obj;
		capacity = newSize;
	}
	
	// ������ ��ġ(index)�� �ִ� ���� ��ȯ
	Object get(int index) {
		return objArr[index];
	}
	
	// ������ ��ü�� ��ġ(index)�� ��ȯ
	int indexOf(Object obj3) {
		int index = 0;
		boolean flag = false;
		for(int i = 0; i < size; i++) {
			if(obj3 instanceof Integer && objArr[i] instanceof Integer) {
				if(((Integer) obj3).intValue() == (Integer) objArr[i]) {
					/* wrapperŬ������ �⺻���� ���ϸ� wrapper�� �⺻������ unboxing�Ͽ� ���Ѵ�
					 * 	>> intValue ������ obj3�� int <--> objArr[i]�� Integer ��ü
					 * 	>> ���ϸ� objArr[i]�� int�� unboxing �� �� ��
					 */
					flag = true;
					index = i;
				} } } // for�� ��.
		if(flag == false) {
			System.out.println("������ ��ü�� �������� �ʽ��ϴ�.");
			System.exit(0);
		}
		return index;
	}
	
	// ������ ��ü�� ����
	boolean remove(Object obj) {
		int index = indexOf(obj);
		System.arraycopy(objArr, index+1, objArr, index, size-1-index);
		objArr[size-1] = null;
		size--;
		return true;
	}
	
	public String toString() {
		String str = "[";
		for(int i = 0; i < size; i++) {
			if(i > 0) { str += ","; }
			str += objArr[i];
		}
		str += "]";
		return str;
	}
}
