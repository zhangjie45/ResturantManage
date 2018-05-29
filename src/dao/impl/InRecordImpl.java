package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cat;
import model.InRecord;
import model.lay_user;
import dao.InRecordDao;
import db.DBCon;
/**
 * @author ggg
 *
 */
public class InRecordImpl implements InRecordDao {
	DBCon util = new DBCon();
	@Override
	public boolean addRecord(InRecord inrecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<InRecord> queryAllrecord() {
		return  _list(util.query("select * from lay_book"));
	}

	private List<InRecord> _list(ResultSet rs) {
		List<InRecord> _list=new ArrayList<InRecord>();
		try {
			while(rs.next()){
				InRecord inrecord=new InRecord();
				inrecord.setName(rs.getString("book_name"));
				inrecord.setDate(rs.getDate("in_date"));
				inrecord.setNum(rs.getInt("in_count"));
				_list.add(inrecord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return _list;
	}

	//查找价格
	@Override
	public List<InRecord> queryPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	//查找库存通过名字
	@Override
	public InRecord QueryByName(String name) {
		return _InRecord(util.query("select * from lay_book where book_name=?", name));
		}

	private InRecord _InRecord(ResultSet rs) {
		InRecord inrecord=null;
		try {
			if(rs.next()){
				inrecord=new InRecord();
				inrecord.setNum(rs.getInt("book_count"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inrecord;
	}

	//查找价格通过名字
	@Override
	public InRecord QueryPriceByName(String name) {
		return _InRecordlist(util.query("select * from lay_book where book_name=?", name));
	}

	private InRecord _InRecordlist(ResultSet rs) {
		InRecord inrecord=null;
		try {
			if(rs.next()){
				inrecord=new InRecord();
				inrecord.setPrice(rs.getFloat("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inrecord;
	}

	/**通过名字更新库存
	 * 
	 */
	@Override
	public int updateInCount(String name, int num,int numplus) {
		return util.update("update lay_book set in_count= ?, book_count=? where book_name=?", num,numplus,name);
	}

	@Override
	public List<InRecord> QueryOne(String date) {
		// TODO Auto-generated method stub
		return _list(util.query("select * from lay_book where in_date = ?",date));
	}

}
