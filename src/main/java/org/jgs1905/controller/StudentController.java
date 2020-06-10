package org.jgs1905.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.jgs1905.entity.Student;
import org.jgs1905.service.StudentService;

/**
 * 学生控制器
 * @author junki
 * @date 2020年6月4日
 */
@WebServlet("/student")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentService studentService = new StudentService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		switch (method) {
		case "list":
			list(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		case "add":
			add(request, response);
			break;
		case "update":
			update(request, response);
			break;
		default:
			response.sendRedirect(request.getContextPath() + "/error/404.jsp");
			break;
		}
	}

	/**
	 * 修改学生数据处理方法
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		
		// get请求表示跳转到修改页面，post请求表示保存修改结果
		switch (method) {
		case "GET":
			String idStr = request.getParameter("id");	
			Student student = null;
			if (idStr != null && !idStr.trim().equals("")) {
				try {
					student = studentService.findById(Long.valueOf(idStr));
				} catch (NumberFormatException | SQLException e) {
					e.printStackTrace();
				}
			}
			
			request.setAttribute("student", student);
			
			request.getRequestDispatcher("/student/update.jsp").forward(request, response);
			break;
		case "POST":

			Student stu = new Student();
			
			try {
				BeanUtils.populate(stu, request.getParameterMap());
			} catch (IllegalAccessException | InvocationTargetException e1) {
				e1.printStackTrace();
			}
			
			try {
				studentService.update(stu);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/student?method=list");
			
			break;
		default:
			response.sendRedirect(request.getContextPath() + "/error/404.jsp");
			break;
		}
	}

	/**
	 * 添加学生处理方法
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String[]> parameterMap = request.getParameterMap();
		Student student = new Student();
		try {
			BeanUtils.populate(student, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e1) {
			e1.printStackTrace();
		}
		
		StudentService service = new StudentService();
		
		int result = 0;
		try {
			result = service.add(student);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		if (result == 1) {
			response.sendRedirect(request.getContextPath() + "/student?method=list");
		} else {
			request.getRequestDispatcher("/student/add.jsp?message=保存失败，稍后再试！").forward(request, response);
		}
	}

	/**
	 * 根据id删除学生
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idStr = request.getParameter("id");	
		
		if (idStr != null && !idStr.trim().equals("")) {
			StudentService service = new StudentService();
			try {
				service.deleteById(Long.valueOf(idStr));
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath() + "/student?method=list");
		}
	}

	/**
	 * 获取学生列表
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 调用业务方法获取数据
		List<Student> students = null;
		try {
			students = studentService.getList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 将学生列表保存到作用域
		request.setAttribute("students", students);
		
		// 转发到列表页面
		request.getRequestDispatcher("/student/list.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
