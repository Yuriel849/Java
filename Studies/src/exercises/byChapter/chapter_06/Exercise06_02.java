package exercises.byChapter.chapter_06;

// SutdaCard Ŭ������ �ۼ��϶�.

public class Exercise06_02 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		System.out.println("Original deck in order >>");
		for(int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ", ");
		}
		
		System.out.println("\n1st element >> " + deck.pick(0));
		System.out.println("Random element >> " + deck.pick());
		deck.shuffle();
		
		System.out.println("\nShuffled deck >>");
		for(int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ", ");
		}
		System.out.println("\n1st element >> " + deck.pick(0));
	}
}

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		// �迭 SutdaCard�� ������ �ʱ�ȭ �Ͻÿ�.
		for(int i = 0; i < CARD_NUM; i++) {
			if(i < 10) {
				if(i == 0 || i == 2 || i == 7) {
					cards[i] = new SutdaCard(i+1, true);
				} else { cards[i] = new SutdaCard(i+1, false); }
			} else { cards[i] = new SutdaCard(i-9, false); }
			
			/* int num = i % 10 + 1;
			 * boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);
			 * cards[i] = new SutdaCard(num, isKwang);
			 */
		}
	}
	
	// �迭 cards�� ��� ī���� ��ġ�� �ڼ��´�. (Math.random() ���)
	void shuffle() {
		SutdaCard temp;
		for(int i = 0; i < 100; i++) {
			int ra = (int)(Math.random() * 19 + 1);
			// cards[0] & cards[ra]�� ���� ���� �ٲ۴�.
			temp = cards[0];
			cards[0] = cards[ra];
			cards[ra] = temp;
		}
	}
	
	// �迭 cards���� ������ ��ġ�� SutdaCard�� ��ȯ�Ѵ�.
	SutdaCard pick(int index) {
		// ��ȿ��üũ
		if(index < 0 || index >= CARD_NUM) { return null; }
		return cards[index];
	}
	
	// �迭 cards���� ������ ��ġ�� SutdaCard�� ��ȯ�Ѵ�. (Math.random() ���)
	SutdaCard pick() {
		int r = (int)(Math.random() * 20);
		return cards[r]; // pick(int index)�� ȣ���Ѵ�.
	}
} // SutdaDeck ����

class SutdaCard {
	final int NUM; // SutdaCard Ŭ���� �ܺο��� ī���� ���ڿ� ���Ḧ ������ �� ���� ����.
	final boolean IS_KWANG;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.NUM = num;
		this.IS_KWANG = isKwang;
	}
	
	// info() ��� Object Ŭ������ toString()�� �������̵��ߴ�.
	public String toString() {
		return NUM + ( IS_KWANG ? "K" : "");
	}
}