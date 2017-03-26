<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
</style>

</head>
<body>
<sf:form action="${pageContext.request.contextPath}/doCreate" method="post" commandName="offer">

	<table class="formTable" >
		<tr><td class="label" >Name: </td><td><sf:input path = "name" type="text" class= "control" name = "name"  /><br><sf:errors path = "name" cssclass="error" /> </td></tr>
		<tr><td class="label" >Email: </td><td><sf:input type="email" path = "email" class= "control" name = "email"  /><br><sf:errors path = "email" cssclass="error" /></td></tr>
		<tr><td class="label" >Offer: </td><td> <sf:textarea class= "control" path = "value" rows="10" cols="10"></sf:textarea><br><sf:errors path = "value" cssclass="error" /></td></tr>
		<tr><td class="label" ></td><td><input class= "control" type="submit" value = "CreateAdvert" /></td></tr>
	</table>

</sf:form>
s
</body>
</html>