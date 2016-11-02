package cbc.controller.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbc.utils.StudentUtils;

public class DeleteStudent extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteStudent() {
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
        String name = request.getParameter("name");
        if(name==""){
        	request.setAttribute("msg", "ɾ��������Ϊ��");
    		request.getRequestDispatcher("student.jsp").forward(request,
    				response);
        }
        else{
        out.print("ѧ����Ϊ"+name+"���û���Ϣ�ѱ�ɾ��,�����ɹ�");
        out.print("</br>");
        StudentUtils studentUtils = new StudentUtils();
        studentUtils.deleteStudent(name);
        
        }
        out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("</br>");
		out.println("<a href='/dorm/student.jsp'>����</a>");
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
