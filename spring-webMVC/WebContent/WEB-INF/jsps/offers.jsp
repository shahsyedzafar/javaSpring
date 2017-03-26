<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">
<title>Insert title here</title>
</head>
<body>
	<table border="1px" class="offersTable">
		<tr>
			<th>Id: </th>
			<th>Name: </th>
			<th>Email: </th>
			<th>Value: </th>
		</tr>

<c:forEach var="offer" items="${offers}">
		<tr>
			<td>${offer.id}</td>
			<td>${offer.name}</td>
			<td>${offer.email}</td>
			<td>${offer.value}</td>
		</tr>
</c:forEach>

</table>
</body>
</html>