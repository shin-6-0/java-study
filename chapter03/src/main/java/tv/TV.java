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
			this.channel=1;
		}else if(channel==1&&!up){
			this.channel=255;
		}else if(up) {
			this.channel++;
		}else {
			this.channel--;
		}
	}
	public void channel(int i) {
		if(i>255) {
			this.channel=i-255;
		}else if(i==0) {
			this.channel=255;
		}else {
			this.channel=i;
		}
	}
	public void volume(int volume) {
		if(volume>=100) {
			this.volume=0;
		}else {
			this.volume = volume;
		}
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
