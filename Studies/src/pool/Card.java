package pool;

public class Card {
	public static final int KIND_MAX = 4; // Card suits
	public static final int NUM_MAX = 13; // Card numbers
	
	static final int SPADE = 4;
	static final int DIAMOND = 4;
	static final int HEART = 4;
	static final int CLOVER = 4;
	
	public int kind;
	public int number;
	
	public Card() {
		this(SPADE, 1);
	}
	
	public Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
	public String toString() {
		String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
		String numbers = "A123456789JQK";
		
		return "kind : " + kinds[this.kind] + ", number : " + numbers.charAt(this.number);
	}
}