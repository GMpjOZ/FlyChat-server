package cn.flaychat.servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.flaychat.service.LocationServer;
import cn.flaychat.util.GsonUtil;

/**
 * Servlet implementation class PostLocationServlet
 */
@WebServlet("/PostLocationServlet")
public class PostLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	 private LocationServer ls=(LocationServer) ac.getBean("locationServer");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostLocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	double latitude=Double.parseDouble(request.getParameter("latitude"));
	double longitude=Double.parseDouble(request.getParameter("longitude"));
	int id=Integer.parseInt(request.getParameter("id"));
	
	ls.saveLocation(latitude, longitude, id);
	GsonUtil.packGsonList(null, 200, " 发送成功", response);
	
	}

}
