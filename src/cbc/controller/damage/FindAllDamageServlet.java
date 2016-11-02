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
		    	
		    	out.print("损坏次数为:");
				out.println(damage.getId());
				out.print("寝室id为:");
				out.println(damage.getDorm_id());
				out.print("损坏情况为:");
				out.println(damage.getQuestion());
				out.print("损坏时间为:");
				out.println(damage.getSt_date());
				out.print("修补时间为:");
				out.println(damage.getFi_date());
				out.print("备注信息为:");
				out.println(damage.getRemarks());
				out.print("目前状态为:");
				out.println(damage.getIsok());
				out.print("创建时间为:");
				out.println(damage.getUpdate_date());
				
				
				out.println("</br>");
				
			}
	        response.setContentType("text/html");
	        out.println("<html>");
			out.println("<head>");
			out.println("<title>查询所有损坏信息</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("</br>");
			out.println("<a href='/dorm/damage.jsp'>返回</a>");
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
