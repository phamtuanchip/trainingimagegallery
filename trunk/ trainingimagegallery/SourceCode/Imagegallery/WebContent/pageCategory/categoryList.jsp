<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Category</title>
</head>
<body>
	<s:form action="CategoryAdd" >
	<br><br><br>
	<table border="0" align="center" >
	<tr>
	<td><s:text name="Category Name:"></s:text></td>
	<td><s:textfield name="categoryForm.name" ></s:textfield></td>
	</tr>
	<tr>
	<td><s:text name="Description:"></s:text></td>
	<td><s:textarea name="categoryForm.description" rows="2" cols="15"  ></s:textarea></td>
	</tr>
	<tr>
	<td>
	<br>
	<br>
	</td>
	</tr>
	<tr>
		<td></td>
		<td><s:submit name="sumbmit"></s:submit>
		<a href="ListImage"><input type="button" value="Back to List Image"/></a></td>
	</tr>
	</table>
	</s:form>
	
	<br><br><br><br>
	<table align="center" border="1">
	<thead>
		<tr>
			<th>STT</th>
			<th>Name</th>
			<th>Description</th>
			<th>Date Create</th>
		</tr>
		</thead>
		<tbody>
		<s:iterator value="categoryList" status="status">
		<tr>
			<td><s:property value="%{#status.count}" /></td>
			<td><s:property value="name" /></td>
			<td><s:property value="description" /></td>
			<td><s:property value="dateCreate" /></td>
		</tr>
		</s:iterator>
		</tbody>
	</table>
	
</body>
</html>