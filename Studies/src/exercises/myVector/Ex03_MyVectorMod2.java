package exercises.myVector;

// �̹� �����ϴ� Vector Ŭ������ ����ϴ� ������ Ŭ������ ������.
class Ex03_MyVectorMod2 {
	Object[] objArr;
	int size;
	
	// ����ڰ� capacity�� ������ �� �ִ� ������
	Ex03_MyVectorMod2(int capacity) {
		if(capacity < 0) { System.exit(0); } // 0���� ���� ���ڸ� ����ϸ� �����ϵ��� �Ѵ�.
		objArr = new Object[capacity];
	}
	
	// �⺻������ (default capacity = 16)
	Ex03_MyVectorMod2() {
		this(16);
	}

	// �迭�� ����� ��ü�� ������ ��ȯ
	int size() {
		return size;
	} // size() ��.
	
	// �迭�� ũ�⸦ ��ȯ
	int capacity() {
		return objArr.length;
	} // capacity() ��.
	
	// �迭�� ������� Ȯ��
	boolean isEmpty() {
		return size == 0; // �迭�� ����� -> size�� 0�̴� --> true ��ȯ <--> size�� 0�� �ƴϸ� false ��ȯ
	} // isEmpty() ��.
	
	// �迭�� �߰�
	void add(Object obj) { // ������ ������ �ִ����� Ȯ���ؾ�!
		if(size >= capacity()) { // i.e. ���� ��ü�迭�� �� �ڸ��� ���� ��
			ensureCapacity(capacity()*2); // �迭�� �ø���
			objArr[size++] = obj;
		}
		else { objArr[size++] = obj; } // �迭�� ��ü �߰� �� size �� 1 ����
	} // add() ��.
	
	// �� Ŀ�� �� �迭�� �����ϰ� ���� �迭�� ������ ���� �ٿ��ִ´�
	void ensureCapacity(int newSize) {
		// ensureCapacity ȣ���ϸ鼭 �ѱ� ���ڰ��� ũ�⸦ üũ
		if(newSize <= capacity()) {
			System.out.println("�߸��� ���� �Է��߽��ϴ�.");
			System.exit(0);
		}
		Object[] tmp = new Object[newSize];
		System.arraycopy(objArr, 0, tmp, 0, size);
		objArr = tmp;
	} // ensureCapacity() ��.
	
	// ������ ��ġ(index)�� �ִ� ���� ��ȯ
	Object get(int index) {
		return objArr[index];
	} // get() ��.
	
	// ������ ��ü�� ��ġ(index)�� ��ȯ
	int indexOf(Object obj3) {
		int index = 0;
		for(int i = 0; i < size; i++) {
			if(obj3 == null) { break; } 
			else if (obj3.equals(objArr[i])) {
		/* equals() ȣ���ϸ� Object�� ���� equals()�� �ƴ϶� 
		 * 	>> ��ü�� ���� �ν��Ͻ��� equals()�� ȣ��ȴ�
		 * 		>> ������!!! >> ���������� Ÿ�԰� ��� ���� �׻� ���� �ν��Ͻ��� �޼��尡 ȣ��ȴ�!
		 * 	>> ex) obj3�� StringŸ���̸� String�� �������̵��� equals() ȣ��
		 * 
		 * ��ü�� ���� �ν��Ͻ����� �������̵��ߴ��� ���ߴ����� ��� �ƴ°�?
		 * 	>> �ش� Ŭ�������� �˾Ƽ� å������ ��, �װͱ��� ���� ���� �ʿ�� ����
		 */
				return i;
			} } // for�� ��.
		System.out.println("������ ��ü�� ã�� ���߽��ϴ�. (indexOf)");
		return -1;
	} // indexOf() ��.

			// �Ʒ� �ڵ��� �������� ��ü�� �ݵ�� String Ÿ���̾�� �Ѵٴ� ��!!!
//			if(obj3 instanceof String && objArr[i] instanceof String) {	
//				if(((String) obj3).equals((String) objArr[i])) {
		/* obj3 & objArr�� �� ĭ�� ��ü��
		 * 	>> ObjectŸ�� ���������� �����ϴ� String ��ü(���ڿ�)�̱⿡
		 * 	>> StringŬ�������� �������̵��� equals()�� ��
		 */
	
			// �Ʒ� �ڵ��� �������� ��ü�� �ݵ�� Integer Ÿ���̾�� �Ѵٴ� ��!!!
//			if(obj3 instanceof Integer && objArr[i] instanceof Integer) {
//				if(((Integer) obj3).intValue() == (Integer) objArr[i]) {
		/* wrapperŬ������ �⺻���� ���ϸ� wrapper�� �⺻������ unboxing�Ͽ� ���Ѵ�
		 * 	>> intValue ������ obj3�� int <--> objArr[i]�� Integer ��ü
		 * 	>> ���ϸ� objArr[i]�� int�� unboxing �� �� ��
		 */
	
	// ������ ��ü�� ����
	boolean remove(Object obj) {
		int index = indexOf(obj); // ��ü�� ��ġ(index) Ȯ��
		if(index == -1) {
			System.out.println("������ ��ü�� �������� �ʽ��ϴ�. (remove)");
			return false;
		} else {
			System.arraycopy(objArr, index+1, objArr, index, size-1-index);
			objArr[size-1] = null;
			size--;
			System.out.println("������ ��ü(" + obj + ")�� �����߽��ϴ�.");
			return true;
		}
	} // remove() ��.
	
	// Object�κ��� ��ӹ��� toString() �������̵�
	public String toString() {
		String str = "[";
		for(int i = 0; i < size; i++) {
			if(i > 0) { str += ","; }
			str += objArr[i];
		}
		return str + "]";
	} // toString() ��.
} // Ŭ���� ��.
