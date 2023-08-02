<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"></meta>
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      
<!-- Bootstrap for CSS for quicker process -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
 rel="stylesheet" 
 integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
 crossorigin="anonymous">
 
<title>Book Library:Insert Books</title>

<link rel="stylesheet" href="./css/bookCSS.css" type="text/css"/>    
</head>

<body>
	<!-- <span>${book.title}</span> -->
	<h1>Book Library: Add Book</h1>
	
<div class="insertForm">
<form action="./insert" method="Post">
  <div class="form-group">
    <label for="exampleInputid">ID</label>
    <input name="id" type="text" class="form-control" id="exampleInputid" aria-describedby="idHelp" placeholder="Enter ID">
    <!--  <small id="idHelp" class="form-text text-muted">We'll never share your id with anyone else.</small> -->
  </div>
  
  <div class="form-group">
    <label for="exampleInputTitle">Book Title</label>
    <input name="title" type="text" class="form-control" id="exampleInputTitle" placeholder="Book Title">
  </div>
  
    <div class="form-group">
    <label for="exampleInputAuthor">Book Author</label>
    <input name="author" type="text" class="form-control" id="exampleInputAuthor" placeholder="Book Author">
  </div>
  
    <div class="form-group">
    <label for="exampleInputDate">Published Date</label>
    <input name="date" type="date" class="form-control" id="exampleInputTitle" placeholder="Published Date">
  </div>
  
    <div class="form-group">
    <label for="exampleInputGenres">Book Genre</label>
    <input name="genres" type="text" class="form-control" id="exampleInputGenre" placeholder="Book Genre">
  </div>
  
    <div class="form-group">
    <label for="exampleInputCharacters">Book Characters</label>
    <input name="characters" type="text" class="form-control" id="exampleInputCharacters" placeholder="Book Characters">
  </div>
  
    <div class="form-group">
    <label for="exampleInputSynopsis">Book Synopsis</label>
    <input name="synopsis" type="text" class="form-control" id="exampleInputSynopsisS" placeholder="Book Synopsis">
  </div>
  
  <div class="form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Confirm that all fields have been entered</label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>	

<a href = 'index.html'>Back to List </a>


	<!--  <h1>Book Added</h1>
				<table class=\"table\">
					<thead>
						<tr>
							<th>ID</th>
							<th>Title</th>
							<th>Author</th>
							<th>Date</th>
							<th>Genres</th>
							<th>Characters</th>
							<th>Synopsis</th>
						</tr>
						
					</thead>
					<tbody>;
</body>
</html>



"
<h1>Book Added</h1>
<table class=\"table\">
	<thead>

		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Date</th>
			<th>Genres</th>
			<th>Characters</th>
			<th>Synopsis</th>
		</tr>
	</thead>

	<tbody>

		<tr>
			<td>"+ book.getid() + "</td>" + "
			<td>"+ book.gettitle() + "</td>" + "
			<td>"+ book.getauthor() + "</td>" + "
			<td>"+ book.getdate() + "</td>" + "
			<td>"+ book.getgenres() + "</td>" + "
			<td>"+ book.getcharacters() + "</td>" + "
			<td>"+ book.getsynopsis() + "</td>" + "
		</tr>
	</tbody>
</table> -->

<!--  <a>Back to List </a>-->


</body>

</html>

