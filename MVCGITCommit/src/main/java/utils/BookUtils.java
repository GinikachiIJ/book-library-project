package utils;

import java.util.ArrayList;

import java.util.HashMap;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;


import models.Book;
import database.BookDAO;

public class BookUtils {

	private static ArrayList<Book> books = new ArrayList<>();

	static {
		books.add(new Book(1000, "Half of a yellow sun", "Chimamanda Adichie", "09/14/10",
				"Young Adult, Fiction, Dystopia, Fantasy, Science Fiction, Romance, Adventure, Teen, Post Apocalyptic, Action",
				"Ada, Obi, Elo", "'Blah, blah, blah'"));

	}

	public static ArrayList<Book> getAllBooks() {
		return books;
	}

  public static HashMap<String, String> requestStringToMap(String request) {
	HashMap<String, String> map = new HashMap<String, String>();
    String[] pairs = request.split("&");
		 for (int i = 0; i < pairs.length; i++) {
		 String pair = pairs[i];

		 try {
		 String key = pair.split("=")[0];
		        key = URLDecoder.decode(key, "UTF-8");

		 String value = pair.split("=")[1];
		        value = URLDecoder.decode(value, "UTF-8");

		        map.put(key, value);
		 } catch (UnsupportedEncodingException e) {
		        System.err.println(e.getMessage());
		      }

		    }
		    return map;
		  }	
  
}
	
	
	
