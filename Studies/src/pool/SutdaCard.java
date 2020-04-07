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

	public String toString() {
		return NUM + ( IS_KWANG ? "K" : "");
	}
}