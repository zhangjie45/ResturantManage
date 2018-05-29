package model;

import java.util.Date;
/**
 * @author ggg
 *
 */
public class InRecord {
	int id;
	String name;
	int num;
	Date date;
	float price;
	
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	public InRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
