/**
 * 
 */
package gov.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author AKG
 *
 */
public class User implements Serializable{
	
	private String username;
	private transient String password;	// make transient so that "password" will  not be part of serialization
	
	public User(){}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	//getters and setters
	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}

	
	private void writeObject(ObjectOutputStream oos) throws IOException{
		
		oos.defaultWriteObject();
		String epwd = "123"+password;
		oos.writeObject(epwd);
		
	}
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException{
		
		ois.defaultReadObject();
		String epwd = (String) ois.readObject();
		password = epwd.substring(3);
		
		
	}
	
	
	
	
	

}
