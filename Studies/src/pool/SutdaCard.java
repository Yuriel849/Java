package pool;

class SutdaCard {
	private final int NUM;
	private final boolean IS_KWANG;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.NUM = num;
		this.IS_KWANG = isKwang;
	}

	// equals() overridden to check if the SutdaCard instances have the same states
	public boolean equals(Object obj) {
		if(obj instanceof SutdaCard) {
			SutdaCard sutdaC = (SutdaCard) obj;
			return (this.IS_KWANG == sutdaC.IS_KWANG && this.NUM == sutdaC.NUM);
		}
		return false;
	}
	
	public String toString() {
		return NUM + ( IS_KWANG ? "K" : "");
	}
}