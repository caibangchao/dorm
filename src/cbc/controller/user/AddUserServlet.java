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
		response.setCharacterEncoding("GB2312");//���÷�������
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username3");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        if(username==""||pwd==""||email==""){
        	request.setAttribute("msg", "�����û�ʱ���ܴ���δ����Ϣ");
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
        out.print("��ϲ�㡣�û���Ϊ"+user.getUsername()+"���ʺ��Ѿ����ӳɹ�");
        out.print("</br>");
        out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("</br>");
		out.println("<a href='/dorm/usercontrol.jsp'>����</a>");
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