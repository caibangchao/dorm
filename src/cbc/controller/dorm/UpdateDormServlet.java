package cbc.controller.dorm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbc.model.Dorm;
import cbc.utils.DormService;
import cbc.utils.DormUtils;

public class UpdateDormServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateDormServlet() {
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
        String name = request.getParameter("name1");
        String id = request.getParameter("id1");
        String bedsum = request.getParameter("bedsum1");
        String usedbed = request.getParameter("usedbed1");
        String houseparent = request.getParameter("houseparent1");
        String remarks = request.getParameter("remarks1");
        if(name==""||id==""||bedsum==""||usedbed==""||houseparent==""||remarks==""){
        	request.setAttribute("msg", "�޸����᲻�ܴ���δ����Ϣ");
    		request.getRequestDispatcher("/dorm.jsp").forward(request,
    				response);
        }else{
        	Dorm dorm = new Dorm();
            dorm.setId(id);
            dorm.setName(name);
            dorm.setBedsum(Integer.parseInt(bedsum));
            dorm.setUsedbed(Integer.parseInt(usedbed));
            dorm.setHouseparent(houseparent);
            dorm.setRemarks(remarks);
            DormUtils dormUtils = new DormUtils();
            dormUtils.updateDorm(dorm);
			
				out.print("��ϲ�㡣����IDΪ"+dorm.getId()+"��������Ϣ�Ѿ��޸ĳɹ�");
		        out.print("</br>");
		        out.println("<html>");
				out.println("<head>");
				out.println("<title>�޸�������Ϣ</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("</br>");
				out.println("<a href='/dorm/dorm.jsp'>����</a>");
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
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
