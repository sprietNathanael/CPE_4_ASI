package com.sample.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.controler.PoneyDao;
import com.sample.model.PoneyBean;

/**
 * Servlet implementation class RedirectAddDataServlet
 */
@WebServlet("/addData")
public class RedirectAddDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	private PoneyDao dao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectAddDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getDao();
		this.dao.addPoney(request.getParameter("name"), request.getParameter("superpower"), request.getParameter("color"), request.getParameter("url-image"));
		this.getServletContext().getRequestDispatcher( "/WEB-INF/displayList.jsp" ).forward( request, response );
		
	}
	
	public void getDao(){
		if(this.getServletContext().getAttribute("DAO")!=null){
			this.dao=(PoneyDao)this.getServletContext().getAttribute("DAO");
		}else{
			this.dao=new PoneyDao();
			this.getServletContext().setAttribute("DAO",this.dao);
		}
	}


}
