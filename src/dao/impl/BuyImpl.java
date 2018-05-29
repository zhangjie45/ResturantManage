package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Buy;
import model.InRecord;
import dao.BuyDao;
import db.DBCon;
/**
 * @author ggg
 *
 */
public class BuyImpl implements BuyDao {
	DBCon util = new DBCon();
	Date date=new Date();
	
	@Override
	public Buy QueryPriceCountByName(String name) {
		return _Buy(util.query("select * from lay_book where book_name=?", name));
	}

	private Buy _Buy(ResultSet rs) {
		Buy buy=null;
		try {
			if(rs.next()){
				buy=new Buy();
				buy.setBookcount(rs.getInt("book_count"));
				buy.setPrice(rs.getFloat("price"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return buy;
	}

	/** 增加价格，数量，名字
	 * 
	 */
	@Override
	public int InsertPriceName(String bookname, int buy_num, float price_all,int book_count) {
		//减少库存
		util.update("update lay_book set book_count=? where book_name =?",book_count,bookname);
		return util.update("insert into lay_sale_record(book_name,buy_num,buy_date,price_all) values(?,?,?,?)", bookname,buy_num,date,price_all);
	}

	@Override
	public List<Buy> queryAllrecord() {
		return  _listAll(util.query("select * from lay_sale_record"));
	}

	private List<Buy> _listAll(ResultSet rs) {
		List<Buy> _list=new ArrayList<Buy>();
		try {
			while(rs.next()){
				Buy buy=new Buy();
				buy.setName(rs.getString("book_name"));
				buy.setBut_date(rs.getDate("buy_date"));
				buy.setBuy_num(rs.getInt("buy_num"));
				buy.setPrice(rs.getFloat("price_all"));
				_list.add(buy);
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
	public List<Buy> queryOne(String date) {
		// TODO Auto-generated method stub
		return _listAll(util.query("select * from lay_sale_record where buy_date=?",date));
	}
	
	

}
