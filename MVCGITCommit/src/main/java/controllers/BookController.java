package controllers;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BookDAO;
import models.Book;


@WebServlet("/books")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//if(request.getParameter("update_id") !=null ) {
		System.out.println("in the book controller");
		BookDAO dao = new BookDAO();
		ArrayList<Book>allCons = dao.getAllBooks();
		System.out.println(allCons.size());
		request.setAttribute("books", allCons);
		RequestDispatcher rd = request.getRequestDispatcher("book.jsp");
		rd.include(request, response);
		
//		int id_update = Integer.parseInt(request.getParameter("update_id"));
//		
//		Book isUser;
//		isUser = dao.getBookByID(id_update);
//		request.setAttribute("users", isUser);
//		RequestDispatcher rdo = request.getRequestDispatcher("books.jsp");
//		rdo.forward(request, response);
//		
//		}else {
//			BookDAO dao = new BookDAO();
//			ArrayList<Book>allCons = dao.getAllBooks();
//			request.setAttribute("books", allCons);
//			RequestDispatcher rd = request.getRequestDispatcher("books.jsp");
//			rd.include(request, response);
//		}
		
		//PrintWriter out = response.getWriter();
		
		//response.setContentType("text/html");
		//out.write("<b>"+contact.getName() + "</b> | " + contact.getEmail() + "<br>");
		//out.close();

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// add contact code here
		int id_edit = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String date = request.getParameter("date");
		String genres = request.getParameter("genres");
		String characters = request.getParameter("characters");
		String synopsis = request.getParameter("synopsis");
		
		
		Book insertBook = new Book(0, title, author, date, genres, characters, synopsis);
		BookDAO dao = new BookDAO();
		
		Boolean newUpdate = false;
		
		/*request.setAttribute("contacts", allCons);
		RequestDispatcher rd = request.getRequestDispatcher("contacts.jsp");
		rd.include(request, response);*/
		
		try {
			newUpdate = dao.insertBook(insertBook);
		}catch(SQLException s) {
			s.printStackTrace();
		}
		response.sendRedirect("./books");
		
	}

}

