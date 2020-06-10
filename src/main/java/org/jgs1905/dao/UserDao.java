package org.jgs1905.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.jgs1905.entity.User;
import org.jgs1905.utils.DataSourceUtil;

/**
 * 用户数据操作类
 * @author junki
 * @date 2020年5月28日
 */
public class UserDao {

	public int insert(User user) {
		
		int result = 0;
		
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		
		String sql = "insert into user(real_name, username, password) value(?, ?, ?)";
		
		try {
			result = qr.update(sql, user.getReal_name(), user.getUsername(), user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public User login(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		
		String sql = "select * from user where username = ? and password = ?";
		
		return qr.query(sql, new BeanHandler<>(User.class), user.getUsername(), user.getPassword());
	}

}
