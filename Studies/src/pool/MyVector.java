package pool;

// Imitation of the already existing Vector class
public class MyVector {
	Object[] objArr;
	int size;
	int capacity;
	
	// Constructor where capacity can be designated
	public MyVector(int capacity) {
		if(capacity < 0) { System.exit(0); } // If capacity is smaller than 0, exit program
		this.capacity = capacity;
		objArr = new Object[capacity];
	}
	
	// Default constructor (default capacity = 16)
	public MyVector() {
		this(16);
	}

	// Return number of elements in array
	public int size() {
		return size; // size <= capacity
	}
	
	// Return size of array
	public int capacity() {
		return capacity;
	}
	
	// Check if array is empty
	public boolean isEmpty() {
		if(size == 0) { return true; }
		else { return false; }
	}
	
	// Add element to array (first ensure there is sufficient capacity (size < capacity))
	public void add(Object obj) {
		if(size >= capacity) { // i.e. if there is insufficient capacity in the array
			ensureCapacity(capacity*2); // Double capacity
			objArr[size++] = obj;
		}
		else { objArr[size++] = obj; }
	}
	
	// Create new larger array and copy the previous arrays elements into the new one
	public void ensureCapacity(int newSize) {
		if(newSize <= capacity) {
			System.out.println("잘못된 값을 입력했습니다.");
			System.exit(0);
		}
		Object[] obj = new Object[newSize];
		System.arraycopy(objArr, 0, obj, 0, size);
		objArr = obj;
		capacity = newSize;
	}
	
	// Return the element at the designated index
	public Object get(int index) {
		return objArr[index];
	}
	
	// Return the index of the provided object
	public int indexOf(Object obj3) {
		int index = 0;
		boolean flag = false;
		for(int i = 0; i < size; i++) {
			if(((Integer) obj3).intValue() == ((Integer) objArr[i]).intValue()) {
				flag = true;
				index = i;
			} } // for문 끝.
		if(flag == false) {
			System.out.println("지정된 객체가 존재하지 않습니다.");
			System.exit(0);
		}
		return index;
	}
	
	// Delete designated object
	public boolean remove(Object obj) {
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