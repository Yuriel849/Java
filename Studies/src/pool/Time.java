package pool;

@SuppressWarnings("unused")
public class Time {
	private int hour;
	private int minute;
	private int second;
	
	// private Time() { } --> private constructor prevents external access and object creation
	
	public int getHour() {
		return hour;
	}
	
	public void setHour(int hour) {
		if (hour < 0 || hour > 23) return;
		this.hour = hour;
	}
}