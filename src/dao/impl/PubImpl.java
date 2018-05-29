package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cat;
import model.Pub;
import dao.PubDao;
import db.DBCon;
/**
 * @author ggg
 *
 */
public class PubImpl implements PubDao {
	
	DBCon util = new DBCon();
	
	
	@Override
	public boolean addPub(Pub pub) {
		return util.update("insert into lay_pub(pub_name,pub_person,pub_tel,pub_des) values(?,?,?,?)",
				pub.getPub_name(), pub.getPub_preson(),pub.getPub_tel(),pub.getPub_des()) > 0;
	}

	@Override
	public List<Pub> queryAll() {
		return  _list(util.query("select * from lay_pub"));
	}

	private List<Pub> _list(ResultSet rs) {
		List<Pub> _list=new ArrayList<Pub>();
		try {
			while(rs.next()){
				Pub pub=new Pub();
				pub.setPub_name(rs.getString("pub_name"));
				pub.setPub_preson(rs.getString("pub_person"));
				pub.setPub_tel(rs.getString("pub_tel"));
				pub.setPub_des(rs.getString("pub_des"));
				_list.add(pub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return _list;
	}
	
	
	//查找全部出版社
		@Override
		public List<Pub> queryAllPub() {
			return  _listpub(util.query("select * from lay_pub"));
		}
		
		private List<Pub> _listpub(ResultSet rs){
			List<Pub> _list=new ArrayList<Pub>();
			try {
				while(rs.next()){
					Pub pub=new Pub();
					pub.setPub_name(rs.getString("pub_name"));
					pub.setId(rs.getInt("id"));
					_list.add(pub);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeAll();
			}
			return _list;
		}

		public Pub queryOnePub(int id) {
			return  _one_pub(util.query("select * from lay_pub where id=?",id));
		}

		private Pub _one_pub(ResultSet rs) {
			Pub pub=null;
			try {
				if(rs.next()){
					pub=new Pub();
					pub.setPub_name(rs.getString("pub_name"));
					pub.setId(rs.getInt("id"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return pub;
		}

		@Override
		public List<Pub> queryOne(String name) {
			// TODO Auto-generated method stub
			return  _list(util.query("select * from lay_pub where pub_name=?",name));
		}
	}

