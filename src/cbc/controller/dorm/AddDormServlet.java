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

public class AddDormServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddDormServlet() {
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
        
		response.setCharacterEncoding("GB2312");//设置返回链接
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String bedsum = request.getParameter("bedsum");
        String usedbed = request.getParameter("usedbed");
        String houseparent = request.getParameter("houseparent");
        String remarks = request.getParameter("remarks");
        if(name==""||id==""||bedsum==""||usedbed==""||houseparent==""||remarks==""){
        	request.setAttribute("msg", "增加用户时不能存在未填信息");
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
            DormService dormService = new DormService();
			int result = dormService.addDorm(dorm);
			if (result == DormService.NAMEEXIST) {
				request.setAttribute("msg", "宿舍名已经存在！");
				request.getRequestDispatcher("/dorm.jsp").forward(request,
						response);
			} else if (result == DormService.IDEXIST) {
				request.setAttribute("msg", "ID已被使用！");
				request.getRequestDispatcher("/dorm.jsp").forward(request,
						response);
			} else if (result == DormService.SUCCESS) {
				out.print("恭喜你。宿舍ID为"+dorm.getId()+"的宿舍信息已经增加成功");
		        out.print("</br>");
		        out.println("<html>");
				out.println("<head>");
				out.println("<title>增加寝室信息</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("</br>");
				out.println("<a href='/dorm/dorm.jsp'>返回</a>");
				out.println("</body>");
				out.println("</html>");
			}
			out.flush();
			out.close();
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

