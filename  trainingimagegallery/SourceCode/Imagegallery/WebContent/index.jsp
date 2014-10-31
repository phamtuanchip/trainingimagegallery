<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form action="CategoryAdd" >
	<table border="0" align="center" >
	<tr>
	<td><s:text name="category Name:"></s:text></td>
	<td><s:textfield name="categoryForm.name" ></s:textfield></td>
	</tr>
	<tr>
	<td><s:text name="Description:"></s:text></td>
	<td><s:textarea name="categoryForm.description" ></s:textarea></td>
	</tr>
	</table>
	<p align="center"><s:submit name="sumbmit"></s:submit></p>
	</s:form>
	<s:form action="imageAdd">
		<s:submit name="add Image"></s:submit>
	</s:form>
</body>
</html>