package cbc.controller.damage;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cbc.model.Damage;
import cbc.utils.DamageUtils;

public class AddDamageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddDamageServlet() {
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

		response.setCharacterEncoding("GB2312");// 设置返回链接
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Damage damage = new Damage();

		try {
			BeanUtils.populate(damage, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (damage.getDorm_id() == "" || damage.getQuestion() == ""
				|| damage.getSt_date() == "" || damage.getRemarks() == "") {
			request.setAttribute("msg", "增加损坏信息时不能存在未填信息");
			request.getRequestDispatcher("/damage.jsp").forward(request,
					response);
		} else {

			DamageUtils damageUtils = new DamageUtils();
            try {
				damageUtils.insertDamage(damage);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				out.print("宿舍ID为" +damage.getDorm_id() + "的损坏信息已经增加成功");
				out.print("</br>");
				out.println("<html>");
				out.println("<head>");
				out.println("<title>增加损坏信息</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("</br>");
				out.println("<a href='/dorm/damage.jsp'>返回</a>");
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
