package cardCheckMods;

// Project "009 -- 08.NOV.2018 (OOP)" >> package "study" >> file "Ex04_CardCheckTest"

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

class Ex02_CardCheckTest03 {
		// ����� �ڵ� (INCOMPLETE)
	String rankCheck(Card[] cArr) {
		// ī�� ���� ���� 1 ~ 13
		int[] cntArr = new int[14];
		String rank = "No rank";
		int pairCnt = 0; // pair ���� ī��Ʈ
		
		// ī����
		for(int i = 0; i < cArr.length; i++) {
			cntArr[cArr[i].num]++;
		}
		
		// ī������ ����� �д´�.
		for(int i = 0; i < cntArr.length; i++) {
			if(cntArr[i] == 2 ) { pairCnt++; }
			if(cntArr[i] == 3 ) { rank = "THREE CARD"; }
			if(cntArr[i] == 4 ) { rank = "FOUR CARD"; }
		}
		
		// STRAIGHT���� Ȯ��
		
		// FLUSH���� Ȯ�� (��� ���� �������� Ȯ��)
		String kind = cArr[0].kind;
		
		int i = 1;
		for(; i < cArr.length; i++) {
			if(!(kind.equals(cArr[i].kind))) { break; }
		}
		if(i == 5) { rank = "FLUSH"; }
		
		return kind;
	}
	
	// 5���� ���ڰ� �����̸� "STRAIGHT"
	@Test
	void test() {
		Card[] cArr = {
			new Card("S", 1), new Card("C", 2), new Card("H", 3),
			new Card("H", 4), new Card("D", 5)
		};
		assertTrue(rankCheck(cArr).equals("STRAIGHT"));
	}
	
	// ���� ������ ī�尡 �� ���̸� "1 PAIR"
	@Test
	void test2() {
		Card[] cArr = {
			new Card("C", 1), new Card("C", 3), new Card("H", 5),
			new Card("H", 1), new Card("D", 2)
		};
		assertTrue(rankCheck(cArr).equals("1 PAIR"));
	}
	
	// ���� ������ ī�尡 2���̸� "2 PAIR"
	@Test
	void test3() {
		Card[] cArr = {
			new Card("H", 1), new Card("D", 4), new Card("H", 4),
			new Card("S", 1), new Card("D", 3)
		};
		assertTrue(rankCheck(cArr).equals("2 PAIR"));
	}
	
	// ���� ������ ī�尡 3���̸� "THREE CARD"
	@Test
	void test4() {
		Card[] cArr = {
			new Card("C", 1), new Card("C", 4), new Card("H", 4),
			new Card("D", 4), new Card("D", 1)
		};
		assertTrue(rankCheck(cArr).equals("THREE CARD"));
	}

	// ���� ������ ī�尡 4���̸� "FOUR CARD"
	@Test
	void test5() {
		Card[] cArr = {
			new Card("D", 1), new Card("S", 1), new Card("H", 1),
			new Card("H", 1), new Card("D", 5)
		};
		assertTrue(rankCheck(cArr).equals("FOUR CARD"));
	}
	
	// ��� ī���� ���̰� ������ "FLUSH"
	@Test
	void test6() {
		Card[] cArr = {
			new Card("H", 1), new Card("H", 2), new Card("H", 1),
			new Card("H", 4), new Card("H", 3)
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
