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
		// �ж���֤�������Ƿ���ȷ
		String checkcode = request.getParameter("checkcode");
		String checkcode_session = (String) request.getSession().getAttribute(
				"checkcode_session");
		// ɾ��session����֤��
		request.getSession().removeAttribute("checkcode_session");

		if (checkcode_session == null || !checkcode_session.equals(checkcode)) {

			request.setAttribute("msg", "��֤�����");
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
			return;
		}
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String pwd1 = request.getParameter("password1");
        String email = request.getParameter("email");
		if(username == ""||pwd == "" ||pwd1==""||email==""){
			request.setAttribute("msg", "�û������������䲻��Ϊ��");
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
				request.setAttribute("msg", "�û����Ѿ����ڣ�");
				request.getRequestDispatcher("/register.jsp").forward(request,
						response);
			} else if (result == UserService.EMAILEXIST) {
				request.setAttribute("msg", "�����ѱ�ʹ�ã�");
				request.getRequestDispatcher("/register.jsp").forward(request,
						response);
			} else if (result == UserService.SUCCESS) {
				response.sendRedirect("/dorm/home.jsp");
			}
		} else {
			request.setAttribute("msg", "�������벻һ��");
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
