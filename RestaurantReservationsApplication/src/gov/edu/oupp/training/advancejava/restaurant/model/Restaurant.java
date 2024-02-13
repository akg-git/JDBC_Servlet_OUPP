/**
 * 
 */
package gov.edu.oupp.training.advancejava.restaurant.model;

/**
 * @author Asish Kumar Gouda
 *
 */

public class Restaurant {
	
	private String name;
	private String address;
	private String phoneNumber;
	private int capacity;		//restaurant capacity
	
	//default constructor
	public Restaurant(){}
	
	// parameterized constructor
	public Restaurant(String name, String address, String phoneNumber, int capacity) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.capacity = capacity;
	}
	
	
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	

}
