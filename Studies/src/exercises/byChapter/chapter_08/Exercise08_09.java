package exercises.byChapter.chapter_08;

// UnsupportedFunctionException

class Exercise08_09 {
	public static void main(String[] args) {
		try {
			throw new UnsupportedFunctionException("ERROR - You should not do this.", 100);
		} catch(UnsupportedFunctionException e) {
			e.printStackTrace();
		}
	}
}

@SuppressWarnings("serial")
class UnsupportedFunctionException extends RuntimeException {
	final private int ERR_CODE;
	
	UnsupportedFunctionException(String str, int num) {
		super(str); // Error message is saved using the RuntimeException constructor
		ERR_CODE = num;
	}
	
	UnsupportedFunctionException(String str) {
		this(str,100);
	}
	
	public int getErrorCode() {
		return ERR_CODE;
	}
	
	public String getMessage() {
		return "[" + getErrorCode() + "]" + super.getMessage();
	}
}