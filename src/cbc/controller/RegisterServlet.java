package cbc.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cbc.model.User;
import cbc.utils.UserService;
import cbc.utils.UserUtils;

public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("GB2312");
		// 判断验证码输入是否正确
		String checkcode = request.getParameter("checkcode");
		String checkcode_session = (String) request.getSession().getAttribute(
				"checkcode_session");
		// 删除session中验证码
		request.getSession().removeAttribute("checkcode_session");

		if (checkcode_session == null || !checkcode_session.equals(checkcode)) {

			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
			return;
		}
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String pwd1 = request.getParameter("password1");
        String email = request.getParameter("email");
		if(username == ""||pwd == "" ||pwd1==""||email==""){
			request.setAttribute("msg", "用户名或密码邮箱不能为空");
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
			
		}else{
		
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (pwd.equals(pwd1)) {
			UserService userService = new UserService();
			int result = userService.addUser(user);
			if (result == UserService.NAMEEXIST) {
				request.setAttribute("msg", "用户名已经存在！");
				request.getRequestDispatcher("/register.jsp").forward(request,
						response);
			} else if (result == UserService.EMAILEXIST) {
				request.setAttribute("msg", "邮箱已被使用！");
				request.getRequestDispatcher("/register.jsp").forward(request,
						response);
			} else if (result == UserService.SUCCESS) {
				response.sendRedirect("/dorm/home.jsp");
			}
		} else {
			request.setAttribute("msg", "两次密码不一致");
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
		}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
