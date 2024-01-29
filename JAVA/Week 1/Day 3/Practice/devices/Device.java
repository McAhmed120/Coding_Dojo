
public class Device {
	private int battery;
	
	public Device() {
		this.battery=100;
	};
	public Device(int battery) {
		this.battery=battery;
	};
	
	
	public void displaybattery() {
		System.out.println("The  battery level is : %"+this.battery+"\n");
	}
	

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}
	
}
