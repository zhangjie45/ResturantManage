package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Book;
import model.Cat;
import dao.BookMesDao;
import db.DBCon;
/**
 * @author ggg
 *
 */
public class BookImpl implements BookMesDao {
	DBCon util = new DBCon();
	Date date=new Date();
	  
	  @Override
	public boolean addMes(Book book) {
		return util.update("insert into lay_book(book_name,price,book_author,book_des,in_date,pub_id,cat_id) values(?,?,?,?,?,?,?)",
				book.getName(), book.getPrice(),book.getAuthor(),book.getDes(),date,book.getPid(),book.getCid()) > 0;
				
	}

	@Override
	public List<Book> queryAll() {
		return  _list(util.query("select * from lay_book"));
	}

	private List<Book> _list(ResultSet rs) {
		List<Book> _list=new ArrayList<Book>();
		try {
			while(rs.next()){
				Book book=new Book();
				book.setName(rs.getString("book_name"));
				book.setDes(rs.getString("book_des"));
				book.setAuthor(rs.getString("book_author"));
				book.setCount(rs.getInt("book_count"));
				book.setPrice(rs.getFloat("price"));
				book.setCid(rs.getInt("cat_id"));
				book.setPid(rs.getInt("pub_id"));
				_list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return _list;
	}

	public List<Book> queryAllBookname() {
		return  _listbook(util.query("select * from lay_book"));
	}

	private List<Book> _listbook(ResultSet rs) {
		List<Book> _list=new ArrayList<Book>();
		try {
			while(rs.next()){
				Book book=new Book();
				book.setName(rs.getString("book_name"));
				book.setId(rs.getInt("id"));
				_list.add(book);
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
	public List<Book> queryOne(String name) {
		return  _list(util.query("select * from lay_book where book_name = ?",name));
		
	}
	}

	
	
	
	

