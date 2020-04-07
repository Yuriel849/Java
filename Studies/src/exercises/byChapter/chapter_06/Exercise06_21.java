package exercises.byChapter.chapter_06;

import pool.MyTV;

public class Exercise06_21 {
	public static void main(String[] args) {
		MyTV t = new MyTV();
		
		t.setChannel(100);
		t.setVolume(0);
		System.out.println("CH: " + t.getChannel() + ", VOL: " + t.getVolume());

		t.channelDown();
		t.volumeDown(); // Does nothing because volume is already minimum (0)
		System.out.println("CH: " + t.getChannel() + ", VOL: " + t.getVolume());

		t.setVolume(100);
		t.channelUp();
		t.volumeUp(); // Does nothing because volume is already maximum (100)
		System.out.println("CH: " + t.getChannel() + ", VOL: " + t.getVolume());
		
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