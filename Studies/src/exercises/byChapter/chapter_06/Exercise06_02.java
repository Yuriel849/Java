package exercises.byChapter.chapter_06;

import pool.SutdaDeck;

public class Exercise06_02 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		System.out.println("Original deck in order >>");
		for(int i = 0; i < deck.getDeckLength(); i++) {
			System.out.print(deck.pick(i) + ", ");
		}
		
		System.out.println("\n1st element >> " + deck.pick(0));
		System.out.println("Random element >> " + deck.pick());
		deck.shuffle();
		
		System.out.println("\nShuffled deck >>");
		for(int i = 0; i < deck.getDeckLength(); i++) {
			System.out.print(deck.pick(i) + ", ");
		}
		System.out.println("\n1st element >> " + deck.pick(0));
	}
}