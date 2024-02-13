/**
 * 
 */
package gov.edu.oupp.training.advancejava.restaurant.model;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Asish Kumar Gouda
 *
 */
public class Reservation {

	private int id;
	private Date date;
	private String time;
	private int partySize;
	private String customerName;
	private String phoneNumber;
	private int tableId; // restaurant table number

	// default constructor
	public Reservation() {
	}

	// parameterized constructor

	public Reservation(int id, Date date, String time, int partySize, String customerName, String phoneNumber,
			int tableId) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.partySize = partySize;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.tableId = tableId;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getPartySize() {
		return partySize;
	}

	public void setPartySize(int partySize) {
		this.partySize = partySize;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

}
