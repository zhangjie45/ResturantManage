package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.lay_user;
import dao.IUserDao;
import db.DBCon;
/**
 * @author ggg
 *
 */
public class UserDaoImpl implements IUserDao {
	DBCon util = new DBCon();

	@Override
	public lay_user QueryByName(String name) {
		return _layuser(util.query("select * from user where name=?", name));
	}

	private lay_user _layuser(ResultSet rs) {
		lay_user user=null;
		try {
			if(rs.next()){
				user=new lay_user();
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	
	
	
	
	
	

}
