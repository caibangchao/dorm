package cbc.controller.dorm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbc.model.Dorm;
import cbc.utils.DormUtils;

public class DeleteDormServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteDormServlet() {
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
        
        
        String id = request.getParameter("id3");
        
        
        
        if(id==""){
        	request.setAttribute("msg", "ɾ����ϢʱID����Ϊ��");
    		request.getRequestDispatcher("/dorm.jsp").forward(request,
    				response);
    		}else{
    			out.print("idΪ"+id+"���û���Ϣ�ѱ�ɾ��,�����ɹ�");
    	        out.print("</br>");
    	        DormUtils dormUtils = new DormUtils();
    	        dormUtils.deleteDorm(id);
    	        
    	        }
    	        out.println("<html>");
    			out.println("<head>");
    			out.println("<title>ɾ���û�����</title>");
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
