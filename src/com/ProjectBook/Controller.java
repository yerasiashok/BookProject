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
	public String name;
	public String author;
	public String price;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Get model = new Get();
		String Name = request.getParameter("nameLis");
		String Author = request.getParameter("authorLis");
		int Price = Integer.parseInt(request.getParameter("priceLis"));
		
		Connection modeln = new Connection();
		 
		model=modeln.createConnection();

		request.setAttribute("bookrecord",model);
		RequestDispatcher view = request.getRequestDispatcher("view2.jsp");
        view.forward(request, response);
    }
	}


