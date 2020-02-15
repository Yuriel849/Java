package exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pool.Card;

class Ex02_CardCheckTest {
	String rankCheck(Card[] cArr) {
		Card[] input = cArr;
		Card temp;
		
		int cntS = 0; // Check for "STRAIGHT"
		int cntF = 0; // Check for "FLUSH"
		int cnt = 0; // Check for "1 PAIR", "2 PAIR", "THREE CARD", "FOUR CARD"
		
		// Order cards (input array) in ascending order
		for(int i = 0; i < input.length - 1; i++) {
			for(int j = 0; j < input.length - (i + 1); j++) {
				if(input[j].number > input[j+1].number) {
					temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
				} } }
		
		// Confirm successful ordering
//		for(int i = 0; i < input.length; i++) {
//			System.out.print(input[i] + " ");
//		}
//		System.out.println();
		
		// Check cards
		for(int i = 1; i < input.length; i++) {
			if (input[i].kind == input[i-1].kind) { cntF++; }
			if (input[i].number == input[i-1].number + 1) { cntS++; }
			
			if (cntF == 4 && cntF == cntS) { System.out.println("sf");return "STRAIGHTFLUSH"; }
			else if (cntF == 4) { System.out.println("f");return "FLUSH"; }
			else if (cntS == 4) { System.out.println("S");return "STRAIGHT"; }
						
			if (i < 3 && input[i-1].number == input[i+2].number) { System.out.println("4");return "FOUR CARD"; }
			if (i < 4 && input[i-1].number == input[i+1].number) { System.out.println("3");return "THREE CARD"; }
			if (input[i].number == input[i-1].number) { cnt++; }
			if (i == 4 && cnt == 2) { System.out.println("2");return "2 PAIR"; }
			else if (i == 4 && cnt == 1) { System.out.println("1");return "1 PAIR"; }
		}
		return "NO RANK"; // If none of the above is returned
	}

	// 5 sequential numbers --> "STRAIGHT"
	@Test
	void test() {
		Card[] cArr = {
			new Card(1, 1), new Card(4, 2), new Card(3, 3),
			new Card(3, 4), new Card(2, 5)
		};
		assertTrue(rankCheck(cArr).equals("STRAIGHT"));
	}
	
	// One pair of cards with the same number --> "1 PAIR"
	@Test
	void test2() {
		Card[] cArr = {
			new Card(4, 1), new Card(4, 3), new Card(3, 5),
			new Card(3, 1), new Card(2, 2)
		};
		assertTrue(rankCheck(cArr).equals("1 PAIR"));
	}
	
	// Two pairs of cards with the same numbers --> "2 PAIR"
	@Test
	void test3() {
		Card[] cArr = {
			new Card(3, 1), new Card(2, 4), new Card(3, 4),
			new Card(1, 1), new Card(2, 3)
		};
		assertTrue(rankCheck(cArr).equals("2 PAIR"));
	}
	
	// Three cards with the same number --> "THREE CARD"
	@Test
	void test4() {
		Card[] cArr = {
			new Card(4, 1), new Card(4, 4), new Card(3, 4),
			new Card(2, 4), new Card(2, 1)
		};
		assertTrue(rankCheck(cArr).equals("THREE CARD"));
	}

	// Four cards with the same number --> "FOUR CARD"
	@Test
	void test5() {
		Card[] cArr = {
			new Card(2, 1), new Card(1, 1), new Card(3, 1),
			new Card(3, 1), new Card(2, 5)
		};
		assertTrue(rankCheck(cArr).equals("FOUR CARD"));
	}
	
	// All cards have the same suit --> "FLUSH"
	@Test
	void test6() {
		Card[] cArr = {
			new Card(3, 1), new Card(3, 2), new Card(3, 1),
			new Card(3, 4), new Card(3, 3)
		};
		assertTrue(rankCheck(cArr).equals("FLUSH"));
	}
	
	// All cards have the same suit and numbers in sequence --> "STRAIGHTFLUSH"
	@Test
	void test7() {
		Card[] cArr = {
			new Card(3, 1), new Card(3, 2), new Card(3, 3),
			new Card(3, 4), new Card(3, 5)
		};
		assertTrue(rankCheck(cArr).equals("STRAIGHTFLUSH"));
	}
}