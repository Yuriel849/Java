package exercises.byChapter.chapter_06;

// TVŬ������ �ۼ��϶�.

public class Exercise06_21 {
	public static void main(String[] args) {
		MyTV t = new MyTV();
		
		t.channel = 100;
		t.volume = 0;
		System.out.println("CH: " + t.channel + ", VOL: " + t.volume);

		t.channelDown();
		t.volumeDown();
		System.out.println("CH: " + t.channel + ", VOL: " + t.volume);

		t.volume = 100;
		t.channelUp();
		t.volumeUp();
		System.out.println("CH: " + t.channel + ", VOL: " + t.volume);
	}

}

class MyTV {
	boolean isPowerOn;
	int channel;
	int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	void turnOnOff() {
		// isPowerOn�� ���� true�� false��, false�� true�� �ٲ۴�.
		isPowerOn = !isPowerOn;
	}
	
	void volumeUp() {
		// volume�� ���� MAX_VOLUME���� ���� ���� ���� 1 ������Ų��.
		if(volume < MAX_VOLUME) { volume++; }
	}
	
	void volumeDown() {
		// volume�� ���� MIN_VOLUME���� Ŭ ���� ���� 1 ���ҽ�Ų��.
		if(volume > MIN_VOLUME) { volume--; }
	}
	
	void channelUp() {
		// channel�� ���� 1 ������Ų��.
		// ���� channel�� MAX_CHANNEL�̸�, channel�� ���� MIN_CHANNEL�� �ٲ۴�.
		if(channel == MAX_CHANNEL) { channel = MIN_CHANNEL; }
		else { channel++; } // else �ٿ��� �Ѵ� --> if�� ����ǵ� �� �κ��� �� ������ ����Ǳ� �����̴�.
	}
	
	void channelDown() {
		// channel�� ���� 1 ���ҽ�Ų��.
		// ���� channel�� MIN_CHANNEL�̸�, channel�� ���� MAX_CHANNEL�� �ٲ۴�.
		if(channel == MIN_CHANNEL) { channel = MAX_CHANNEL; }
		else { channel--; }
	}
} // class MyTV ��.