package model;
/**
 * @author ggg
 *
 */
public class Pub {

	int id;

	

	String pub_name;
	String pub_preson;
	String pub_tel;
	String pub_des;

	public String getPub_name() {
		return pub_name;
	}

	public void setPub_name(String pub_name) {
		this.pub_name = pub_name;
	}

	public String getPub_preson() {
		return pub_preson;
	}

	public void setPub_preson(String pub_preson) {
		this.pub_preson = pub_preson;
	}

	public String getPub_tel() {
		return pub_tel;
	}

	public void setPub_tel(String pub_tel) {
		this.pub_tel = pub_tel;
	}

	public String getPub_des() {
		return pub_des;
	}

	public void setPub_des(String pub_des) {
		this.pub_des = pub_des;
	}

	public Pub(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Pub() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return this.pub_name;
	}
}
