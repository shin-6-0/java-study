package tv;

public class TV {

	private int channel;//1 ~ 255
	private int volume; //0~100
	private boolean power; //true,false
	
	public TV() {}
	public TV(int channel, int volume, boolean power) {
		super();
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	public void power(boolean on) {
		power=on;
	}
	public void channel(boolean up) {
		if(channel==255&&up) {
			channel=0;
		}else if(channel==0&&!up){
			channel=255;
		}else if(up) {
			channel++;
		}else {
			channel--;
		}
	}
	public void channel(int i) {
		this.channel=i;
	}
	public void volume(int volume) {
		this.volume = volume;
	}
	public void volume(boolean up) {
		if(volume==100&&up) {
			volume=0;
		}else if(volume==0&&!up){
			volume=100;
		}else if(up) {
			volume++;
		}else {
			volume--;
		}
	}
	public void status() {
		System.out.println("TV[power = "+(power?"ON":"OFF")
				+ ", channel = "+channel
				+ ", volume = "+volume+"]");
	}


	
	
	
}
