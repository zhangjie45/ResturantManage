package dao;

import java.util.List;

import model.lay_user;


/**
 * @author ggg
 *数据访问接口
 */
/**
 * @author ggg
 *
 */
public interface IUserDao {
	/**
	 * 通过账户查找
	 * @param user
	 * @return
	 */
	lay_user QueryByName(String name);
	
	
}
