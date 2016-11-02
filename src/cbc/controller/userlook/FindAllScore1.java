package cbc.controller.userlook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbc.model.Score;
import cbc.utils.ScoreUtils;

public class FindAllScore1 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FindAllScore1() {
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
		ScoreUtils scoreUtils = new ScoreUtils();
		List<Score> scores = new ArrayList<Score>();
		scores = scoreUtils.findAll();
		
		 PrintWriter out = response.getWriter();
		
		    for (Score score:scores) {
		    	
		    	out.print("��������IDΪ:");
				out.println(score.getDorm_id());
				out.print("���������Ϊ:");
				out.println(score.getNeat());
				out.print("���ȸɾ���Ϊ:");
				out.println(score.getClear());
				out.print("������ζ��Ϊ:");
				out.println(score.getSmell());
				out.print("���ȼ��ɷ�Ϊ:");
				out.println(score.getDiscipline());
				out.print("��������ܷ�Ϊ:");
				out.println(score.getScore_sum());
				
				out.print("����ʱ��Ϊ:");
				out.println(score.getUpdate_date());
				
				
				out.println("</br>");
				
			}
	        response.setContentType("text/html");
	        out.println("<html>");
			out.println("<head>");
			out.println("<title>��ѯ����������Ϣ</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("</br>");
			out.println("<a href='/dorm/userlook.jsp'>����</a>");
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
