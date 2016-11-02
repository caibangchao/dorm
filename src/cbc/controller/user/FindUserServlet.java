package cbc.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbc.model.User;
import cbc.utils.UserService;
import cbc.utils.UserUtils;

public class FindUserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FindUserServlet() {
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        UserUtils userUtils = new UserUtils();
        User user = new User();
        
        String username = request.getParameter("username1");
        user = userUtils.findUser(username);
        if(username==""){
        	request.setAttribute("msg", "用户名不能为空");
    		request.getRequestDispatcher("/usercontrol.jsp").forward(request,
    				response);
        }else if(user!=null){
        	
        	out.print("用户id为:");
			out.println(user.getId());
			out.print("</br>");
			out.print("用户名为:");
			out.println(user.getUsername());
			out.print("</br>");
			out.print("用户密码为:");
			out.println(user.getPassword());
			out.print("</br>");
			out.print("用户邮箱为:");
			out.println(user.getEmail());
			out.print("</br>");
			out.print("用户创建时间为:");
			out.println(user.getUpdate_date());
			out.print("</br>");
        }else{
        	out.println("未查询到相关信息");
        }
                  
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("</br>");
		out.println("<a href='/dorm/usercontrol.jsp'>返回</a>");
		out.println("</body>");
		out.println("</html>");
        out.flush();
        out.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
