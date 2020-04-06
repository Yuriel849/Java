package exercises.byChapter.chapter_08;

// UnsupportedFunctionException ����Ŭ������ �ۼ��϶�.

class Exercise08_09 {
	public static void main(String[] args) {
		try {
			throw new UnsupportedFunctionException("�������� �ʴ� ����Դϴ�.", 100);
		} catch(UnsupportedFunctionException e) {
			e.printStackTrace();
		}
	} // main() ��.
} // Ŭ���� ��.

class UnsupportedFunctionException extends RuntimeException {
	final private int ERR_CODE;
	
	UnsupportedFunctionException(String str, int num) {
		super(str); // parent�� �ν��Ͻ����� msg�� ��� --> parent�� �����ڷ� �ʱ�ȭ
		ERR_CODE = num;
	}
	
	UnsupportedFunctionException(String str) {
		this(str,100);
	}
	
	public int getErrorCode() { // ���� �ڵ带 �� �� �ְ� �߰�.
		return ERR_CODE;
	}
	
	public String getMessage() {
		return "[" + getErrorCode() + "]" + super.getMessage();
	}
}
