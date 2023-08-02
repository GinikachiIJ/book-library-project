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


@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			BookDAO dao = new BookDAO();
			
			
			
				int id_deleted =Integer.parseInt(request.getParameter("id"));
				//boolean compDeleted = false;
				
				
			
				//c.setId(id);
				

			    try {
			    	Book bk = dao.getBookByID(id_deleted);
					dao.deleteBook(bk);
					//compDeleted = true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//compDeleted = false;
				}
				response.sendRedirect("./books");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}

