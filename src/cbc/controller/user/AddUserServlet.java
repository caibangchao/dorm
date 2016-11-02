package cbc.controller.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbc.model.User;
import cbc.utils.UserUtils;

public class AddUserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddUserServlet() {
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
		response.setCharacterEncoding("GB2312");//设置返回链接
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username3");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        if(username==""||pwd==""||email==""){
        	request.setAttribute("msg", "增加用户时不能存在未填信息");
    		request.getRequestDispatcher("/usercontrol.jsp").forward(request,
    				response);
        }else{
        
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(pwd);
        user.setEmail(email);
   
        UserUtils userUtils = new UserUtils();
        try {
			userUtils.insertUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        out.print("恭喜你。用户名为"+user.getUsername()+"的帐号已经增加成功");
        out.print("</br>");
        out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("</br>");
		out.println("<a href='/dorm/usercontrol.jsp'>返回</a>");
		out.println("</body>");
		out.println("</html>");
	}
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