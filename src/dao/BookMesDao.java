package dao;

import java.util.List;

import model.Book;
import model.Cat;
import model.Pub;

/**
 * @author ggg
 *
 */
public interface BookMesDao {
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	boolean addMes(Book book);

	/**
	 * 查找全部记录
	 * @return
	 */
	List<Book> queryAll();
	
	
	List<Book> queryOne(String name);
	List<Book> queryAllBookname();
}
