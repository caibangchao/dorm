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
import cbc.utils.UserUtils;





public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
			request.getRequestDispatcher("/home.jsp").forward(request,
					response);
			return;
		}
		String username = request.getParameter("username");
        if(username == ""){
        	request.setAttribute("msg", "用户名不能为空");
			request.getRequestDispatcher("/home.jsp").forward(request,
					response);
		}
		User user = new User();
		UserUtils userUtils = new UserUtils();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
			request.getRequestDispatcher("/admin.jsp").forward(request,
					response);
		} else if(userUtils.checkUser(user)!=null){
		 response.sendRedirect("userlook.jsp");
		}else{
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/home.jsp").forward(request,
					response);
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
