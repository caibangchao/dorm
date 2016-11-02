package cbc.controller.score;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cbc.model.Score;
import cbc.utils.ScoreUtils;

public class AddScoreServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddScoreServlet() {
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
		Score score = new Score();

		try {
			BeanUtils.populate(score, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (score.getDorm_id() == "" || score.getNeat() == ""
				|| score.getClear() == "" || score.getSmell() == ""
				|| score.getDiscipline() == "" || score.getScore_sum() == "") {
			request.setAttribute("msg", "增加评分信息时不能存在未填信息");
			request.getRequestDispatcher("/score.jsp").forward(request,
					response);
		} else {

			ScoreUtils scoreUtils = new ScoreUtils();
			try {
				scoreUtils.insertScore(score);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			out.print("宿舍ID为" + score.getDorm_id() + "的评分信息已经增加成功");
			out.print("</br>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>增加评分信息</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("</br>");
			out.println("<a href='/dorm/score.jsp'>返回</a>");
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
