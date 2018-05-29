package dao;

import java.util.List;

import model.Buy;
import model.InRecord;
/**
 * @author gggg
 *
 */
public interface BuyDao {
	/**
	 * 查找库存通过名字
	 * @param name
	 * @return
	 */
	Buy QueryPriceCountByName(String name);
	
	/**
	 * 加入总价格，数量，名字
	 */
	int InsertPriceName(String bookname,int buy_num,float price_all,int book_count);
	
	/** 查找全部
	 * 
	 */
	
	List<Buy> queryAllrecord();
	
	List<Buy> queryOne(String date);
}



