package cbc.controller.visitor;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cbc.model.Visitor;
import cbc.utils.VisitorUtils;

public class AddVisitorServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddVisitorServlet() {
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
		Visitor visitor = new Visitor();

		try {
			BeanUtils.populate(visitor, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (visitor.getName() == "" || visitor.getAddress() == ""
				|| visitor.getRelation() == ""
				|| visitor.getStudent_name() == ""
				|| visitor.getDorm_id() == "") {
			request.setAttribute("msg", "���ӷÿ���Ϣʱ���ܴ���δ����Ϣ");
			request.getRequestDispatcher("/visitor.jsp").forward(request,
					response);
		} else {

			VisitorUtils visitorUtils = new VisitorUtils();
			try {
				visitorUtils.insertVisitor(visitor);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			out.print("�ÿ���Ϊ" +visitor.getName()+ "�ķÿ���Ϣ�Ѿ����ӳɹ�");
			out.print("</br>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>���ӷÿ���Ϣ</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("</br>");
			out.println("<a href='/dorm/visitor.jsp'>����</a>");
			out.println("</body>");
			out.println("</html>");
		}
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
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
