package model;

/**
 * @author ggg
 *
 */
public class lay_user {
	String name;
	String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public lay_user(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public lay_user() {
		super();
	}
	

	
	
	
}
