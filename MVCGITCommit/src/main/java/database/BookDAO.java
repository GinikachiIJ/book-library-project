package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import models.Book;

public class BookDAO {

	Book oneBook = null;
	Connection conn = null;
	Statement stmt = null;
      String user = "root";
	String password = "XXXXj86%%#";
	
	// Note none default port used, 6306 not 3306
	//String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/" + user;
	//String url = "jdbc:mysql://db-book-app.ctsjg1f2c0yc.eu-north-1.rds.amazonaws.com:3306/" + user;
	String url = "jdbc:mysql://db-book-app.ctsjg1f2c0yc.eu-north-1.rds.amazonaws.com/jessica";
	

	public BookDAO() {
	}

	private void openConnection() {
		// loading jdbc driver for mysql
		try {
			Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			System.out.println(e);
		}

		// connecting to database
		try {
			// connection string for demos database, username demos, password demos
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
		} catch (SQLException se) {
			System.out.println(se);
		}
	}

	private void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Book getNextBook(ResultSet rs) {
		Book thisBook = null;
		try {

			thisBook = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("date"),
					rs.getString("genres"), rs.getString("characters"), rs.getString("synopsis"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thisBook;
	}

	public ArrayList<Book> getAllBooks() {

		ArrayList<Book> allBooks = new ArrayList<Book>();
		openConnection();

		// Create select statement and execute it
		try {
			String selectSQL = "select * from books";
			ResultSet rs1 = stmt.executeQuery(selectSQL);
			// Retrieve the results
			while (rs1.next()) {
				oneBook = getNextBook(rs1);
				allBooks.add(oneBook);
			}

			stmt.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}

		return allBooks;
	}

	public Book getBookByID(int id) {

		openConnection();
		oneBook = null;
		// Create select statement and execute it
		try {
			String selectSQL = "select * from books where id=" + id;
			ResultSet rs1 = stmt.executeQuery(selectSQL);
			// Retrieve the results
			while (rs1.next()) {
				oneBook = getNextBook(rs1);
			}

			stmt.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}

		return oneBook;
	}

	public boolean insertBook(Book b) throws SQLException {
		openConnection();
		boolean bok = false;
		try {
			String sql = "insert into books (id, title, author, date, genres, characters, synopsis) values ('"
					+ b.getId() + "','" + b.getTitle() + "' ,'" + b.getAuthor() + "' ,'" + b.getDate() + "' ,'"
					+ b.getGenres() + "' ,'" + b.getCharacters() + "' ,'" + b.getSynopsis() + "');";
			System.out.println(sql);
			bok = stmt.execute(sql);
			closeConnection();
			bok = true;
		} catch (SQLException s) {
			throw new SQLException("Book Not Added");
		}
		return bok;
	}

//	public boolean updateContact(Contact c) throws SQLException {
//		boolean b = false;
//		// YOUR CODE HERE
//		return b;
//	}

	public boolean deleteBook(Book b) throws SQLException {
		boolean bok = false;
		openConnection();
		try {
			String sql = "DELETE FROM books WHERE id = " + b.getId();
			System.out.println(sql);
			bok = stmt.execute(sql);
			closeConnection();
			bok = true;
		} catch (SQLException s) {
			s.printStackTrace();
			throw new SQLException("Book Not Added");
		}
		return bok;
	}

	public boolean updateBook(Book b) throws SQLException {
		boolean bok = false;
		openConnection();
//		try {
			//String sql = "UPDATE FROM books WHERE id = " + b.getId();
			//String sql = "UPDATE books SET atitle = ?, author = ?, date = ?, genres = ?, characters = ?, synopsis = ? WHERE id = ?";
		
			String sql = "UPDATE books SET title=?, author=?, date=?, genres=?, characters=?, synopsis=? WHERE id=?";
			try {   
//					   "title = '" + b.getTitle() + "'," + 
//			           "author = '" + b.getAuthor() + "'," +
//					     "date = '" + b.getDate() + "'," +
//					   "genres = '" + b.getGenres() + "'," +
//				    "characters = '" + b.getCharacters() + "'," +
//				    "synopsis = '" + b.getSynopsis() + " " +
//				    "WHERE id = " + b.getId() + ";";
			
			 PreparedStatement pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, b.getTitle());
		        pstmt.setString(2, b.getAuthor());
		        pstmt.setString(3, b.getDate());
		        pstmt.setString(4, b.getGenres());
		        pstmt.setString(5, b.getCharacters());
		        pstmt.setString(6, b.getSynopsis());
		        pstmt.setInt(7, b.getId());
		        int rowsUpdated = pstmt.executeUpdate();
		        
		       if (rowsUpdated > 0) {
		    	   bok = true;
		    	   System.out.println("Book update successful");
		    	   
		       }else {
		    	   System.out.println("Book not found");
		       }		
//			System.out.println(sql);
//			bok = stmt.execute(sql);
//			closeConnection();
//			bok = true;
		} catch (SQLException s) {
			s.printStackTrace();
			throw new SQLException("Book Not Added");
		}
		return bok;
	}
	
	
	/*public boolean newBook(Book b) throws SQLException {
		boolean bok = false;
		try {
			String sql = "UPDATE FROM books WHERE id = " + b.getId();
			System.out.println(sql);
			bok = stmt.execute(sql);
			closeConnection();
			bok = true;
		} catch (SQLException s) {
			throw new SQLException("Book Not Added");
		}
		return bok;*/
	
	public ArrayList<Book> searchBook(String searchStr) {

		ArrayList<Book> searchBook = new ArrayList<Book>();
		openConnection();
		//oneBook = null;
		// Create select statement and execute it
		try {
			String searchSQL = "select * from books where title LIKE '%" + searchStr + "%';";//' OR genres LIKE '%\" + searchStr + \"%' OR author LIKE '%\" + searchStr + \"%' OR date LIKE '%\" + searchStr + \"%';";
			System.out.println(searchSQL);
			ResultSet rs1 = stmt.executeQuery(searchSQL);
			// Retrieve the results
			while (rs1.next()) {
				
				oneBook = getNextBook(rs1);
				searchBook.add(oneBook);
				
				
			}

			stmt.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}
        return searchBook;
	}
	}

