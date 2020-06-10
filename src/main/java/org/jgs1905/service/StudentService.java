package org.jgs1905.service;

import java.sql.SQLException;
import java.util.List;

import org.jgs1905.dao.StudentDao;
import org.jgs1905.entity.Student;



/**
 * 	学生相关业务类
 * 
 * 	一个service可以调用多个dao
 * 	保证多个dao调用的事务，不能有的成功有的失败
 * 
 * @author junki
 * @date 2020年5月27日
 */
public class StudentService {
	
	private StudentDao studentDao = new StudentDao();
	
	/**
	 * 	获取学生列表
	 * @return 学生列表
	 * @throws SQLException 
	 */
	public List<Student> getList() throws SQLException {
		return studentDao.selectAll();
	}
	
	/**
	 * 	保存一个学生
	 * @param student 学生数据封装对象
	 * @return 保存结果：1成功；0失败
	 * @throws SQLException 
	 */
	public int add(Student student) throws SQLException {
		return studentDao.insert(student);
	}
	
	/**
	 * 	根据id删除学生
	 * @param id 学生id
	 * @return 删除结果：1成功；0失败
	 * @throws SQLException 
	 */
	public int deleteById(Long id) throws SQLException {
		return studentDao.deleteById(id);
	}

	public Student findById(Long id) throws SQLException{
		return studentDao.findById(id);
	}
	
	public int update(Student student) throws SQLException{
		return studentDao.update(student);
	}
}
