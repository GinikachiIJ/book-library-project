package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BookDAO;
import models.Book;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao = new BookDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Book b = dao.getBookByID(id);
		
		request.setAttribute("book", b);
				
		request.getRequestDispatcher("update.jsp").forward(request, response);
		

		    try {
		    	 b = dao.getBookByID(id);
				dao.updateBook(b);
				//compDeleted = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
			}
		
			
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao = new BookDAO();
		
		int id_edit = Integer.parseInt(request.getParameter("id_edit"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String  date = request.getParameter("date");
		String genres = request.getParameter("genres");
		String characters = request.getParameter("characters");
		String synopsis = request.getParameter("synopsis");
		
		Book updateBook = new Book(id_edit, title, author, date, genres, characters, synopsis);
		
		try {
	    	
			dao.updateBook(updateBook);
			System.out.println("Book ID " + "id_edit" + " update successful");

			//System.out.println("id_edit");
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			
		}
		response.sendRedirect("./books");
	
	
}

}
	

