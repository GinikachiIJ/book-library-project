package controllers;

import java.io.IOException;

import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import database.BookDAO;
import models.Book;
	    

@WebServlet("/insert")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.getRequestDispatcher("insert.jsp").forward(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		BookDAO dao = new BookDAO();
		
		int id_edit = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String  date = request.getParameter("date");
		String genres = request.getParameter("genres");
		String characters = request.getParameter("characters");
		String synopsis = request.getParameter("synopsis");

		Book insertBook = new Book(id_edit, title, author, date, genres, characters, synopsis);

		    try {  
		    dao.insertBook(insertBook); 

			System.out.println("id" + " title" + " author" + " date" + " genres" + " characters" + " synopsis");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		response.sendRedirect("./books");

	}


}