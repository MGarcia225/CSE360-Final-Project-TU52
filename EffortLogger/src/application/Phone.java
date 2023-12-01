package application;

public class Phone {
	private String phoneNumber;
	private String carrier;
	
	public Phone(String phoneNum, String carr) {
		phoneNumber = phoneNum;
		carrier = carr;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getCarrier() {
		return carrier;
	}
}
