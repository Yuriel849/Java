package pool;

public class MyTV {
	private boolean isPowerOn;
	private int channel;
	private int volume;
	private int previousChannel;
	
	private final int MAX_VOLUME = 100;
	private final int MIN_VOLUME = 0;
	private final int MAX_CHANNEL = 100;
	private final int MIN_CHANNEL = 1;
	
	public void turnOnOff() {
		// isPowerOn == true ? false : true
		isPowerOn = !isPowerOn;
	}
	
	public void volumeUp() {
		if(volume < MAX_VOLUME) { volume++; }
	}
	
	public void volumeDown() {
		if(volume > MIN_VOLUME) { volume--; }
	}
	
	public void channelUp() {
		if(channel == MAX_CHANNEL) {
			previousChannel = channel;
			channel = MIN_CHANNEL;
		} else {
			previousChannel = channel;
			channel++;
		}
	}
	
	public void channelDown() {
		if(channel == MIN_CHANNEL) { channel = MAX_CHANNEL; }
		else { channel--; }
	}

	public void gotoPrevChannel() {
		int temp = channel;
		channel = previousChannel;
		previousChannel = temp;
		
		// setChannel(previousChannel)
	}
	
	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		if(channel > MAX_CHANNEL || channel < MIN_CHANNEL) { return; }
		previousChannel = this.channel;
		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		if(volume > MAX_VOLUME || volume < MIN_VOLUME) { return; }
		this.volume = volume;
	}
}