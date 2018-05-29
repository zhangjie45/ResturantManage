package dao;

import java.util.List;

import model.Book;
import model.InRecord;

/**
 * @author ggg
 *
 */
public interface InRecordDao {
	
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	boolean addRecord(InRecord inrecord);
	/**
	 * 查找全部记录
	 * @return
	 */
	List<InRecord> queryAllrecord();
	/**
	 * 增加按钮查询价格
	 * @return
	 */
	List<InRecord> queryPrice();
	/**
	 * 查找库存通过名字
	 * @param name
	 * @return
	 */
	InRecord QueryByName(String name);
	/**
	 * 查找价格通过名字
	 * @param name
	 * @return
	 */
	InRecord QueryPriceByName(String name);
	
	/** 
	 * 通过名字更新存库
	 * @param name
	 * @param num
	 * @return
	 */
	int updateInCount(String name,int num,int numpius);
	
	List<InRecord> QueryOne(String date);
}
