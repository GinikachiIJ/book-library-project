<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="./bookCSS/site.css" rel="stylesheet">
</head>
<body>
   
<div class="searchForm">
<form action="./search" method="Get">
  <div class="form-group">
    <input name="id" type="text" class="form-control" placeholder="Search">
    </div>
    <button type="submit" class="btn btn-primary">Search</button>
   </form>
  </div>

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

</body>
</html> --%>