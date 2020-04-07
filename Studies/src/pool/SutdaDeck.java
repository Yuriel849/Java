package pool;

public class SutdaDeck {
	private final int CARD_NUM = 20;
	private SutdaCard[] cards = new SutdaCard[CARD_NUM];

	public SutdaDeck() {
		for(int i = 0; i < CARD_NUM; i++) {
			if(i < 10) {
				if(i == 0 || i == 2 || i == 7) {
					cards[i] = new SutdaCard(i+1, true);
				} else {
					cards[i] = new SutdaCard(i+1, false);
				}
			} else {
				cards[i] = new SutdaCard(i-9, false);
			}
		}
	}
	
	public void shuffle() {
		SutdaCard temp;
		for(int i = 0; i < 100; i++) {
			int randomInt = (int)(Math.random() * 19 + 1); // Math.random returns a double between 1 and 19
			temp = cards[0];
			cards[0] = cards[randomInt];
			cards[randomInt] = temp;
		}
	}
	
	public SutdaCard pick(int index) {
		if(index < 0 || index >= CARD_NUM) { return null; }
		return cards[index];
	}
	
	public SutdaCard pick() { // Pick a card at random
		int r = (int)(Math.random() * 20); // Math.random returns a double between 0 and 19
		return pick(r);
	}
	
	public int getDeckLength() {
		return cards.length;
	}
}