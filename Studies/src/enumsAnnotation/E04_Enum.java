package enumsAnnotation;

class E04_Enum {
	public static void main(String args[]) {
		Deck d = new Deck(); // ī�� �� ��(Deck)�� �����.
		Card c = d.pick(0); // ���� ���� ���� ���� ī�带 �̴´�.
		System.out.println(c); // System.out.println(c.toString());�� ����.
		d.shuffle(); // ī�带 ���´�.
		c = d.pick(0); // ���� �Ŀ� ���� ���� ī�带 �̴´�.
		System.out.println(c);
		
		// Deck�� ��� Card�� ����Ѵ� (�ڵ带 ����� �ۼ��ߴ��� Ȯ�ο�)
//		for(Card card : d.cardArr) {
//			System.out.println(card);
//		}
	} // main() ��.
} // Ŭ���� ��.

// Deck Ŭ����
class Deck {
	final int CARD_NUM = Card.Kind.values().length * Card.Number.values().length; // ī���� ����
	Card cardArr[] = new Card[CARD_NUM]; // Card��ü �迭�� ����

	Deck() {
		Card.Kind[] kArr = Card.Kind.values();
		Card.Number[] nArr = Card.Number.values();
		
		int i = 0;
		for(Card.Kind k : kArr) {
			for(Card.Number n : nArr) {
				Card tmpCard = new Card(k, n);
				cardArr[i++] = tmpCard;
			}
		}
	}

	Card pick(int index) { // ������ ��ġ(index)�� �ִ� ī�� �ϳ��� ������ ��ȯ
		return cardArr[index];
	}

	Card pick() { // Deck���� ī�� �ϳ��� �����Ѵ�.
		int index = (int) (Math.random() * CARD_NUM);
		return pick(index);
	}

	void shuffle() { // ī���� ������ ���´�.
		for (int i = 0; i < cardArr.length; i++) {
			int r = (int) (Math.random() * CARD_NUM);
			Card temp = cardArr[i];
			cardArr[i] = cardArr[r];
			cardArr[r] = temp;
		}
	}
} // DeckŬ������ ��

// CardŬ����
class Card {
	enum Kind {
		CLOVER, HEART, DIAMOND, SPADE
	}

	enum Number {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	Kind kind;
	Number num;

	Card() {
		this(Kind.SPADE, Number.ACE);
	}

	Card(Kind kind, Number num) {
		this.kind = kind;
		this.num = num;
	}

	public String toString() {
		return "[" + kind.name() + "," + num.name() + "]";
	} // toString()�� ��
} // CardŬ������ ��