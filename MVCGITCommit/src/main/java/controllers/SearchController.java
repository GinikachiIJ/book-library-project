package controllers;

import java.io.IOException;
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

@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDAO dao = new BookDAO();
		String searchStr = request.getParameter("search");
		System.out.println(searchStr);
		ArrayList<Book> searchBook = dao.searchBook(searchStr);
		System.out.println(searchBook.size());

		request.setAttribute("books", searchBook);
		RequestDispatcher rd = request.getRequestDispatcher("book.jsp");
		rd.include(request, response);

		// int id_update = Integer.parseInt(request.getParameter("update_id"));

		// Book isUser;
		// isUser = dao.searchBook(id_update);
		// request.setAttribute("users", isUser);
		// RequestDispatcher rdo = request.getRequestDispatcher("search.jsp");
		// rdo.forward(request, response);

	}
	/*
	 * else { BookDAO dao = new BookDAO(); ArrayList<Book>allCons =
	 * dao.getAllBooks(); request.setAttribute("books", allCons); RequestDispatcher
	 * rd = request.getRequestDispatcher("books.jsp"); rd.include(request,
	 * response);
	 */

	// request.getRequestDispatcher("search.jsp").forward(request, response);

	// for(Book b: searchBook) {
	// System.out.println(b.toString());

//		int id = Integer.parseInt(request.getParameter("id"));
//		Book bk = dao.getBookByID(id);
//

	// String searchStr = request.getParameter("search");
	// ArrayList<Book> searchBook = dao.searchBook(searchStr);

	// for(Book b: searchBook) {
	// System.out.println(b.toString());

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		BookDAO dao = new BookDAO();
//
//		int id_edit = Integer.parseInt(request.getParameter("id_edit"));
//		String title = request.getParameter("title_edit");
//		String author = request.getParameter("author_edit");
//		String  date = request.getParameter("date_edit");
//		String genres = request.getParameter("genres_edit");
//		String characters = request.getParameter("characters_edit");
//		String synopsis = request.getParameter("synopsis_edit");
//
//		Book searchBook = new Book(id_edit, title, author, date, genres, characters, synopsis);
//
//		try {
//			
//			dao.searchBook(searchBook);
//
//			System.out.println("id_edit");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println(e);
//		
//		}
//		response.sendRedirect("./book");
//
	}
}
