package com.sample.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.controler.PoneyDao;
import com.sample.model.PoneyBean;

@WebServlet("/byName")
public class RedirectByNameServlet extends HttpServlet {
	private static final String NPONEY = "nponey";
	private static final long serialVersionUID = 1L;
	private PoneyDao dao;
       
    public RedirectByNameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getDao();
		PoneyBean randPoney=this.dao.getPoneyByName(request.getParameter("name"));
		request.setAttribute(NPONEY, randPoney);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/displayByName.jsp" ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//DO NOTHING
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
