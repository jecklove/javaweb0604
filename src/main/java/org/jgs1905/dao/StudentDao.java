package org.jgs1905.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.jgs1905.entity.Student;
import org.jgs1905.utils.DataSourceUtil;

/**
 * 	数据库学生表操作类
 * 
 * 	只能操作student这一张表
 * 
 *	DAO：data access object：数据操作对象	
 *	Repository：仓库
 * 
 * @author junki
 * @date 2020年5月27日
 */
public class StudentDao {

	/**
	 * 	查询所有学生数据
	 * @return 所有学生数据
	 * @throws SQLException 
	 */
	public List<Student> selectAll() throws SQLException {
		
		// 创建dbutils核心类对象，并将连接池作为构造参数
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		
		// 编写sql语句
		String sql = "select * from student";
		
		// 执行sql语句并封装结果
		List<Student> result = qr.query(sql, new BeanListHandler<>(Student.class));
		
		return result;
	}

	/**
	 * 	插入学生数据到数据库
	 * @param student 学生数据封装对象
	 * @return 插入结果：1成功；0失败
	 * @throws SQLException 
	 */
	public int insert(Student student) throws SQLException {
		
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		
		String sql = "insert into student(`name`, sex, age) value(?, ?, ?)";
		
		int result = qr.update(sql, student.getName(), student.getSex(), student.getAge());
		
		return result;
	}

	/**
	 * 	删除数据库对应id行
	 * @param id 主键id
	 * @return 删除结果：1成功；0失败
	 * @throws SQLException 
	 */
	public int deleteById(Long id) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		
		String sql = "delete from student where id = ?";
		
		int result = qr.update(sql, id);
		
		return result;
	}

	public Student findById(Long id) throws SQLException {
		
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		
		String sql = "select * from student where id = ?";
		
		Student result = qr.query(sql, new BeanHandler<>(Student.class),id);
		
		return result;
	}

	public int update(Student student) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		
		String sql = "update student  set `name` = ? , sex = ? ,age = ? where id = ?";
		
		int result = qr.update(sql, student.getName(), student.getSex(), student.getAge(),student.getId());
		
		return result;
	}

}
