package cbc.controller.score;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbc.utils.ScoreUtils;

public class DeleteAllServelt extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteAllServelt() {
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
          ScoreUtils scoreUtils = new ScoreUtils();
          scoreUtils.deleteAll();
          request.setAttribute("msg", "所有信息已清楚可以点击查询所有查看");
			request.getRequestDispatcher("/score.jsp").forward(request,
					response);
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
