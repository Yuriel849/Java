package exercises.byChapter.chapter_06;

// TVŬ������ getter & setter�� �߰��϶�.

public class Exercise06_21Mod {
	public static void main(String args[]) {
		MyTv2 t = new MyTv2();

		// check setChannel, getChannel, setVolume, getVolume methods
//		t.setChannel(10);
//		System.out.println("CH:"+t.getChannel());
//		t.setVolume(20);
//		System.out.println("VOL:"+t.getVolume());
		
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
	}
}

class MyTv2 {
	private boolean isPowerOn;
	private int channel;
	private int volume;
	private int previousChannel;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	void turnOnOff() {
		// isPowerOn�� ���� true�� false��, false�� true�� �ٲ۴�.
		isPowerOn = !isPowerOn;
	}
	
	int getVolume() { return volume; }
	
	void setVolume(int input) {
		// ��ȿ��üũ
		if(volume > MAX_VOLUME || volume < MIN_VOLUME) { return; }
		volume = input;
		}
	
	void volumeUp() {
		// volume�� ���� MAX_VOLUME���� ���� ���� ���� 1 ������Ų��.
		if(volume < MAX_VOLUME) { volume++; }
	}
	
	void volumeDown() {
		// volume�� ���� MIN_VOLUME���� Ŭ ���� ���� 1 ���ҽ�Ų��.
		if(volume > MIN_VOLUME) { volume--; }
	}
	
	int getChannel() { return channel; }
	
	void setChannel(int channel) {
		// ��ȿ�� üũ
		if(channel > MAX_CHANNEL || channel < MIN_CHANNEL) { return; }
		previousChannel = this.channel; // channel �ٲ� �� ���� channel�� �������� ���
		this.channel = channel; }
	
	void gotoPrevChannel() { // ���� channel�� ���ư��� ���ÿ� ���� channel�� ���� channel�� ���Ӱ�  ���
		int temp = channel;
		channel = previousChannel;
		previousChannel = temp;
		
		// setChannel(previousChannel)
	}
	
	void channelUp() {
		// channel�� ���� 1 ������Ų��.
		// ���� channel�� MAX_CHANNEL�̸�, channel�� ���� MIN_CHANNEL�� �ٲ۴�.
		if(channel == MAX_CHANNEL) {
			previousChannel = channel; 
			channel = MIN_CHANNEL; }
		else {
			previousChannel = channel; 
			channel++; } // else �ٿ��� �Ѵ� --> if�� ����ǵ� �� �κ��� �� ������ ����Ǳ� �����̴�.
	}
	
	void channelDown() {
		// channel�� ���� 1 ���ҽ�Ų��.
		// ���� channel�� MIN_CHANNEL�̸�, channel�� ���� MAX_CHANNEL�� �ٲ۴�.
		if(channel == MIN_CHANNEL) { channel = MAX_CHANNEL; }
		else { channel--; }
	}
}
