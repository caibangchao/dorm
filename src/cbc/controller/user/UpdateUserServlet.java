package cbc.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbc.model.User;
import cbc.utils.UserUtils;

public class UpdateUserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateUserServlet() {
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
        String username = request.getParameter("username4");
        String pwd = request.getParameter("pwd1");
        String email = request.getParameter("email1");
        String id = request.getParameter("id1");
        if(username == ""||pwd == ""||email == ""||id == ""){
        	request.setAttribute("msg", "�޸��û���Ϣʱ���ܴ���δ����Ϣ");
    		request.getRequestDispatcher("/usercontrol.jsp").forward(request,
    				response);
        	
        }else{
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(pwd);
        user.setEmail(email);
        user.setId(Integer.parseInt(id));
        UserUtils userUtils = new UserUtils();
        userUtils.updateUser(user);
        out.print("��ϲ�㡣idΪ"+user.getId()+"���ʺ��Ѿ��޸ĳɹ�");
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
