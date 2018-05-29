package model;
/**
 * @author ggg
 *
 */
public class Cat {
	String cat_name;
	String des;
	int id;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}

	
	
	public Cat(int id) {
		this.id=id;
	}
	 
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return this.cat_name;
	}
}
