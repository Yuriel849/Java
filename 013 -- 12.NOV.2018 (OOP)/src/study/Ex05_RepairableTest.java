package study;

class Ex05_RepairableTest {
	public static void main(String[] args) {
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		Marine marine = new Marine();
		SCV scv = new SCV();
		
		scv.repair(tank);
		scv.repair(dropship);
		scv.repair(scv);
//		scv.repair(marine); --> ����! --> repair(Repairable) in SCV cannot be applied to class Marine
	}
}

interface Repairable {} // ���� ���� �������̽� �ۼ�

class Unit {
	int hitPoint;
	final int MAX_HP;
	
	Unit(int hp) {
		MAX_HP = hp;
	}
	
	// ��Ÿ���......
}

class GroundUnit extends Unit {
	GroundUnit(int hp) { // GroundUnit Ŭ������ ������
		super(hp); // GroundUnit�� parent�� Unit Ŭ������ ������ ȣ��
	}
}

class AirUnit extends Unit {
	AirUnit(int hp) {
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairable {
	Tank() {
		super(150);
		hitPoint = MAX_HP;
		/* Tank �����ڿ��� GroundUnit ������ ȣ��
		 *	--> GroundUnit �����ڿ��� Unit ������ ȣ��
		 * 	--> Unit���� Tank�� ���� MAX_HP ����
		 * 	--> MAX_HP�� hitPoint�� ����
		 * 		(ü���� �Ѱ�(MAX_HP)�� �����ϵ� ü���� �Ұ� ä�� �� ����ϱ� ���� hitPoint)
		 */
	}
	
	public String toString() {
		return "Tank";
	}
	
	// ��Ÿ ���......
}

class Dropship extends AirUnit implements Repairable {
	Dropship() {
		super(125);
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "Dropship";
	}
	
	// ��Ÿ ���......
}

class Marine extends GroundUnit {
	Marine() {
		super(40);
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "Marine";
	}
	
	// ��Ÿ ���......
}

class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}
	
	void repair(Repairable r) {
		if(r instanceof Unit) {
			Unit u = (Unit) r;
			while(u.hitPoint != u.MAX_HP) {
				/* Unit�� HP�� ������Ų��. */
				u.hitPoint++;
			}
			System.out.println(u.toString() + "�� ������ �������ϴ�.");
		}
	}
	
	public String toString() {
		return "SCV";
	}
}