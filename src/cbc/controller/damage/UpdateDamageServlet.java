package cbc.controller.damage;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cbc.model.Damage;
import cbc.utils.DamageUtils;

public class UpdateDamageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateDamageServlet() {
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
		
		
		
		if (damage.getDorm_id()==""||damage.getFi_date()==""||damage.getRemarks()=="") {
			request.setAttribute("msg", "�޲�����Ǽ�ʱ���ܴ���δ����Ϣ");
			request.getRequestDispatcher("/damage.jsp").forward(request,
					response);
		} else {

			DamageUtils damageUtils = new DamageUtils();
			damageUtils.updateDamage(damage);
			out.print("����IDΪ" + damage.getDorm_id() + "������������Ѿ��޸ĳɹ�");
			out.print("</br>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>�޸���������Ϣ" + "</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("</br>");
			out.println("<a href='/dorm/damage.jsp'>����</a>");
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
