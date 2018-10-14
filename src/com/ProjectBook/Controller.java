package com.ProjectBook;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name="";
    String author="";
    String price="";
 
	/**
	 * @return 
	 * @see HttpServlet#HttpServlet()
	 */
    public Controller() {
        
    }
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		name = request.getParameter("nameLis");
		author = request.getParameter("authorLis");
		price = request.getParameter("priceLis");
		Get model = new Get();
		if(name!=null)
			model.setName(name);
		else if(author!=null)
			model.setAuthor(author);
		else if(price!=null)
			model.setPrice(price);
		
		Connection model1 = new Connection();
		
		
		
		model1.createConnection();
		
		request.setAttribute("id", model.id);
		request.setAttribute("name", model.name);
		request.setAttribute("author", model.author);
		request.setAttribute("price", model.price);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/View2.jsp");
		dispatcher.forward(request, response);
		
	}
		
	
}