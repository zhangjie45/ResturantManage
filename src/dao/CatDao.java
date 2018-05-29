package dao;

import java.util.List;

import model.Cat;


/**
 * @author ggg
 *
 */
public interface CatDao {
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	boolean addCat(Cat cat);

	
	
	/**
	 * 通过Id查找 一条记录
	 * @param userid
	 * @return
	 */
	Cat QueryByCatName(int userid);
	
	/**
	 * 查找全部记录
	 * @return
	 */
	List<Cat> queryAll();

	/**
	 * 查找全部种类
	 * @return
	 */
	List<Cat> queryAllCat();


	List<Cat> queryOne(String name);

	/** 查找单一
	 * 
	 * @param id
	 * @return
	 */
	Cat queryOneCat(int id);
	

}
