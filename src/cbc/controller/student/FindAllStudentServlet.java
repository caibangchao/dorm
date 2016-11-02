package cbc.controller.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbc.model.Student;
import cbc.utils.StudentUtils;

public class FindAllStudentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FindAllStudentServlet() {
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
		StudentUtils studentUtils = new StudentUtils();
		List<Student> students = new ArrayList<Student>();
		students = studentUtils.findAll();
		
		 PrintWriter out = response.getWriter();
		
		    for (Student student:students) {
				out.print("学生id为:");
				out.println(student.getId());
				out.print("学生名为:");
				out.println(student.getName());
				out.print("学生性别为:");
				out.println(student.getGender());
				out.print("学生生日为:");
				out.println(student.getBirthday());
				out.print("学生手机号为:");
				out.println(student.getPhone());
				
				out.print("学生所属班级ID为:");
				out.println(student.getClass_id());
				out.print("学生所属寝室ID为:");
				out.println(student.getDorm_id());
				out.print("学生创建时间为:");
				out.println(student.getUpdate_date());
				out.println("</br>");
				
			}
	        response.setContentType("text/html");
	        out.println("<html>");
			out.println("<head>");
			out.println("<title>查询所有学生信息</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("</br>");
			out.println("<a href='/dorm/student.jsp'>返回</a>");
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
