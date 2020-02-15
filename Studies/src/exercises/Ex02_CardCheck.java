package exercises;

import pool.Card;
import pool.Deck;

public class Ex02_CardCheck {
	public static void main(String[] args) {
		Deck d = new Deck(); // Create a deck of 52 cards
		Card c = d.pick(0); // Get the first card in the deck

		System.out.println(c); // == System.out.println(c.toString());
		
		d.shuffle(); // Shuffles the deck
		c = d.pick(); // Randomly gets one card from the deck
		System.out.println(c);
	}
}