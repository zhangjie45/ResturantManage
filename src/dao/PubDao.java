package dao;

import java.util.List;

import model.Cat;
import model.Pub;


/**
 * @author ggg
 *
 */
public interface PubDao {
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	boolean addPub(Pub pub);

	/**
	 * 查找全部记录
	 * @return
	 */
	List<Pub> queryAll();
	
	/**
	 * 查找全部出版社
	 * @return
	 */
	List<Pub> queryAllPub();

	/** 查找单一出版社
	 * 
	 */
	Pub queryOnePub(int id);
	
	List<Pub> queryOne(String name);
}
