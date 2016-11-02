package cbc.controller.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cbc.model.Student;
import cbc.utils.StudentUtils;

public class UpdStudentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdStudentServlet() {
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
		response.setCharacterEncoding("GB2312");// ���÷�������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Student student = new Student();

		try {
			BeanUtils.populate(student, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if (student.getName() == "" || student.getQq() == ""
				|| student.getBirthday() == "" || student.getPhone() == ""
				|| student.getClass_id() == "" || student.getDorm_id() == "") {
			request.setAttribute("msg", "�޸�ѧ����Ϣʱ���ܴ���δ����Ϣ");
			request.getRequestDispatcher("/student.jsp").forward(request,
					response);
		} else {

			StudentUtils studentUtils = new StudentUtils();
			studentUtils.updateStudent(student);
			out.print("��ϲ�㡣ѧ����Ϊ" + student.getName() + "���ʺ��Ѿ��޸ĳɹ�");
			out.print("</br>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>�޸�ѧ����Ϣ" + "</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("</br>");
			out.println("<a href='/dorm/student.jsp'>����</a>");
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
