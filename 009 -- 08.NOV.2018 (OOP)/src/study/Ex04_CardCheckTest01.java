package study;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Card {
	int num;
	String kind;
	
	Card() {
		this("S", 1);
	}
	
	Card(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	
	public String toString() {
		return "(" + kind + "," + num + ")";
	}
}

class Ex04_CardCheckTest01 {
	String rankCheck(Card[] cArr) {
//		Card[] input = cArr;
//		
//		int cntS = 0;
//		int cntF = 0;
//		String result = "";
//		int[] counter = new int[13];

		// ��� 01
//		int cnt = 0;
//		int pairCnt = 0;
//
//		// check for "STRAIGHT"
//		for(int i = 0; i < input.length; i++) {
//			if (i != 0 && (input[i].num == input[i-1].num + 1)) { cnt++; }
//			if (cnt == input.length - 1) { result = "STRAIGHT"; }
//		}
//		
//		// check for "FLUSH"
//		cnt = 0;
//		for(int i = 0; i < input.length; i++) {
//			if (i != 0 && input[i].kind.equals(input[i-1].kind)) { cnt++; }
//			if (cnt == input.length - 1) { result = "FLUSH"; }
//		}
//
//		// check for "1 PAIR", "2 PAIR", "THREE CARD", "FOUR CARD"
//		for(int i = 0; i < input.length; i++) {
//			counter[input[i].num]++;
//		}
//		for(int i = 0; i < counter.length; i++) {
//			if (counter[i] == 4)
//				{ result = "FOUR CARD"; }
//			else if (counter[i] == 3)
//				{ result = "THREE CARD"; }
//			else if (counter[i] == 2)
//				{ pairCnt++; }
//			
//			if (pairCnt == 2)
//				{ result = "2 PAIR"; }
//			else if (pairCnt == 1)
//			 	{ result = "1 PAIR"; }
//		}
		
		// ��� 02 --> ���01�� �ϳ��� ��ģ ���
//		for(int i = 0; i < input.length; i++) {
//			counter[input[i].num]++;
//			if (i != 0 && (input[i].num == input[i-1].num + 1))
//				{ cntS++; }
//			if (i != 0 && input[i].kind.equals(input[i-1].kind))
//				{ cntF++; }
//		}
//			
//		if (cntS == input.length - 1 && cntS == cntF)
//			{ result = "STRAIGHTFLUSH"; }
//		else if (cntS == input.length - 1)
//			{ result = "STRAIGHT"; }
//		else if (cntF == input.length - 1)
//			{ result = "FLUSH"; }
//		cntS = 0;
//		for(int i = 0; i < counter.length; i++) {
//			if (result == "" && counter[i] == 4)
//				{ result = "FOUR CARD"; }
//			else if (result == "" && counter[i] == 3)
//				{ result = "THREE CARD"; }
//			else if (counter[i] == 2)
//				{ cntS++; }
//		}
//		if (result == "" && cntS == 2)
//			{ result = "2 PAIR"; }
//		else if (result == "" && cntS == 1)
//			{ result = "1 PAIR"; }
//		
//		if (result == "") { return "NO RANK"; }
//		else {
//			System.out.println(result);
//			return result;
//			}
		
		// ��� 03
		Card[] input = cArr;
		
		int cntS = 0;
		int cntF = 0;
		String result = "";
		int cnt = 0;
		int check = 0;
		
		for(int i = 1; i < input.length; i++) {
			if (input[i].kind.equals(input[i-1].kind)) {
				cntF++; }
			if (input[i].num == input[i-1].num + 1) {
				cntS++; }
			if (input[i].num == input[i-1].num) {
				if (check == 0) { check = i; }
				else if (input[check].num != input[i].num) {
					result = "2 PAIR";
					break; }
				cnt++;
			}
		} // for�� ����
		
		if (cntS == 4 && cntF == 4) { result = "STRAIGHTFLUSH"; }
		else if (cntF == 4) { result = "FLUSH"; }
		else if (cntS == 4) { result = "STRAIGHT"; }
		else if (result == "") {
			if (cnt == 3) { result = "FOUR CARD"; }
			else if (cnt == 2) { result = "THREE CARD"; }
			else if (cnt == 1) { result = "1 PAIR"; }
		}
		
		if (result == "") { return "NO RANK"; }
		else {
			System.out.println(result);
			return result;
		}
	}

	// 5���� ���ڰ� �����̸� "STRAIGHT"
	@Test
	void test() {
		Card[] cArr = {
			new Card("H", 1), new Card("H", 2), new Card("H", 3),
			new Card("H", 4), new Card("D", 5)
		};
		assertTrue(rankCheck(cArr).equals("STRAIGHT"));
	}
	
	// ���� ������ ī�尡 �� ���̸� "1 PAIR"
	@Test
	void test2() {
		Card[] cArr = {
			new Card("H", 1), new Card("H", 1), new Card("H", 3),
			new Card("H", 4), new Card("D", 5)
		};
		assertTrue(rankCheck(cArr).equals("1 PAIR"));
	}
	
	// ���� ������ ī�尡 2���̸� "2 PAIR"
	@Test
	void test3() {
		Card[] cArr = {
			new Card("H", 1), new Card("H", 1), new Card("H", 3),
			new Card("H", 3), new Card("D", 5)
		};
		assertTrue(rankCheck(cArr).equals("2 PAIR"));
	}
	
	// ���� ������ ī�尡 3���̸� "THREE CARD"
	@Test
	void test4() {
		Card[] cArr = {
			new Card("H", 1), new Card("H", 1), new Card("H", 1),
			new Card("H", 4), new Card("D", 5)
		};
		assertTrue(rankCheck(cArr).equals("THREE CARD"));
	}

	// ���� ������ ī�尡 4���̸� "FOUR CARD"
	@Test
	void test5() {
		Card[] cArr = {
			new Card("H", 1), new Card("H", 1), new Card("H", 1),
			new Card("H", 1), new Card("D", 5)
		};
		assertTrue(rankCheck(cArr).equals("FOUR CARD"));
	}
	
	// ��� ī���� ���̰� ������ "FLUSH"
	@Test
	void test6() {
		Card[] cArr = {
			new Card("H", 1), new Card("H", 3), new Card("H", 3),
			new Card("H", 4), new Card("H", 5)
		};
		assertTrue(rankCheck(cArr).equals("FLUSH"));
	}
	
	// ��� ī���� ���̵� ���� 5���� ���ڵ� ���ӵǸ� "STRAIGHTFLUSH"
	@Test
	void test7() {
		Card[] cArr = {
			new Card("H", 1), new Card("H", 2), new Card("H", 3),
			new Card("H", 4), new Card("H", 5)
		};
		assertTrue(rankCheck(cArr).equals("STRAIGHTFLUSH"));
	}
}
