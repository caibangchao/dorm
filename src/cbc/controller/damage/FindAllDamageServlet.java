package cbc.controller.damage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbc.model.Damage;
import cbc.utils.DamageUtils;

public class FindAllDamageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FindAllDamageServlet() {
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
		DamageUtils damageUtils = new DamageUtils();
		List<Damage> damages = new ArrayList<Damage>();
		damages = damageUtils.findAll();
		
		 PrintWriter out = response.getWriter();
		
		    for (Damage damage:damages) {
		    	
		    	out.print("�𻵴���Ϊ:");
				out.println(damage.getId());
				out.print("����idΪ:");
				out.println(damage.getDorm_id());
				out.print("�����Ϊ:");
				out.println(damage.getQuestion());
				out.print("��ʱ��Ϊ:");
				out.println(damage.getSt_date());
				out.print("�޲�ʱ��Ϊ:");
				out.println(damage.getFi_date());
				out.print("��ע��ϢΪ:");
				out.println(damage.getRemarks());
				out.print("Ŀǰ״̬Ϊ:");
				out.println(damage.getIsok());
				out.print("����ʱ��Ϊ:");
				out.println(damage.getUpdate_date());
				
				
				out.println("</br>");
				
			}
	        response.setContentType("text/html");
	        out.println("<html>");
			out.println("<head>");
			out.println("<title>��ѯ��������Ϣ</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("</br>");
			out.println("<a href='/dorm/damage.jsp'>����</a>");
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
