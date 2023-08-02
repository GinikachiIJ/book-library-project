<!-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"></meta>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap for CSS for quicker process -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous">

<title>Book Library</title>

<link rel="stylesheet" href="./css/bookCSS.css" type="text/css"/>

</head>

<body>
	<h1>Book Library</h1>

	
	<!-- Table displaying books in database -->


	<!-- Top page navigation -->
	<!-- <div class="navcontainer"> -->
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Navbar</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="index.html">Home</a></li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Menu </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="./insert">Insert
										Book</a></li>
								<li><a class="dropdown-item" href="./update">Update
										Book</a></li>
								<!--  <li><hr class="dropdown-divider"></li> -->
								<!--  <li><a class="dropdown-item" href="./delete">Delete Book</a></li>-->
							</ul></li>
					</ul>
					<!-- <form class="d-flex" role="search" action="./search" method="Get">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form> -->
				</div>
			</div>
		</nav>
	<!-- </div> -->

	<div class="container">
		<table class="table table-striped">
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Date</th>
				<th>Genres</th>
				<th>Characters</th>
				<th>Synopsis</th>
				<th>Edit</th>
				<th>Delete</th>
				<!-- <th>Search</th> -->
				<th>Insert</th>
				
			</tr>
			
				<c:forEach items="${books}" var="b">
					<tr>
						<td>${b.id}</td>
						<td><b>${b.title}</b></td>
						<td>${b.author}</td>
						<td><b>${b.date}</b></td>
						<td>${b.genres}</td>
						<td><b>${b.characters}</b></td>
						<td>${b.synopsis}</td>
						<th><a href='./update?id=${b.id}'>Edit</a></th>
						<th><a href='./delete?id=${b.id}'>Delete</a></th>
						<!-- <th><a href='./search?id=${b.id}'>Search</a></th> -->
						<th><a href='./insert?id=${b.id}'>Insert</a></th>
					</tr>
				</c:forEach>
			
		</table>
	</div>



	<!-- Pagination using bootstrap link. Code snipet from Bootstrap documentation: https://getbootstrap.com/docs/4.0/components/pagination/ -->
	<!-- <nav aria-label="Pagination"> -->
	<!--   <ul class="pagination flex-wrap justify-content-end"> -->
	<!--     <li class="page-item disabled"> -->
	<!--       <a class="page-link" href="#" tabindex="-1">Previous</a> -->
	<!--     </li> -->
	<!--     <li class="page-item"><a class="page-link" href="#">1</a></li> -->
	<!--     <li class="page-item"><a class="page-link" href="#">2</a></li> -->
	<!--     <li class="page-item"><a class="page-link" href="#">3</a></li> -->
	<!--     <li class="page-item"><a class="page-link" href="#">4</a></li> -->
	<!--     <li class="page-item"><a class="page-link" href="#">5</a></li> -->
	<!--     <li class="page-item"><a class="page-link" href="#">6</a></li> -->
	<!--         <li class="page-item"><a class="page-link" href="#">7</a></li> -->
	<!--     <li class="page-item"><a class="page-link" href="#">8</a></li> -->
	<!--     <li class="page-item"><a class="page-link" href="#">9</a></li> -->
	<!--         <li class="page-item"><a class="page-link" href="#">10</a></li> -->
	<!--     <li class="page-item"> -->
	<!--       <a class="page-link" href="#">Next</a> -->
	<!--     </li> -->
	<!--   </ul> -->
	<!-- </nav> -->


<!-- Bootstrap JS and Popper -->

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js"
		integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i"
		crossorigin="anonymous"></script>

</body>
</html>