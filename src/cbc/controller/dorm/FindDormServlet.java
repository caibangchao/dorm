package cbc.controller.dorm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbc.model.Dorm;
import cbc.utils.DormUtils;

public class FindDormServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FindDormServlet() {
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
        DormUtils dormUtils = new DormUtils();
        Dorm dorm = new Dorm();
        
        String id = request.getParameter("id2");
        dorm = dormUtils.findDorm(id);
        if(id==""){
        	request.setAttribute("msg", "��ѯID����Ϊ��");
    		request.getRequestDispatcher("/dorm.jsp").forward(request,
    				response);
        }else if(dorm!=null){
        	
        	out.print("����idΪ:");
			out.println(dorm.getId());
			out.print("</br>");
			out.print("������Ϊ:");
			out.println(dorm.getName());
			out.print("</br>");
			out.print("�ܴ�λ��:");
			out.println(dorm.getBedsum());
			out.print("</br>");
			out.print("��ס����:");
			out.println(dorm.getUsedbed()+"��");
			out.print("</br>");
			out.print("�������ԱΪ:");
			out.println(dorm.getHouseparent());
			out.print("</br>");
			out.print("��ע��ϢΪ:");
			out.println(dorm.getRemarks());
			out.print("</br>");
			out.print("��������ʱ��Ϊ:");
			out.println(dorm.getUpdate_date());
			out.print("</br>");
        }else{
        	out.println("δ��ѯ�������Ϣ");
        }
                  
		out.println("<html>");
		out.println("<head>");
		out.println("<title>��ѯ������Ϣ</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("</br>");
		out.println("<a href='/dorm/dorm.jsp'>����</a>");
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

