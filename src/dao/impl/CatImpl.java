package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;








import model.Cat;
import model.lay_user;
import dao.CatDao;
import db.DBCon;
/**
 * @author ggg
 *
 */
public class CatImpl implements CatDao{
	DBCon util = new DBCon();
	
	
	

	
	@Override
	public boolean addCat(Cat cat) {
		return util.update("insert into lay_cat(cat_name,cat_des) values(?,?)",
				cat.getCat_name(), cat.getDes()) > 0;
				}

//未完成
	@Override
	public Cat QueryByCatName(int userid) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	//查询所有
	@Override
	public List<Cat> queryAll() {
		return  _list(util.query("select * from lay_cat"));
	}
	
	private List<Cat> _list(ResultSet rs){
		List<Cat> _list=new ArrayList<Cat>();
		try {
			while(rs.next()){
				Cat cat=new Cat();
				cat.setCat_name(rs.getString("cat_name"));
				cat.setDes(rs.getString("cat_des"));
				_list.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return _list;
	}

	
	/**
	 * 查询一个种类
	 */
	@Override
	public Cat queryOneCat(int id) {
		return  _cat(util.query("select * from lay_cat where id=?",id));
	}
	
	private Cat _cat(ResultSet rs){
		Cat cat=null;
		try {
			if(rs.next()){
				cat=new Cat();
				cat.setCat_name(rs.getString("cat_name"));
				cat.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cat;
	}
	
	
	/**查找全部种类
	 * 
	 */
	@Override
	public List<Cat> queryAllCat() {
		return  _listcat_cat(util.query("select * from lay_cat"));
	}
	
	private List<Cat> _listcat_cat(ResultSet rs){
		List<Cat> _list=new ArrayList<Cat>();
		try {
			while(rs.next()){
				Cat cat=new Cat();
				cat.setCat_name(rs.getString("cat_name"));
				cat.setId(rs.getInt("id"));
				_list.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return _list;
	}

	@Override
	public List<Cat> queryOne(String name) {
		return _list(util.query("select * from lay_cat where cat_name = ?",name));
	}

	
}
