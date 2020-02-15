package pool;

public class Deck {
	final int CARD_NUM = 52; // Number of cards
	Card cardArr[] = new Card[CARD_NUM]; // Card객체 배열을 포함 --> 포함 관계!!!
	
	public Deck () {
		int i = 0;
		
		for (int k = Card.KIND_MAX; k > 0; k--) { // KIND_MAX = 4
			for(int n = 0; n < Card.NUM_MAX; n++) { // NUM_MAX = 13
				cardArr[i++] = new Card(k, n+1);
			}
		}
	}
	
	public Card pick(int index) { // Returns one card at the designated position(index)
		return cardArr[index];
	}
	
	public Card pick() { // Randomly returns one card from the deck
		int index = (int)(Math.random() * CARD_NUM);
		return pick(index);
	}
	
	public void shuffle() { // Shuffles the deck
		for(int i = 0; i < cardArr.length; i++) {
			int r = (int)(Math.random() * CARD_NUM);
			
			Card temp = cardArr[i];
			cardArr[i] = cardArr[r];
			cardArr[r] = temp;
		}
	}
}