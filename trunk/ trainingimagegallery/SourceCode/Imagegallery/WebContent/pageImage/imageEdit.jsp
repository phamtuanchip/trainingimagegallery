<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Image</title>
</head>
<body>
		<div align="center">
	<!--  <div id="wrapper" >-->
		<h3>Form Edit Image</h3>
		<s:form action="updateImage" method="POST" enctype="multipart/form-data">
		<table border="0" align="center">
			<tr>
				<td><s:text name="Image Name" ></s:text></td>
				<td><s:textfield name="imageForm.img_name"  value="%{image.img_name}" ></s:textfield></td>
			</tr>
			<tr>
				<td><s:text name="Description" ></s:text></td>
				<td><s:textarea name="imageForm.img_description" value="%{image.img_description}" ></s:textarea></td>
			</tr>
			<tr>
				<td><s:text name="User Upload" ></s:text></td>
				<td><s:textfield name="imageForm.img_user_upload" value="%{image.img_userUpLoad}"  ></s:textfield></td>
			</tr>
			<tr>
				<td><s:text name="Category" ></s:text></td>
				<td><s:select list="listCategory" name="category_name" listValue="name" listKey="name" value="%{name}" headerKey="%{categoryImage.name"  headerValue="%{categoryImage.name}" ></s:select></td>
			</tr>
			<tr>
				<td></td>
				<td><img height="60" width="60" src=" <s:url action='imageAction?imageId=%{image.id}'/>"/><td>
			</tr>
			<tr>
				<td><s:text name="upload Image" ></s:text></td>
				<td><s:file name="imageForm.file" label="fileImage"></s:file></td>
			</tr>
		</table>
		<p align="center"><s:submit name="submit"></s:submit></p>
		</s:form>
		</div>			
</body>
</html>