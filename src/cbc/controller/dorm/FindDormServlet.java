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
        	request.setAttribute("msg", "查询ID不能为空");
    		request.getRequestDispatcher("/dorm.jsp").forward(request,
    				response);
        }else if(dorm!=null){
        	
        	out.print("宿舍id为:");
			out.println(dorm.getId());
			out.print("</br>");
			out.print("宿舍名为:");
			out.println(dorm.getName());
			out.print("</br>");
			out.print("总床位数:");
			out.println(dorm.getBedsum());
			out.print("</br>");
			out.print("已住人数:");
			out.println(dorm.getUsedbed()+"人");
			out.print("</br>");
			out.print("宿舍管理员为:");
			out.println(dorm.getHouseparent());
			out.print("</br>");
			out.print("备注信息为:");
			out.println(dorm.getRemarks());
			out.print("</br>");
			out.print("宿舍启用时间为:");
			out.println(dorm.getUpdate_date());
			out.print("</br>");
        }else{
        	out.println("未查询到相关信息");
        }
                  
		out.println("<html>");
		out.println("<head>");
		out.println("<title>查询寝室信息</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("</br>");
		out.println("<a href='/dorm/dorm.jsp'>返回</a>");
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

