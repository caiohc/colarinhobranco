package colarinhobranco.web.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import colarinhobranco.dao.NewsDao;
import colarinhobranco.daoimpl.NewsDaoImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/news/show")
public class ShowServlet extends HttpServlet {
	
	private NewsDao newsDao = new NewsDaoImpl();
		
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		Integer newsId = new Integer(request.getParameter("newsId"));
		
		request.setAttribute("news", newsDao.get(newsId));
		
		request.getRequestDispatcher("/pages/news/show.jsp").forward(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		doGet(request, response);
		
	}
	
}