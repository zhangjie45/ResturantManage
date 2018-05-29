package model;

import java.util.Date;
/**
 * @author ggg
 *
 */
public class Buy {
	int id;
	int buy_num;
	Date but_date;
	int bookcount;
	float price;
	String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBookcount() {
		return bookcount;
	}
	public void setBookcount(int bookcount) {
		this.bookcount = bookcount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuy_num() {
		return buy_num;
	}
	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}
	public Date getBut_date() {
		return but_date;
	}
	public void setBut_date(Date but_date) {
		this.but_date = but_date;
	}
	
	

}
