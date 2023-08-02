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
 
<title>Book Library: Delete Book</title>

<link rel="stylesheet" href="./css/bookCSS.css" type="text/css"/>    
</head>

<body>
<h1>Delete Book</h1>

<div class="deleteForm">
<form>
    <div class="form-group">
    <label for="exampleInputSynopsis">Enter book ID</label>
    <input type="text" class="form-control" id="exampleInputSynopsisS" placeholder="Book ID">
  </div>
  
  <div class="form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Confirm you want to delete this</label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>

<span>${book.id}</span>

</body>

</html>